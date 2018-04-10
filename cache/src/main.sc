theme: /

    init:
        $http.config({
            cacheTimeToLiveInSeconds: 20
        });

    state:
        q!: testCache
        script:
            $temp.m = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: true
            });
            log($temp.m)

            $temp.g = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: false
            });
            log($temp.g)
            
            var startTime = $jsapi.currentTime()
            while ($jsapi.currentTime() - startTime < 2000) {};
            
            $temp.y = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: true
            });
            log($temp.y)
            
        a: {{JSON.stringify($temp.m.data)}}
        a: {{JSON.stringify($temp.g.data)}}
        a: {{JSON.stringify($temp.y.data)}}