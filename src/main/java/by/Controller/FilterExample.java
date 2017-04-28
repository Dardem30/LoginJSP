package by.Controller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by УВД on 27.04.2017.
 */
public class FilterExample implements Filter {
    private boolean active=false;
    private FilterConfig filterConfig;
    private static ArrayList<String> pages;
    public FilterExample(){
        if(pages==null)pages=new ArrayList<String>();

    }
    public void destroy() {
        filterConfig=null;

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        String value ="Filter";
//        req.setAttribute("filter",value);
////        chain.doFilter(req,resp);
//        if(filterConfig.getInitParameter("active").equals(true)){
//            HttpServlet servlet= (HttpServlet) req;
//            String[] uri = req.getRequestURI();
        }
 //   }

    public void init(FilterConfig config) throws ServletException {
       filterConfig=config;//инициализация фильтра
    }

}
