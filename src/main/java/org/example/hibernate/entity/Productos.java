package org.example.hibernate.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="productos")
public class Productos {
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100) // Mapea a la columna "nombre"
    private String nombre;

    @Column(name = "precio", nullable = false) // Mapea a la columna "precio"
    private float precio;

    @Column(name = "fecha", nullable = false) // Mapea a la columna "fecha"
    @Temporal(TemporalType.DATE) // Especifica que solo se almacena la fecha (sin hora)
    private Date fecha;

    public Productos() {
    }

    public Productos(Long id, String nombre, float precio, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}
