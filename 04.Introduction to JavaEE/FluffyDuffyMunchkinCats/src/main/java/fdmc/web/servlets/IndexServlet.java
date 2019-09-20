package fdmc.web.servlets;

import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private final HtmlReader htmlReader;
   // private final static String INDEX_HTML_PATH = "src/main/resources/views/index.html";
   private final static String INDEX_HTML_PATH = "C:\\Projects\\Bitbucket\\softuni\\Java Web Development Basics\\04.Introduction to JavaEE\\FluffyDuffyMunchkinCats\\src\\main\\resources\\views\\index.html";
    @Inject
    public IndexServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter writer = resp.getWriter();
        String fileContent = htmlReader.readHtmlFile(INDEX_HTML_PATH);
        writer.println(fileContent);
    }
}
