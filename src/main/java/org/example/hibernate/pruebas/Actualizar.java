package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Actualizar {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Long id= Long.valueOf(JOptionPane.showInputDialog("id:"));
            Productos productos = em.find(Productos.class, id);
            String nombre = JOptionPane.showInputDialog("Actualiza el nombre");
            String precioStr = JOptionPane.showInputDialog("Ingresa el nuevo precio");
            String fechaStr = JOptionPane.showInputDialog("Introduce la nueva fecha");

            // Convertir precio a float
            float precio = productos.getPrecio();  // Valor por defecto
            try {
                precio = Float.parseFloat(precioStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
                return;
            }
            // Convertir fecha a Date
            Date fecha = productos.getFecha();  // Valor por defecto
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                fecha = formatoFecha.parse(fechaStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El formato de la fecha debe ser yyyy-MM-dd.");
                return;
            }

            // Actualizar el producto
            productos.setNombre(nombre);
            productos.setPrecio(precio);
            productos.setFecha(fecha);
            // Guardar cambios en la base de dato
            em.merge(productos);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");

        }
        catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }

    }
}
