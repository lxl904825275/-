package com.until;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author:liuxulong
 * @date 2019/4/9 10:35
 */
public class HibernateUntil {
    private static SessionFactory SESSIONFACTORY=null;
    private static Session session=null;
    static {
//        注册服务
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
//        创建工厂
         SESSIONFACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;
    }
    public static Session getSession(){
        session = getSessionFactory().openSession();
        return session;
    }
}
