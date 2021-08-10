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
            integrationId =  4b9cbc17-2767-4eba-b940-c72dc6e180f3
            spreadsheetId = 1uc63pV39ilPMYRJi3RKgdOpKcnl0SPv0B5VMDGLanSs
            sheetName = Лист1
            body = [{"values": ["yessss6", "yessss6"],"cell": "A2"}]
            okState = /success
            errorState = /error
            
    state: error
        a: error
 
    state: success
        a: ok


   