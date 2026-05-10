package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;

public class ListarId {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        // Solicitar al usuario que ingrese el ID del producto mediante un cuadro de entrada
        String input = JOptionPane.showInputDialog("Ingrese el ID del producto: ");

        Long id = Long.parseLong(input); // Convertir el input a Long
        Productos p = em.find(Productos.class, id);
        System.out.println(p);

        Productos p2 = em.find(Productos.class, id);
        System.out.println(p2);
        JOptionPane.showMessageDialog(null, "Producto ha sido listado por ID");

        em.close();
    }
}
