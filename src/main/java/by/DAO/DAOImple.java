package by.DAO;

import by.model.EmployeeEntity;
import by.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by УВД on 25.04.2017.
 */
public class DAOImple {
    public List<EmployeeEntity> getList(){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<EmployeeEntity> list=session.createQuery("from EmployeeEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public void saveEmployee(EmployeeEntity employeeEntity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void update(EmployeeEntity employeeEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employeeEntity);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    public void delete(long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeEntity employeeEntity= (EmployeeEntity) session.load(EmployeeEntity.class,id);
        session.delete(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public EmployeeEntity getEmployeeById(long id){
        EmployeeEntity employeeEntity=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity WHERE employeeId=:id");
        query.setLong("id",id);
        employeeEntity= (EmployeeEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return employeeEntity;
    }
    public List<EmployeeEntity> getEmployeeByFirstName(String name){
        EmployeeEntity employeeEntity=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity WHERE firstname=:name");
        query.setString("name",name);
        List<EmployeeEntity> list=query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public List<EmployeeEntity> getEmployeeByIdList(long id){
        EmployeeEntity employeeEntity=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity WHERE employeeId=:id");
        query.setLong("id",id);
        List<EmployeeEntity> list=query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public List<EmployeeEntity> getEmployeeByLastName(String name){
        EmployeeEntity employeeEntity=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity WHERE lastname=:name");
        query.setString("name",name);
        List<EmployeeEntity> list=query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
