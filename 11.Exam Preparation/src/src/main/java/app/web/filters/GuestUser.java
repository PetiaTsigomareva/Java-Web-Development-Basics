package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/view/home.jsf","/faces/view/home.xhtml", "/view/job-details.jsf", "/view/job-delete.jsf","/view/add-job.jsf"})
public class GuestUser implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String username = (String) httpServletRequest.getSession().getAttribute("username");

        if (username == null) {
            httpServletResponse.sendRedirect("/view/login.jsf");
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
