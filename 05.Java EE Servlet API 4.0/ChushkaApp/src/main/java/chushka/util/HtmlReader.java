package chushka.util;

import java.io.*;

public class HtmlReader {

    public String readHtmlFile(String htmlFilePath) throws IOException {
        InputStream inputStream = HtmlReader.class.getClassLoader().getResourceAsStream(htmlFilePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder htmlFileContent = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            htmlFileContent.append(line).append(System.lineSeparator());
        }
        return htmlFileContent.toString().trim();
    }
}
