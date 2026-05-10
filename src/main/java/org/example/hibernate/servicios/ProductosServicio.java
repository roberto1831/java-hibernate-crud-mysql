package org.example.hibernate.servicios;

import org.example.hibernate.entity.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductosServicio {
    List<Productos> listar();
    Optional<Productos> porId(Long id);
    void guardar (Productos productos);
    void eliminar(Long id);
}
