function dateIsFuture(date) {
    var date2 = dayStart(currentDate());
    return parseInt(date.format("X")) > parseInt(date2.format("X"));
}

function filterDict(resp){
    return _.filter(resp, function(el) { return dateIsFuture(moment(el["Date"],'DD.MM.YYYY'));});
}

function filterTime(item,idNum){
    var dict = _.omit(item,'Date');
    var l = [];
    for (var key in dict) {
        var valList = dict[key].split(' ');
        if (valList.length > 0 && valList.length <= idNum) {
            l.push(key)
        }
        // if (dict[key] === '') {
        //     l.push(key)
        // }
        
    }
    return l;
}

function responseToDict(resp,idNum){
    var filtered = filterDict(resp);
    var timeDict = filtered.reduce(function(result, item) {result[item["Date"]] = filterTime(item,idNum); return result;}, {});
    var newTimeDict = {};
    for(var key in timeDict) {
        var l = timeDict[key].sort();
        if (l.length !== 0) {
            newTimeDict[key] = l;
        }
        
    }
    return newTimeDict;
}

function formatDict(timeDict) {
    var formattedTimeDict = {};
    for(var key in timeDict) {
        var vals = [];
        for(var i = 0; i < timeDict[key].length;i++) {
            vals.push('\n' + (i + 1) + '. ' + timeDict[key][i]);
        }
        formattedTimeDict[key] = vals;
    }
    return formattedTimeDict;
}