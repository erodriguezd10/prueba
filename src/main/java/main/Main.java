//v01_noviembre11_Elmer
package main;

import models.*;
import services.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        try {
            //pruebas de el CRUD
            pruebaClienteService();
            pruebaMascotaService();
            pruebaProductoService();
            
        } catch (Exception e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
        }
    }
    
    private static void pruebaClienteService() throws ExecutionException, InterruptedException {
        System.out.println("Prueabas para cliente");
        
        ClienteService clienteService = new ClienteService();
        
        //crear dueño
        Cliente cliente = new Cliente("Cristian Rodríguez", "Zona 7, Boca del monde", "4830477040116", "31555493");
        String resultado = clienteService.agregarCliente(cliente);
        System.out.println(resultado);
        
        //leer un dueño
        Cliente clienteLeido = clienteService.obtenerCliente("4830477040116");
        if (clienteLeido != null) {
            System.out.println("Cliente encontrado: " + clienteLeido.getNombre());
        }
    }
    
    private static void pruebaMascotaService() throws ExecutionException, InterruptedException {
        System.out.println("\nPruebas para mascota");
        
        MascotaService mascotaService = new MascotaService();
        
        //crear mascota
        Mascota mascota = new Mascota("M004", "terrestre", "Rambo", "Perro", 
                                     "macho", 3, "Anaranjado", new Date(), "4830477040116");
        String resultado = mascotaService.agregarMascota(mascota);
        System.out.println(resultado);
        
        //leer mascotas por dueño
        var mascotas = mascotaService.obtenerMascotasPorCliente("4830477040116");
        System.out.println("Mascotas encontradas: " + mascotas.size());
    }
    
    private static void pruebaProductoService() throws ExecutionException, InterruptedException {
        System.out.println("\nPruebas para los productos");
        
        ProductoService productoService = new ProductoService();
        
        //creación de un producto
        Producto producto = new Producto("P005", "Shampoo para aclarar", 45.50, 
                                        "Shampoo para limpiar el pelo muerto", 100);
        String resultado = productoService.agregarProducto(producto);
        System.out.println(resultado);
        
        //Busqueda para el
        var productos = productoService.buscarProductosPorNombre("Shampoo");
        System.out.println("Productos encontrados: " + productos.size());
    }
}