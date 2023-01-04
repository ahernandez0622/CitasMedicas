
package uml;

import java.sql.Date;

public class Citas {
    private int codigo;
    private String nombresPaciente;
    private String apellidosPaciente;
    private char Genero;
    private int edad;
    private Date fechCita;
    private String  horaCita;
    private Clinicas idClinica;

    public Citas() {
    }
              

    public Citas(int codigo, String nombresPaciente, String apellidosPaciente, char Genero, int edad, 
            Date fechCita, String horaCita, Clinicas idClinica) {
        this.codigo = codigo;
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.Genero = Genero;
        this.edad = edad;
        this.fechCita = fechCita;
        this.horaCita = horaCita;
        this.idClinica = idClinica;
    }

    public Citas(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechCita() {
        return fechCita;
    }

    public void setFechCita(Date fechCita) {
        this.fechCita = fechCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    
    
}
