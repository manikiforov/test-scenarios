theme: /

    init:
        $http.config({
            cacheTimeToLiveInSeconds: 2
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
            
        a: cache {{$temp.m.data}}
        a: no cache {{$temp.g.data}}
        a: cache {{$temp.y.data}}
        
    state:
        q!: testCacheMax
        script:
            $temp.x = $http.get('https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D1%8C%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B9_%D1%80%D0%BE%D0%BA', {
                cachingRequired: true
            });
            log($temp.x)

            $temp.r = $http.get('https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D1%8C%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B9_%D1%80%D0%BE%D0%BA', {
                cachingRequired: false
            });
            log($temp.r)
            
            var startTime = $jsapi.currentTime()
            while ($jsapi.currentTime() - startTime < 2000) {};
            
            $temp.d = $http.get('https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D1%8C%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B9_%D1%80%D0%BE%D0%BA', {
                cachingRequired: true
            });
            log($temp.d)
            
        a: {{JSON.stringify($temp.x)}}
        a: {{JSON.stringify($temp.r)}}
        a: {{JSON.stringify($temp.d)}}