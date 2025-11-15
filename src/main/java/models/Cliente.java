/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GRUPO_PROG_2_C_1_ 4
 */
import java.util.Date;

public class Cliente {
    private String nombre;
    private String direccion;
    private String dpi;
    private String numeroTelefono;
    
    //constructor vacío necesario para firebase
    public Cliente() {}
    
    public Cliente(String nombre, String direccion, String dpi, String numeroTelefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dpi = dpi;
        this.numeroTelefono = numeroTelefono;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getDpi() { return dpi; }
    public void setDpi(String dpi) { this.dpi = dpi; }
    
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }
    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", dpi=" + dpi + ", telefono=" + numeroTelefono + '}';
    }
}