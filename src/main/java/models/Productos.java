package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * @author Ridouan Abdellah Tieb
 **/
@Entity
public class Productos implements Serializable {
    /*
    Creo la clase Productos que contendrá todos los atributos de esa entidad y 
    que serán las columnas de la tabla. Creo el constructor vacío, constructor
    con parámetros, getters, setters y toString.
    */
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;
    private double precio;
    private String nombre;
    private String tipo;
    private String disponible;
    
    @ManyToOne 
    @JoinColumn (name = "pedidos_id")
    private Pedidos pedidos;
    
    public Productos() {
      
    }
    public Productos(double precio, String nombre, String tipo, 
                 String disponible) {
        this.precio = precio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = disponible; 
        
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
    
    public Pedidos getPedidos() {
        return pedidos;
    }
    
    public void setPedidos (Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    @Override
    public String toString() {
        return "PRODUCTOS [" + "ID: " + id + "; NOMBRE: " + nombre + "; PRECIO: " 
              + precio + "€; TIPO: " + tipo + "; DISPONIBLE: " + disponible + ']';
    }
    
}
