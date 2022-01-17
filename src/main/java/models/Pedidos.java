package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 ** @author Ridouan Abdellah Tieb
 **/
@Entity
public class Pedidos implements Serializable {
    /*
    Creo la clase Pedidos que contendrá todos los atributos de esa entidad y que
    serán las columnas de la tabla. Creo el constructor vacío, constructor 
    con parámetros, getters, setters, toString y un método para añadir un producto
    a un pedido. 
    */
    @Id
    @GeneratedValue
    private Long id;
    private String usuario;
    private String ciclo;
    private Date fecha;
    private String estado; 
    
    @OneToMany (mappedBy="pedidos", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Productos> productos;
    
    public Pedidos() {
        productos = new HashSet();
    }

    public Pedidos(String usuario, Date fecha, 
                   String ciclo, String estado) {
        this.usuario = usuario;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.estado = estado;
        productos = new HashSet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Productos> getProductos(){
        return productos;
    }
    
    public void setProductos (Set<Productos> productos) {
        this.productos=productos;
    }
    
    public void addProductos(Productos pr) {
        productos.add(pr);
        pr.setPedidos(this);
    }
    
    @Override
    public String toString() {
        return "PEDIDOS [" + "ID: " + id + "; USUARIO: " + usuario + "; CICLO: " + 
                ciclo + "; FECHA: " + fecha + "; ESTADO: " + estado + ']';
    }
    
    
}
