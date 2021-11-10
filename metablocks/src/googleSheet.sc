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
            integrationId = 36896c21-bda6-4d7d-9217-cabfff371761
            spreadsheetId = 1Hyre-Oa3tQ7t6lB_xxjfplBFQRj-7hrGhH3oq3kJl1o
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   