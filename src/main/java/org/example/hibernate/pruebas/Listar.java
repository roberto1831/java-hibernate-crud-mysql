package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;
import java.util.List;

public class Listar {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Productos> productos = em.createQuery("select c from Productos c ", Productos.class).getResultList();
        productos.forEach(System.out::println);
        JOptionPane.showMessageDialog(null, "Todos los productos han sido listados.");
        em.close();
    }
}
