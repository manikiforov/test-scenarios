require: helpers.js
  module = sys.zfl-common
  
theme: /
    
    state: Start
        q!: google
        a: Начнём.
        go!: /1
        
    state: 1
        GoogleSheets:
            operationType = writeDataToCells
            integrationId = 0d6bbcce-456a-472c-bddf-f409131f6b60
            spreadsheetId = 1xIIeZfhIFHOTBvhBbKUxv-AQxEQJ2IxgFySPsEw7Kas
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   