/**
 * 这个js是为MMB写的工具包js：MMBCommonsUtil.js
 * @author Echo
 */

/**
 * 
 * @param {Object}
 *            stringWithColon
 */
function replaceColonWithEscapeCharacter(stringWithColon) {
    return stringWithColon.replace(":", "\:").replace("\\", "\\\\");
}

/**
 * Format: ISO 8601;  YYYY-MM-DDThh:mm:ssTZD
 * Example: 2017-07-17T13:42:40+01:00(MMB支付时要求的时间格式)
 * Example: 2017-11-03T02:59:24.460Z(实际返回的时间格式)
 * 
 * @param {Object}
 *            timeInterval: 时间间隔分钟数
 */
function timeToSessionValidityConvertor(timeInterval) {
    var currentTime = new Date();
    var currentTime_15min = currentTime.getTime() + timeInterval * 60 * 1000;
    var retVal = new Date(currentTime_15min);
    return retVal.toISOString();
}
