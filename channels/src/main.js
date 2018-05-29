var Test = (function() {
    function testErrorThrowing() {
        throw new Error('this is from testErrorThrowing()');
    }

    return {
        testErrorThrowing:testErrorThrowing
    }
})();