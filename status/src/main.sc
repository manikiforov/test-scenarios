theme: /


    state:
        q!: test 1
        script:
            log("before get");
            $http.get('http://localhost:9001/method1').then( function (data) {
                $response.data = data;
            });
        a: {{ $response.data.response }}

    state:
        q!: test 2
        script:
            log("before get");
            $http.get('http://localhost:9001/method2').then( function (data) {
                $response.data = data;
            });
        a: {{ $response.data.response }}

    state:
        q!: test 3
        script:
            $response.status = $http.get('http://localhost:9001/401').status
        a: статус {{ $response.status }}

    state:
        q!: test 4
        script:
            $response = $http.get('http://localhost:9001/parameters?p1=${param1}&p2=${param2}', {
                query: {
                  param1: 1,
                  param2: 2
                }
            })
        a: {{ $response.data }}

    state:
        q!: test 5
        script:
            $response = $http.get('http://example.com/${path}/?param1=${p1}&param2=${p2}', {
                query: {
                  path: 'путь',
                  p1: 'value 1',
                  p2: 'value 2'
                }
            });
        a: {{ $response.data }}


    state: CatchAll
        q!: *
        a: CatchAll
