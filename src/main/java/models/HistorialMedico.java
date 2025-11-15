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
import java.util.List;

public class HistorialMedico {
    private String idMascota;
    private List<String> resultadosExamenesFisicos;
    private List<String> diagnosticosAnteriores;
    private List<String> tratamientosAnteriores;
    private List<Vacuna> vacunas;
    
    public HistorialMedico() {}
    
    public HistorialMedico(String idMascota) {
        this.idMascota = idMascota;
    }
    
    public String getIdMascota() { return idMascota; }
    public void setIdMascota(String idMascota) { this.idMascota = idMascota; }
    
    public List<String> getResultadosExamenesFisicos() { return resultadosExamenesFisicos; }
    public void setResultadosExamenesFisicos(List<String> resultadosExamenesFisicos) { 
        this.resultadosExamenesFisicos = resultadosExamenesFisicos; 
    }
    
    public List<String> getDiagnosticosAnteriores() { return diagnosticosAnteriores; }
    public void setDiagnosticosAnteriores(List<String> diagnosticosAnteriores) { 
        this.diagnosticosAnteriores = diagnosticosAnteriores; 
    }
    
    public List<String> getTratamientosAnteriores() { return tratamientosAnteriores; }
    public void setTratamientosAnteriores(List<String> tratamientosAnteriores) { 
        this.tratamientosAnteriores = tratamientosAnteriores; 
    }
    
    public List<Vacuna> getVacunas() { return vacunas; }
    public void setVacunas(List<Vacuna> vacunas) { this.vacunas = vacunas; }
}
