package com.mycompany.crudesayunosobjectdb;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Pedidos;
import models.Productos;

/**
 * @author Ridouan Abdellah Tieb
 */
public class Cafeteria {

    /*
    Creo la conversion de la fecha de java.sql.Date a java.util.Date
     */
    java.util.Date utilDate = new java.util.Date();
    long lnMilisegundos = utilDate.getTime();
    java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("crudodb.odb");
    }

    public void crearPedidos(Pedidos p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void crearProductos(Productos pr) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pr);
        em.getTransaction().commit();
        em.close();
    }

    public void listar_pedidos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p", Pedidos.class);
        var pedidos = new ArrayList<Pedidos>();
        pedidos = (ArrayList<Pedidos>) q.getResultList();
        em.close();

        pedidos.forEach(
                (p) -> {
                    System.out.println("ID: " + p.getId() + " USUARIO: "
                            + p.getUsuario() + " CICLO: " + p.getCiclo()
                            + " ESTADO: " + p.getEstado() + " FECHA: " + p.getFecha());
                });
    }

    public void listar_pedidos_hoy() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pedidos> q = em.createQuery("SELECT p FROM Pedidos p WHERE fecha= :p AND estado = :q", Pedidos.class);
        String qq = "PENDIENTE";
        q.setParameter("p", sqlDate);
        q.setParameter("q",qq);
        var pedidos = new ArrayList<Pedidos>();
        pedidos = (ArrayList<Pedidos>) q.getResultList();
        em.close();

        pedidos.forEach(
                (p) -> {
                    System.out.println("ID: " + p.getId() + " USUARIO: "
                            + p.getUsuario() + " CICLO: " + p.getCiclo()
                            + " ESTADO: " + p.getEstado() + " FECHA: " + p.getFecha());
                });
    }

    public void listar_productos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Productos> q = em.createQuery("SELECT pr FROM Productos pr", Productos.class);
        var productos = new ArrayList<Productos>();
        productos = (ArrayList<Productos>) q.getResultList();
        em.close();

        productos.forEach(
                (pr) -> {
                    System.out.println("ID: " + pr.getId() + " NOMBRE: "
                            + pr.getNombre() + " TIPO: " + pr.getTipo()
                            + " DISPONIBLE: " + pr.getDisponible() + " PRECIO:  " + pr.getPrecio());
                });
    }

    public void eliminarPedidos(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM Pedidos p WHERE p.id = :p");
        q.setParameter("p", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void actualizar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE Pedidos SET estado = 'RECOGIDO' WHERE id = :p");
        q.setParameter("p", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public void meterProductos() {
        var cafeteria = new Cafeteria();
        
        Productos cocacola = new Productos(3.75, "Cocacola", "Bebida", "DISPONIBLE");
        cafeteria.crearProductos(cocacola);
        
        Productos agua = new Productos(1.75, "Agua", "Bebida", "DISPONIBLE");
        cafeteria.crearProductos(agua);
        
        Productos cafe = new Productos(2.10, "Cafe", "Bebida", "DISPONIBLE");
        cafeteria.crearProductos(cafe);
        
        Productos pitufoMix = new Productos(3.50, "Pitufo Mixto", "Caliente", "DISPONIBLE");
        cafeteria.crearProductos(pitufoMix);
        
        Productos pitufoJam = new Productos(3.50, "Pitufo Jamón", "Caliente", "DISPONIBLE");
        cafeteria.crearProductos(pitufoJam);
        
        Productos pitufoLom = new Productos(3.50, "Pitufo Lomo", "Caliente", "DISPONIBLE");
        cafeteria.crearProductos(pitufoLom);
    }
}
