theme: /

    init:
        $http.config({
            cacheTimeToLiveInSeconds: 2
        });

    state:
        q!: testCache
        script:
            $temp.m = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: false
            });
            log($temp.m)

            $temp.g = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: true
            });
            log($temp.g)
            
        a: {{JSON.stringify($temp.m.data)}}
        a: {{JSON.stringify($temp.m.data)}}