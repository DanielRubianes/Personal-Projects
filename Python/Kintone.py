from typing import Any
from dataclasses import dataclass

from pprint import pprint
import json

import urllib3
from urllib3 import BaseHTTPResponse

http = urllib3.PoolManager()

@dataclass
class Kintone_App:

    url: str
    api_token: str
    app_id: int

    """Runs multiple get requests to get more than 500 records"""
    def get_records(self, fields: list[str], query: str='', _last_record_id: int = None) -> list[ dict[str, dict[str, str] ] ]:

        bulk_query = f'$id > {_last_record_id}' if _last_record_id else ''
        query = f'({query}) and ' + bulk_query if query and bulk_query else query + bulk_query

        chunk_size = 500

        response: BaseHTTPResponse = http.request(
            "GET", self.url + "records.json",
            headers={"X-Cybozu-API-Token": self.api_token},
            fields= \
            {
                "app": self.app_id,
                # "fields": ','.join(fields+['$id']),
                "query": query + f' order by $id asc limit {chunk_size}',
                "totalCount": True
            }
        )
        response_dict = json.loads( response.data.decode('utf-8') )
        print(query + f' order by $id asc limit {chunk_size}')
        if 'records' not in response_dict:
            pprint(response.data)
        records: list[dict] = response_dict['records']
        total_count = int(response_dict['totalCount'])
        if total_count > chunk_size:
            last_record_id = max(int(record['$id']['value']) for record in records)
            return records + self.get_records(fields, query, last_record_id)
        else:
            return records
        
    """Runs multiple get requests to get more than 500 records"""
    def update_records(self, field: str, new_value: Any, query: str='', _last_record_id: int = None) -> bool:

        records_to_update: list[ dict[str, dict[str, Any] ] ] = self.get_records([field], query)

        update_ids: list[str] = \
        [
            record['$id']['value']
            for record in records_to_update
        ]

        record_updates: list[ dict[str, dict[str, Any] ] ] = \
        [
            {
                'id': id,
                'record': {field: {'value': new_value}}
            }
            for id in update_ids
        ]

        bulk_query = f'$id > {_last_record_id}' if _last_record_id else ''
        query = f'({query}) and ' + bulk_query if query and bulk_query else query + bulk_query

        chunk_size = 100
        for i in range(0, len(record_updates), 100):
            chunk = record_updates[i:i+100]

            payload = \
            {
                "app": self.app_id, # API Test App
                "records": chunk
            }

            response: BaseHTTPResponse = http.request \
            (
                "PUT", self.url + "records.json",
                headers={"X-Cybozu-API-Token": self.api_token,
                    "Content-Type": "application/json"},
                body=json.dumps(payload).encode('utf-8')
            )
            response_dict = json.loads( response.data.decode('utf-8') )
        
            if 'records' in response_dict:
                ids = [record['id'] for record in response_dict['records']]
            else:
                print(response.data)
                print('No records updated!')
                return False
        return True



test_app = Kintone_App('https://throughthetrees.kintone.com/k/v1/', api_token='G6cy4Bt98XYpveGhZkHjhK06EzHPUfK0INVIcbSi', app_id=13)

records: list[ dict[str, dict[str, str] ] ] = test_app.get_records(['Record_Status', 'Record_number', 'Text_1'], '$id = 1')


# Get records and print info out
# print(response.data)
selected_records: list[int] = []
all_fields = []
for record in records:
    # print('=======================')
    # print(record)
    for field, value in record.items():
        if field not in all_fields:
            all_fields.append(field)
        value = value['value']
        if field == 'Record_number':
            selected_records.append(value)
# print( sorted(selected_records, key=lambda x: int(x)) )
print(all_fields)
# print(len(selected_records))
# print(response['totalCount'])

# Update records
test_app.update_records('Test_2', 'Test Value', '')

# Create 500 ton of records
# duped_rows = [
#     {
#         'Record_Status': {'value': 'Need to Order'},
#         'Text_1': {'value': i},
#     }
#     for i in range(501)
# ]
# chunk_size = 100
# for i in range(0, len(duped_rows), 100):
#     chunk = duped_rows[i:i+100]
#     payload = {
#         "app": "13", # API Test App
#         "records": chunk
#     }
#     response: BaseHTTPResponse = http.request(
#         "POST", "https://throughthetrees.kintone.com/k/v1/records.json",
#         headers={"X-Cybozu-API-Token": "G6cy4Bt98XYpveGhZkHjhK06EzHPUfK0INVIcbSi",
#             "Content-Type": "application/json"},
#         body=json.dumps(payload).encode('utf-8')
#     )
#     print(response.data)