package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;
import java.util.List;

public class ListarWhere {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        // Crear la consulta para listar productos por nombre
        Query query = em.createQuery("select p from Productos p where p.nombre=?1", Productos.class);

        // Solicitar al usuario el nombre del producto mediante JOptionPane
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");

        // Verificar si el usuario ha ingresado algo
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Establecer el parámetro de búsqueda
            query.setParameter(1, nombre);

            // Obtener los productos que coinciden con el nombre
            List<Productos> productos = query.getResultList();

            // Construir el mensaje con los productos encontrados
            StringBuilder mensaje = new StringBuilder();

            if (!productos.isEmpty()) {
                for (Productos p : productos) {
                    mensaje.append(p.toString()).append("\n");
                }
            } else {
                mensaje.append("No se encontraron productos con ese nombre.");
            }

            // Mostrar la confirmación en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresó un nombre válido.");
        }

        em.close();
    }
}
