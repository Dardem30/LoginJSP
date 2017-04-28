package by.Controller;

import by.DAO.DAOImple;
import by.model.EmployeeEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by УВД on 25.04.2017.
 */
public class PoiskController extends HttpServlet{
    DAOImple daoImple=new DAOImple();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String select=req.getParameter("select");
        if(select.equals("findById")){
            List<EmployeeEntity> list=daoImple.getEmployeeByIdList(Long.parseLong(req.getParameter("findById")));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(select.equals("findByName")){
            List<EmployeeEntity> list=daoImple.getEmployeeByFirstName(req.getParameter("findByName"));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(select.equals("findByLastName")){
            List<EmployeeEntity> list=daoImple.getEmployeeByLastName(req.getParameter("findByLastName"));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
