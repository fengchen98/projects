// 统一从 url 获取参数的方法
function getParamValue(urlkey) {
    var param = location.search; // ?k1=v1&k2=v2
    param = param.substring(1); // k1=v1&k2=v2
    var paramArr = param.split("&"); // k1=v1 | k2=v2
    for (var i = 0; i < paramArr.length; i++) { // k1=v1
        var item = paramArr[i].split("="); // key,value
        if (item[0] == urlkey) {
            return item[1];
        }
    }
    return null;
}