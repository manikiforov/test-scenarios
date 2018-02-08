theme: /

    state:
        eg!: DateForTicket
        a: DateForTicket работает!
        
    state:
        eg!: CancelledOnSite
        a: CancelledOnSite работает!
        
    state:
        eg!: CannotPrintTicket
        a: CannotPrintTicket работает!
        
    state:
        eg!: TicketOnMail
        a: TicketOnMail работает!

    state: CatchAll || noContext = true
        q!: *
        a: Я не понял