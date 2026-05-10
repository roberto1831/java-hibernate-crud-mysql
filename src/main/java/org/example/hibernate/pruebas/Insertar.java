package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insertar {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {

            String nombre = JOptionPane.showInputDialog("Introduce el nombre");
            String precioStr = JOptionPane.showInputDialog("Introduce el precio");
            String fechaStr = JOptionPane.showInputDialog("Introduce la fecha");

            // Conversión de precio de String a float
            float precio = 0.0f;
            try {
                precio = Float.parseFloat(precioStr);  // Convertir el precio a tipo float
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
                return;
            }

            // Convertir la fecha a tipo Date

            Date fecha = null;
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                fecha = formatoFecha.parse(fechaStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El formato de la fecha debe ser yyyy-MM-dd.");
                return;
            }

            // Iniciar transacción
            em.getTransaction().begin();
            Productos prod = new Productos();
            prod.setNombre(nombre);
            prod.setPrecio(precio);
            prod.setFecha(fecha);

            // Persistir el objeto en la base de datos
            em.persist(prod);
            // Confirmar la transacción
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo producto");
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {

            em.close();
        }


    }
}
