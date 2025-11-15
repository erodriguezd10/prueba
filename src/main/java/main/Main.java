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
        Cliente cliente = new Cliente("Elmer Rodríguez", "Zona 4, Boca del monde", "3048477040116", "45947243");
        String resultado = clienteService.agregarCliente(cliente);
        System.out.println(resultado);
        
        //leer un dueño
        Cliente clienteLeido = clienteService.obtenerCliente("3048477040116");
        if (clienteLeido != null) {
            System.out.println("Cliente encontrado: " + clienteLeido.getNombre());
        }
    }
    
    private static void pruebaMascotaService() throws ExecutionException, InterruptedException {
        System.out.println("\nPruebas para mascota");
        
        MascotaService mascotaService = new MascotaService();
        
        //crear mascota
        Mascota mascota = new Mascota("M001", "terrestre", "Coco", "Perro", 
                                     "macho", 3, "Café", new Date(), "3048477040116");
        String resultado = mascotaService.agregarMascota(mascota);
        System.out.println(resultado);
        
        //leer mascotas por dueño
        var mascotas = mascotaService.obtenerMascotasPorCliente("3048477040116");
        System.out.println("Mascotas encontradas: " + mascotas.size());
    }
    
    private static void pruebaProductoService() throws ExecutionException, InterruptedException {
        System.out.println("\nPruebas para los productos");
        
        ProductoService productoService = new ProductoService();
        
        //creación de un producto
        Producto producto = new Producto("P001", "Shampoo para perros", 45.50, 
                                        "Shampoo antipulgas", 100);
        String resultado = productoService.agregarProducto(producto);
        System.out.println(resultado);
        
        //Busqueda para el
        var productos = productoService.buscarProductosPorNombre("Shampoo");
        System.out.println("Productos encontrados: " + productos.size());
    }
}