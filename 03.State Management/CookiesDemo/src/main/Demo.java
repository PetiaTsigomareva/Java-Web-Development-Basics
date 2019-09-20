package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> requestInput = getRequestInfo();
      //  System.out.println("Request: " + requestInput.toString());
        Map<String, String> cookies = getCookies(requestInput);
        System.out.println("WITHOUT HTTPCOOKIE CLASS IMPL...");
        printCookies(cookies);


    }

    private static void printCookies(Map<String, String> cookies) {
        for (String cookie : cookies.keySet()) {
            System.out.println(cookie + " < - > " + cookies.get(cookie));
        }

    }

    private static Map<String, String> getCookies(List<String> request) {
        Map<String, String> result = new HashMap<>();
        for (String item : request) {
            if (item.contains("Cookie")) {
                String[] cookiesLine = item.split(":|;\\s+");
                for (int i = 1; i < cookiesLine.length; i++) {
                    String[] cookieParts = cookiesLine[i].split("=");
                    result.put(cookieParts[0], cookieParts[1]);
                }

            }
        }

        return result;
    }


    private static List<String> getRequestInfo() throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        lines.add("\r\n");

        if ((line = reader.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }


        return lines;
    }


}

