package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.Scanner;

public class ClientDemo 
{
    public void addDepartment() 
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Department department = new Department();
        department.setId(101);
        department.setName("Marketing");
        department.setLocation("Vijayawada");
        department.setHodName("Hari");
        department.setStatus(true);

        session.persist(department);
        t.commit();
        System.out.println("Department Added Successfully");
        session.close();
        sf.close();
    }
    public void deleteDepartmentById() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department ID to delete:");
        int id = sc.nextInt();

        String hql = "delete from Department where id=:v";
        MutationQuery qry = session.createMutationQuery(hql);
        qry.setParameter("v", id);
        int n = qry.executeUpdate();

        t.commit();

        if (n > 0) {
            System.out.println("Department deleted successfully");
        } else {
            System.out.println("Department ID not found");
        }

        sc.close();
        session.close();
        sf.close();
    }

    public static void main(String[] args) {
        ClientDemo operations = new ClientDemo();
        operations.addDepartment();  
        operations.deleteDepartmentById();  
    }
}
