package org.example.hibernate.servicios;

import jakarta.persistence.EntityManager;
import org.example.hibernate.entity.Productos;
import org.example.hibernate.repositorio.CrudRepositorio;
import org.example.hibernate.repositorio.ProductosRepositorio;

import java.util.List;
import java.util.Optional;

public class ProductosServicioImplementa implements  ProductosServicio{
    private EntityManager em;
    private CrudRepositorio<Productos> repositorio;

    public ProductosServicioImplementa(EntityManager em) {
        this.em = em;
        this.repositorio= new ProductosRepositorio(em);
    }

    @Override
    public List<Productos> listar() {
        return repositorio.listar();
    }


    @Override
    public Optional<Productos> porId(Long id) {
        return Optional.ofNullable(repositorio.porId(id));
    }

    @Override
    public void guardar(Productos productos) {
        try {
            em.getTransaction().begin();
            repositorio.guardar(productos);
            em.getTransaction().commit();

        }catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public void eliminar(Long id) {
        try{
            em.getTransaction().begin();
            repositorio.eliminar(id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }
}
