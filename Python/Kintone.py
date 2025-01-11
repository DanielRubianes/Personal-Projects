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

    """Calls get records request (limited to 500 records)"""
    def get_records(self, fields: list[str], query: str=None):
        response: BaseHTTPResponse = http.request(
            "GET", self.url + "records.json",
            headers={"X-Cybozu-API-Token": self.api_token},
            fields=\
            {
                "app": self.app_id,
                "fields": ','.join(fields),
                "query": query,
                "totalCount": True
            }
        )
        response_dict = json.loads( response.data.decode('utf-8') )
        total_count = response_dict['totalCount']
        records: list[dict] = response_dict['records']
        return records


    """Runs multiple get requests to get more than 500 records"""
    def get_bulk_records(self, fields: list[str], query: str='', _last_record_id: int = None):
        
        bulk_query = '$id > ' + _last_record_id if _last_record_id >= 0 else ''
        query = f'({query}) and ' + bulk_query if query and bulk_query else query + bulk_query

        chunk_size = 500
        query += f' order by $id asc limit {chunk_size}'

        response: BaseHTTPResponse = http.request(
            "GET", self.url + "records.json",
            headers={"X-Cybozu-API-Token": self.api_token},
            fields=\
            {
                "app": self.app_id,
                "fields": ','.join(fields+'$id'),
                "query": query,
                "totalCount": True
            }
        )
        response_dict = json.loads( response.data.decode('utf-8') )
        records: list[dict] = response_dict['records']
        total_count = response_dict['totalCount']
        if total_count > chunk_size:
            last_record_id = max(record['$id'] for record in records)
            return records + self.get_bulk_records(self, fields, query, last_record_id)


            
test_app = Kintone_App('https://throughthetrees.kintone.com/k/v1/', api_token='XXXXXXXXXXXXXXXX', app_id=13)

records = test_app.get_records(['Record_Status', 'Record_number', 'Text_1'], 'Record_Status in ("Need to Order")')

# Sending a GET request and getting back response as HTTPResponse object.

# print(response.data)

selected_records: list[int] = []
for record in records:
    print('=======================')
    # print(record)
    for field, value in record.items():
        value = value['value']
        print(f'{field}:  {value}')
        if field == 'Record_number':
            selected_records.append(value)

print(selected_records)
print(len(selected_records))
# print(response['totalCount'])

# Create a shit ton of records
# duped_rows = [
#     {
#         'Record_Status': {'value': 'Need to Order'},
#         'Text_1': {'value': i},
#     }
#     for i in range(505)
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