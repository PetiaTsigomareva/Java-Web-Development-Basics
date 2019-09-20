package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/view/login.jsf", "/view/index.jsf", "/view/register.jsf"})
public class LoggedInUser implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletRequest.getSession().getAttribute("username") != null) {
            httpServletResponse.sendRedirect("/view/home.jsf");
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
