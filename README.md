# 🗄️ ORM con Hibernate + JPA – Gestión de Productos

![Java](https://img.shields.io/badge/Java-23-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-5.6-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Jakarta JPA](https://img.shields.io/badge/Jakarta_JPA-3.0-FF6C37?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

> Proyecto educativo que demuestra el uso de **Hibernate ORM con Jakarta JPA** para mapeo objeto-relacional en Java, implementando operaciones CRUD, patrón Repositorio, capa de Servicios y acceso directo con JDBC.

---

## 🏗️ Arquitectura del Proyecto

```
espeorm/
└── src/main/java/org/example/
    ├── jdbc/
    │   └── EjemploJdbc.java              # Conexión directa con JDBC
    └── hibernate/
        ├── entity/
        │   └── Productos.java            # Entidad JPA mapeada a tabla MySQL
        ├── repositorio/
        │   ├── CrudRepositorio.java      # Interfaz genérica CRUD
        │   └── ProductosRepositorio.java # Implementación repositorio
        ├── servicios/
        │   ├── ProductosServicio.java    # Interfaz de servicios
        │   └── ProductosServicioImplementa.java
        ├── util/
        │   └── JpaUtil.java             # Factory del EntityManager
        └── pruebas/
            ├── Insertar.java            # CRUD individual con JOptionPane
            ├── Listar.java
            ├── ListarId.java
            ├── ListarWhere.java
            ├── Actualizar.java
            ├── Eliminar.java
            └── Servicios.java           # Demo completo usando capa de servicios
```

---

## 🧩 Capas de la Aplicación

```
┌─────────────────────────────┐
│     Pruebas (main classes)  │  ← Entrada del usuario (JOptionPane)
└──────────────┬──────────────┘
               │
┌──────────────▼──────────────┐
│    Capa de Servicios        │  ← Lógica de negocio + transacciones
│  ProductosServicioImplementa│
└──────────────┬──────────────┘
               │
┌──────────────▼──────────────┐
│    Capa de Repositorio      │  ← Acceso a datos con JPA
│  ProductosRepositorio       │
└──────────────┬──────────────┘
               │
┌──────────────▼──────────────┐
│    Hibernate + JPA          │  ← ORM: mapeo objeto-relacional
└──────────────┬──────────────┘
               │
┌──────────────▼──────────────┐
│    MySQL (productos DB)     │  ← Base de datos relacional
└─────────────────────────────┘
```

---

## 📦 Entidad JPA

```java
@Entity
@Table(name="productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
}
```

---

## 🔬 Operaciones Implementadas

| Clase | Operación | Descripción |
|---|---|---|
| `Insertar` | CREATE | Crea un producto vía JOptionPane |
| `Listar` | READ ALL | Lista todos los productos con JPQL |
| `ListarId` | READ ONE | Busca producto por ID |
| `ListarWhere` | READ FILTER | Busca productos por nombre (JPQL WHERE) |
| `Actualizar` | UPDATE | Actualiza nombre, precio y fecha |
| `Eliminar` | DELETE | Elimina producto por ID |
| `Servicios` | CRUD completo | Demo usando capa de servicios |
| `EjemploJdbc` | READ | Consulta directa SQL con JDBC |

---

## ⚙️ Configuración de Base de Datos

Edita `src/main/resources/META-INF/persistence.xml` con tus credenciales:

```xml

    
    
    
    
    
    

```

> ⚠️ Nunca subas contraseñas reales al repositorio.

### Script de base de datos

```sql
CREATE DATABASE productos;
USE productos;

CREATE TABLE productos (
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio FLOAT NOT NULL,
    fecha  DATE NOT NULL
);
```

---

## 🚀 Compilar y Ejecutar

### Prerrequisitos
- Java 23
- Maven 3.9+
- MySQL corriendo localmente

```bash
# Clonar el repositorio
git clone https://github.com/roberto1831/hibernate-jpa-orm.git
cd hibernate-jpa-orm

# Compilar
mvn clean compile

# Ejecutar una operación (ejemplo: Listar)
mvn exec:java -Dexec.mainClass="org.example.hibernate.pruebas.Listar"
```

O ejecutar directamente desde **IntelliJ IDEA** cada clase como aplicación independiente.

---

## 🛠️ Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 23 | Lenguaje principal |
| Hibernate Core Jakarta | 5.6.15 | ORM provider |
| Jakarta JPA | 3.0 | Especificación de persistencia |
| MySQL Connector | 8.0.33 | Driver JDBC |
| Maven | 3.9+ | Gestión de dependencias |

---

## 👤 Autor

**Ing. Roberto Toapanta**  
📍 Quito, Ecuador  
🔗 [GitHub](https://github.com/roberto1831) · [LinkedIn](https://linkedin.com/in/roberto1831)

---

## 📄 Licencia

Uso académico / demostrativo.
