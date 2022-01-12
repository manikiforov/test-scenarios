require: revision.sc
require: tag.sc
require: branch.sc

theme: /

    state:
        q!: $regex</start>
        a: Go
        
    state:
        q!: revision
        go!: /Revision
        
    state:
        q!: tag
        go!: /Tag
        
    state:
        q!: branch
        go!: /Branch