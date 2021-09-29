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
            integrationId = 317032274471-cabgvbjp71lfkc6nu8qo3cb5dgnn82o8
            spreadsheetId = 1xrINcAJCOZn2J02XZ7ikQfqfSCvcBwrG3Q-P9LCw2lE
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   