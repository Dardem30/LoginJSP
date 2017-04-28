package by.Controller;

import by.DAO.DAOLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by УВД on 26.04.2017.
 */
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
       requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        DAOLogin daoLogin=new DAOLogin();
        boolean result=daoLogin.autontification(login,password);
        if(result==true){
            HttpSession session=req.getSession();
            session.setAttribute("login",login);
            session.setAttribute("session",session);
            session.getAttribute("counter");
            session.setMaxInactiveInterval(2*60);
            Cookie cookie=new Cookie("login",login);
            cookie.setMaxAge(2*60);
            resp.addCookie(cookie);
            resp.sendRedirect("index.jsp");
        }else {
RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
requestDispatcher.forward(req,resp);
        }
    }
}
