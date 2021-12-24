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
            integrationId = ea8466a1-8848-4835-9a1e-eff6afd57c20
            spreadsheetId = 1bGjDy7_6pRJ7uf9e63do44WuvC6V6--ZYMh8h4lT2a4
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   