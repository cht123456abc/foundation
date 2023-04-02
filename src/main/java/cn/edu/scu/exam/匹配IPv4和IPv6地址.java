package cn.edu.scu.exam;

public class 匹配IPv4和IPv6地址 {

    public String solve (String IP) {
        String regex_ipv4 = "(([0-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
        String regex_ipv6 = "(([0-9a-fA-F]{4}|0):){7}([0-9a-fA-F]{4}|0)";

        if (IP.matches(regex_ipv4)) {
            return "IPv4";
        } else if (IP.matches(regex_ipv6)) {
            return "IPv6";
        }
        return "Neither";
    }
}
