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

            $temp.g = $http.get('https://www.random.org/strings/?num=3&len=10&digits=on&unique=on&format=plain&rnd=new', {
                cachingRequired: true
            });
            
        a: {{JSON.stringify($temp.m)}}
        a: {{JSON.stringify($temp.m)}}