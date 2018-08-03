
theme: /

    state:
        q: * start
        script:
            while (true);
        go!: /test

    state: test
        a:  Start processing! {{ $client.test }}
