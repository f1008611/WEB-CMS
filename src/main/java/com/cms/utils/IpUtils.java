package com.cms.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ${user} on 14-3-20.
 */
public class IpUtils {
    private static Logger log=Logger.getLogger(IpUtils.class);
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr");
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            log.info("本地="+ip);
            ip = "本地";

        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
            log.info("0"+ip.split(",")[0]);
        }
        return ip;
    }
}
