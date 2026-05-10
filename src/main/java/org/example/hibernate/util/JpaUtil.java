package org.example.hibernate.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory entityManagerFactory = bluidEntityManagerFactory();
    private static EntityManagerFactory bluidEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("hibernate_example");

    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
