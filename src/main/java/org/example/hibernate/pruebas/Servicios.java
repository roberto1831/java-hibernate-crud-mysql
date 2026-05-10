package org.example.hibernate.pruebas;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.servicios.ProductosServicio;
import org.example.hibernate.servicios.ProductosServicioImplementa;
import org.example.hibernate.util.JpaUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Servicios {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ProductosServicio servicio = new ProductosServicioImplementa(em);

        System.out.println("---------------listar----------------");
        List<Productos> productos = servicio.listar();
        productos.forEach(System.out::println);

        System.out.println("--------------por id---------------");
        Optional<Productos> optionalProducto = servicio.porId(1L);
        optionalProducto.ifPresent(System.out::println);

        System.out.println("--------------Insertar---------------");
        Productos prod = new Productos();
        prod.setNombre("Leche Machachi Espe");
        prod.setPrecio(50F);
        // Convertir la fecha de String a Date
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoFecha.parse("2024-12-18");
            prod.setFecha(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Guardar el producto utilizando el servicio
        servicio.guardar(prod);

        // Verificar que el producto se ha insertado correctamente
        System.out.println("Producto insertado:");
        servicio.listar().forEach(System.out::println);


        // Actualizar Producto
        System.out.println("-------Actualizar---------");
        Long id =prod.getId();
        optionalProducto = servicio.porId(id);
        optionalProducto.ifPresent(prod1 ->{
            prod1.setNombre("Leche Deslactosada");
            servicio.guardar(prod);
            servicio.listar().forEach(System.out::println);
        });

        //Eliminar-----------
        System.out.println("---------------Eliminar--------------");
        optionalProducto = servicio.porId(37L);
        optionalProducto.ifPresent(prod1 ->{
            servicio.eliminar(prod1.getId());
            servicio.listar().forEach(System.out::println);
        });


        em.close();
    }
}
