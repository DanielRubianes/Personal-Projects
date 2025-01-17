# NOW BROKEN ---FIX WITH NEW RECORD DATA STRUCTURE

import tkinter as tk
from tkinter import messagebox

from Kintone import App as Kintone_App

# Function to show the popup
def show_popup(text: str=""):
    messagebox.showinfo("Popup Title", text)

# Create the main application window
# root = tk.Tk()
# root.title("Main Window")
# root.geometry("300x200")

# # Add a button to trigger the popup
# button = tk.Button(root, text="Show Popup", command=show_popup)
# button.pack(pady=20)

# Run the application
# root.mainloop()

test_app = Kintone_App('https://throughthetrees.kintone.com/k/v1/', api_token='', app_id=13)


# devices_app = Kintone_App('https://throughthetrees.kintone.com/k/v1/', api_token='', app_id=4)
# Fields
# Drop_down_1: Battery Status
# Text_7: Model
# Bay : Bay
# Drop_down_2: Item Status
# Text: Asset Tag

shelf_query = 'Text_7 in ("ProBook 650 G2", "ENVY x360 m6", "Elitebook 840 G3", "Elitebook 840 G5", "Elitebook 850 G3", "Elitebook 850 G5", "Elitebook 8470p", "ROG G752V", "Pavillion G6")'
shelf_query += ' and Drop_down_2 in ("Waiting on Parts", "Waiting on Parts (Ordered)")'
shelf_query += ' and Bay = ""'

records: list[ dict[str, dict[str, str] ] ] = test_app.get_records([''])


# Get records and print info out
all_fields = []
asset_tags: list[str] = []
for record in records:
    # print('=======================')
    # print(record)
    for field, value in record.items():
        if field not in all_fields:
            all_fields.append(field)
        value = value['value']
        if field == 'Text':
            asset_tags += value

# print( sorted(records, key=lambda x: int(x)) )
print(all_fields)
print(len(records))

messagebox.showinfo("Test Portable App", f"{test_app}\nAll fields: {all_fields}\nRecord Count:{len(records)}")

# Update records
# devices_app.update_records('Bay', 'Needs Parts Shelf', shelf_query)

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
#         headers={"X-Cybozu-API-Token": "",
#             "Content-Type": "application/json"},
#         body=json.dumps(payload).encode('utf-8')
#     )
#     print(response.data)