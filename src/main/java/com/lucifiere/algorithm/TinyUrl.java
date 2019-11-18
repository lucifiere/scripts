package com.lucifiere.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 * 难度：✨✨✨
 *
 * @author XD.Wang
 * @date 2016/12/23.
 */
public class TinyUrl {

    private Integer counter = 0;

    private static Map<Integer, String> URL_MAPPING = new HashMap<>();

    private static String PREFIX = "http://tinyurl.com/";

    public String encode0(String longUrl) {
        counter++;
        URL_MAPPING.put(counter, longUrl);
        return PREFIX + counter;
    }

    public String decode0(String shortUrl) {
        String count = shortUrl.replace(PREFIX, "");
        return URL_MAPPING.get(Integer.valueOf(count));
    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String testUrl = "http://sdasd.sadsa.cn/12321ddd/232d/1asdadasd";
        String tUrl = tinyUrl.encode0(testUrl);
        System.out.println(tUrl);
        System.out.println(tinyUrl.decode0(tUrl));
        String tUrl1 = tinyUrl.encode1(testUrl);
        System.out.println(tUrl1);
        System.out.println(tinyUrl.decode0(tUrl1));

        String testUrl2 = "http://sdasdss.sads11a.cn/12321ddsddd/232d/1asdadasd";
        String tUrl2 = tinyUrl.encode0(testUrl2);
        System.out.println(tUrl2);
        System.out.println(tinyUrl.decode0(tUrl2));
    }

    private HashMap<String, String> map = new HashMap<>();
    private int count = 1;

    public String getString() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            c--;
            String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            sb.append(chars.charAt(c % 62));
            c = c / 62;
        }
        return sb.toString();
    }

    public String encode1(String longUrl) {
        String key = getString();
        map.put(key, longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    public String decode1(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

}
