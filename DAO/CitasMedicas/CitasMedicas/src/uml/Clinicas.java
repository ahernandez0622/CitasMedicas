
package uml;


public class Clinicas {
    private int idClinica;
    private String nombClinica;
    private int empleados;
    private String encargado;

    
    public Clinicas() {
    }
    
    public Clinicas(int idClin) {
         this.idClinica=idClin;
    }

    
    
    public Clinicas(int idClinica, String nombClinica, int empleados, String encargado) {
        this.idClinica = idClinica;
        this.nombClinica = nombClinica;
        this.empleados = empleados;
        this.encargado = encargado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public String getNombClinica() {
        return nombClinica;
    }

    public void setNombClinica(String nombClinica) {
        this.nombClinica = nombClinica;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
     
     
     
}
