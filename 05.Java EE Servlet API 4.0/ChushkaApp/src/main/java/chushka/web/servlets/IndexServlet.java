package chushka.web.servlets;

import chushka.domain.models.views.AllProductViewModel;
import chushka.service.ProductService;
import chushka.util.HtmlReader;
import chushka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private static final String INDEX_HTML_FILE_PATH = "views/index.html";
    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public IndexServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFileContent = htmlReader.readHtmlFile(INDEX_HTML_FILE_PATH).replace("{{listItems}}", this.formatListItems());


        resp.getWriter().println(htmlFileContent);


    }

    private String formatListItems() {
        List<AllProductViewModel> allProductViewModelList = this.productService.findAllProduct().stream().map(productServiceModel -> this.modelMapper.map(productServiceModel, AllProductViewModel.class)).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();

        allProductViewModelList.forEach(product -> {
            result.append(String.format("<li> <a href= \"/products/details?name=%s\">%s</a></li>", product.getName(), product.getName())).append(System.lineSeparator());
        });

        return result.toString().trim();


    }
}
