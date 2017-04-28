package by.DAO;

import by.model.AdminkaEntity;
import by.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by УВД on 26.04.2017.
 */
public class DAOLogin {
    public boolean autontification(String login,String password){//выводит значения true или false в зависимости от условия принимает в себя логин и пароль
        AdminkaEntity adminkaEntity=getAdminkaByLogin(login);//придание значения объекту класса AdminkaEntity то что мы вытащим из базы данных с помощью метода getAdminkaByLogin
        if(adminkaEntity!=null && adminkaEntity.getLogin().equals(login) && adminkaEntity.getPassword().equals(password)){//проверка условия
            return true;//Вывод
        }else {//иначе
         return false;//вывод
        }
    }
    public AdminkaEntity getAdminkaByLogin(String login){//выводит модель бд и принимает в себя логин
        AdminkaEntity adminkaEntity=null;//создаём объект класса AdminkaEntity она администрирует доступ к логину и паролю
        Session session= HibernateUtil.getSessionFactory().openSession();//открытие сессии
        Query query=session.createQuery("FROM AdminkaEntity WHERE login=:login");//запрос к бд
        query.setString("login",login);//вставляем в запрос переменную
        adminkaEntity= (AdminkaEntity) query.uniqueResult();//присвоение значения объекту запроса с уникальным объектом
        return adminkaEntity;//вывод
    }
}
