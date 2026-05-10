package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.util.JpaUtil;

import javax.swing.*;

public class Eliminar {
    public static void main(String[] args) {
        EntityManager em= JpaUtil.getEntityManager();
        try{
            Long id= Long.valueOf(JOptionPane.showInputDialog("Ingresa el id del producto a eliminar "));
            em.getTransaction().begin();
            Productos prod = em.find(Productos.class, id);
            em.remove(prod);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"El producto fue eliminado");
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
