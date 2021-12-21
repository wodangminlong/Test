package com.example.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * get requests ip address
 *
 * @author dml
 * @date 2021/04/27 14:04
 */
@Slf4j
public class IpUtils {

    private IpUtils() {

    }

    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        String unknownString = "unknown";
        boolean ok = StringUtils.isBlank(ipAddress) || unknownString.equalsIgnoreCase(ipAddress);
        if (ok) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ok) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        // more than one ip address , first ip address is real ip address, get first ip address
        String splitString = ",";
        if (ipAddress != null && ipAddress.contains(splitString)) {
            ipAddress = ipAddress.split(",")[0];
        }
        return ipAddress;
    }

}
