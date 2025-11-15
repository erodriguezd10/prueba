/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author GRUPO_PROG_2_C_1_ 4
 */
import java.util.UUID;

public class GeneradorID {
    
    //id para mascotas
    public static String generarIDMascota() {
        //genera un UUID
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "MASC-" + uuid.toUpperCase();
    }
    
    //generación del ID unico para productos en automatico
    public static String generarIDProducto() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "PROD-" + uuid.toUpperCase();
    }
    
    public static String generarIDNumerico() {
        long timestamp = System.currentTimeMillis();
        return "ID-" + timestamp;
    }
}
//(*_*)