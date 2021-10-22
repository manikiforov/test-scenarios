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
            integrationId = 52e4f763-7da7-41f0-9568-b185314d2678
            spreadsheetId = 1AfzEhFOcF0p27ABvCDPuhRQMBvDBOQ6SRmOsWCknHao
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   