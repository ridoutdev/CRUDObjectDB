package com.mycompany.crudesayunosobjectdb;

import java.util.Scanner;
import models.Pedidos;
import models.Productos;

/**
 * @author Ridouan Abdellah Tieb
 */
public class Principal {

    public static void main(String[] args) {

        /*
        Creo la conversion de la fecha de java.sql.Date a java.util.Date
         */
        java.util.Date utilDate = new java.util.Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        
        Scanner sc = new Scanner(System.in);
        
        /*
        Instancio el objeto Cafetería y creo el menú donde se ejecutan los métodos
        del programa. 
         */
        
        System.out.println("BIENVENIDO A COMANDAS OBJECTDB");
        System.out.println("\n¿QUE DESEA HACER?");
        
        var cafeteria = new Cafeteria();
        int opcion = 0;
        
        while (opcion != 5) {

            System.out.println("\n1. CREAR UN NUEVO PEDIDO");
            System.out.println("\n2. ELIMINAR UN PEDIDO EXISTENTE");
            System.out.println("\n3. MARCAR UN PEDIDO COMO RECOGIDO");
            System.out.println("\n4. LISTAR LAS COMANDAS PENDIENTES DE HOY");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    /*
                    Listo la carta de productos y creo un pedido con los datos 
                    introducidos por teclado. 
                     */
                    System.out.println("CARTA: \n\n");
                    cafeteria.meterProductos();
                    cafeteria.listar_productos();

                    System.out.println("\nINTRODUZCA EL NOMBRE DEL ALUMNO");
                    String nombre = sc.next();

                    System.out.println("\nINTRODUZCA EL MÓDULO DEL ALUMNO");
                    String modulo = sc.next();

                    System.out.println("\nINTRODUZCA EL ID DEL PRODUCTO");
                    Long producto = sc.nextLong();

                    Pedidos pedido = new Pedidos(nombre, sqlDate, modulo, "PENDIENTE");

                    if (producto == 1) {
                        pedido.addProductos(new Productos(3.75, "Cocacola", "Bebida", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    } else if (producto == 2) {
                        pedido.addProductos(new Productos(1.75, "Agua", "Bebida", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    } else if (producto == 3) {
                        pedido.addProductos(new Productos(2.10, "Cafe", "Bebida", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    } else if (producto == 4) {
                        pedido.addProductos(new Productos(3.50, "Pitufo Mixto", "Caliente", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    } else if (producto == 5) {
                        pedido.addProductos(new Productos(3.50, "Pitufo Jamón", "Caliente", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    } else if (producto == 6) {
                        pedido.addProductos(new Productos(3.50, "Pitufo Lomo", "Caliente", "DISPONIBLE"));
                        cafeteria.crearPedidos(pedido);
                    }

                    break;
                case 2:
                    /*
                    Listo los pedidos y elimino el pedido seleccionado. 
                     */
                    cafeteria.listar_pedidos();
                    System.out.println("\nINDIQUE EL ID DEL PEDIDO A ELIMINAR");
                    Long elimino = sc.nextLong();
                    cafeteria.eliminarPedidos(elimino);
                    break;
                case 3:
                    /*
                    Listo los pedidos y marca como recogido el pedido seleccionado.
                     */
                    cafeteria.listar_pedidos();
                    System.out.println("\nINDIQUE EL ID DEL PEDIDO QUE QUIERE "
                            + "MARCAR COMO RECOGIDO");
                    Long recojo = sc.nextLong();
                    cafeteria.actualizar(recojo);
                    break;
                case 4:
                    /*
                    Listo las comandas pendientes de hoy.
                     */
                    cafeteria.listar_pedidos_hoy();
                    break;
            }

        }
    }

}
