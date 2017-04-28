package by.Controller;
import by.DAO.DAOImple;
import by.model.EmployeeEntity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by УВД on 25.04.2017.
 */
public class EmployeeController extends HttpServlet{
    DAOImple daoImple=new DAOImple();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("update")!=null){
            EmployeeEntity employeeEntity=new EmployeeEntity();
            employeeEntity.setLastname(req.getParameter("lastname"));
            employeeEntity.setFirstname(req.getParameter("firstname"));
            employeeEntity.setEmployeeId(Long.parseLong(req.getParameter("employeeId")));
            daoImple.update(employeeEntity);
            req.setAttribute("list",daoImple.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(req.getParameter("findByName")!=null){
            List<EmployeeEntity> list=daoImple.getEmployeeByFirstName(req.getParameter("findByName"));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(req.getParameter("findById")!=null){
            List<EmployeeEntity> list=daoImple.getEmployeeByIdList(Long.parseLong(req.getParameter("findById")));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(req.getParameter("findByLastName")!=null){
            List<EmployeeEntity> list=daoImple.getEmployeeByLastName(req.getParameter("findByLastName"));
            req.setAttribute("list",list);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(req.getParameter("takeList")!=null){
            req.setAttribute("list",daoImple.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(req.getParameter("add")!=null){
            EmployeeEntity employeeEntity=new EmployeeEntity();
            employeeEntity.setFirstname(req.getParameter("firstname"));
            employeeEntity.setLastname(req.getParameter("lastname"));
            employeeEntity.setEmployeeId(Long.parseLong(req.getParameter("employeeId")));
            daoImple.saveEmployee(employeeEntity);
            req.setAttribute("list",daoImple.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(action.equalsIgnoreCase("update")){
            long  employeeId= Long.parseLong(req.getParameter("employeeId"));
            EmployeeEntity employeeEntity=daoImple.getEmployeeById(employeeId);
            req.setAttribute("employee",employeeEntity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
            requestDispatcher.forward(req, resp);
        }
        if(action.equalsIgnoreCase("delete")){
            daoImple.delete(Long.parseLong(req.getParameter("employeeId")));
            req.setAttribute("list",daoImple.getList());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("ListEmployee.jsp");
            requestDispatcher.forward(req,resp);
        }
if(req.getParameter("login")!=null){
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req,resp);
}

    }
}
