import by.DAO.DAOImple;
import by.model.EmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import javax.servlet.RequestDispatcher;
import java.util.List;
import java.util.Map;

/**
 * Created by УВД on 25.04.2017.
 */
public class Main {
    public static void main(String[] args) {
//        EmployeeEntity employeeEntity=new EmployeeEntity();
//        employeeEntity.setEmployeeId(1);
//        employeeEntity.setFirstname("Ivan");
//        employeeEntity.setLastname("Abramov");
//        DAOImple daoImpl=new DAOImple();
//        System.out.println(daoImpl.getEmployeeByFirstName("Roman"));
        DAOImple daoImple=new DAOImple();
        List<EmployeeEntity> list=daoImple.getEmployeeByFirstName("Roman");
        System.out.println(list);
    }
}