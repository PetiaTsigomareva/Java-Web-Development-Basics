import main.AppConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1.read the input
        // 1.1 read valid urls line
        List<String> validURLs = getValidURLs();
        // 1.2 read request line
        List<String> requestLineParts = getRequestLineParts();
        // 1.3 read request header lines
        Map<String, String> requestHeader = getRequestHeader();
        // 1.4 read request body
        String requestBody = reader.readLine();
        reader.close();


        System.out.println(AppConstants.PARSING_REQUEST_WITHOUT_CLASSES + "\n");
        String body;
        String statusLine = requestLineParts.get(2);
        // 2.check is url is valid
        if (!validURLs.contains(requestLineParts.get(1))) {
            statusLine += " " + AppConstants.NOT_FOUND;
            body = AppConstants.NOT_FOUND_MESSAGE;
        } else if (!requestHeader.containsKey(AppConstants.HEADER_NAME)) {// 3.check is request contain Authorization header
            statusLine += " " + AppConstants.UNAUTHORIZED;
            body = AppConstants.UNAUTHORIZED_MESSAGE;
        } else if (requestHeader.containsKey(AppConstants.HEADER_NAME) && requestBody.equals("")) {//4. check is request method is POST and have body
            statusLine += " " + AppConstants.BAD_REQUEST;
            body = AppConstants.BAD_REQUEST_MESSAGE;
        } else {//5.Success Request
            // 6.decode authorization user
            String[] authorizationHeaderParts = requestHeader.get(AppConstants.HEADER_NAME).split("\\s+");
            String userName = getDecode64Text(authorizationHeaderParts[1]);
            Map<String, String> bodyParams = getBodyParameters(requestBody);

            if (requestLineParts.get(0).equals(AppConstants.METHOD)) {
                body = getResponseBodyMessage(userName);
            } else {

                body = getResponseBodyMessage(userName, bodyParams);
            }
            statusLine += " " + AppConstants.SUCCESS;

        }

        createHttpResponse(statusLine, requestHeader, body);
    }

    private static String getRequestInfo(List<String> requestLineParts, Map<String, String> requestHeader, String requestBody) {
        StringBuilder result = new StringBuilder();

        return result.toString();
    }

    private static void createHttpResponse(String responseStatusLine, Map<String, String> headers, String responseBody) {
        StringBuilder response = new StringBuilder();
        response.append(responseStatusLine).append("\n");

        for (String headerKey : new String[]{"Date", "Host", "Content-Type"}) {
            String headerValue = headers.get(headerKey);
            if (headerValue != null) {
                response.append(headerKey + ": " + headerValue).append("\n");
            }
        }
        response.append("\n");
        response.append(responseBody);
        System.out.println(response.toString());
    }

    private static List<String> getValidURLs() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static List<String> getRequestLineParts() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static Map<String, String> getRequestHeader() throws IOException {
        Map<String, String> result = new HashMap<String, String>();
        String line;
        do {
            line = reader.readLine();
            if (line.length() > 0) {
                String[] inputLineParts = line.split(":\\s+");
                result.put(inputLineParts[0], inputLineParts[1]);
            }
        } while (line != null && line.length() > 0);
        return result;
    }

    private static boolean checkRequestHeaders(Map<String, String> headers) {
        boolean result = false;
        if (headers.containsKey("Host") && headers.containsKey("Date") && headers.containsKey("Content-Type")) {
            result = true;
        }

        return result;

    }

    private static String getDecode64Text(String text) {

        byte[] byteArray = Base64.getDecoder().decode(text);
        return new String(byteArray);
    }

    private static Map<String, String> getBodyParameters(String body) {
        Map<String, String> result = new HashMap<String, String>();
        List<String> templ = Arrays.asList(body.split("&"));

        for (String t : templ) {
            String[] templElements = t.split("=");
            result.put(templElements[0], templElements[1]);
        }
        return result;

    }

    private static String getResponseBodyMessage(String userName) {
        StringBuilder result = new StringBuilder();

        result.append(AppConstants.GREETING).append(userName).append("!");

        return result.toString();


    }

    private static String getResponseBodyMessage(String userName, Map<String, String> bodyParam) {
        StringBuilder result = new StringBuilder();
        result.append(AppConstants.GREETING).append(userName).append(AppConstants.SUCCESSFUL_CREATED).append(bodyParam.get(AppConstants.NAME)).append(" with ");
        boolean isFirst = true;

        for (String key : bodyParam.keySet()) {
            if (!key.equals(AppConstants.NAME)) {

                if (!isFirst) {
                    result.append(", ");
                }
                result.append(key).append(" - ").append(bodyParam.get(key));
                isFirst = false;
            }
        }

        result.append(".");
        return result.toString();

    }


}

