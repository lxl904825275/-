package com.dao;

import com.entity.User;
import com.until.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuxulong
 * date : 18:48 2019/4/15
 */
@Repository("userDao")
public class UserDao {
    private Session session;
    public void before(){
        session= HibernateUntil.getSession();
        session.beginTransaction();
    }
    public void after(){
        session.getTransaction().rollback();
        session.close();
    }
    public List<User> queryPage(int pageIndex,int pageCopunt){
        List<User> list=new ArrayList<>();
        before();
        try {
            String hql="from User";
            Query<User> query = session.createQuery(hql, User.class);
            query.setFirstResult((pageIndex-1)*pageCopunt);
            query.setMaxResults(pageCopunt);
             list = query.list();
            session.getTransaction().rollback();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return null;
    }
    public int Page(int pageCount){
        before();
        int page=1;
        String hql="select count(1) from User";
        Query query = session.createQuery(hql);
        Object o = query.uniqueResult();
        Number number=(Number) o;
        int i = number.intValue();
        after();
        page=(i+pageCount)/pageCount;
        return  page;
    }
    public int add(User user){
        before();
        session.save(user);
        after();
        return 0;
    }
    public int update(User user){
        before();
        session.update(user);
        after();
        return 0;
    }
    public int delete(int id){
        before();
        User user = session.load(User.class, id);
        session.delete(user);
        after();
        return 0;
    }
    public User queryOne(int id){
        before();
        String hql="from User u where u.id=:id";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("id",id);
        User user = query.uniqueResult();
        after();
        return user;
    }
}
