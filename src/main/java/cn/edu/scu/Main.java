package cn.edu.scu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



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

    public static void main(String[] args) {
        new Main().solve("172.16.254.1");
    }

}
