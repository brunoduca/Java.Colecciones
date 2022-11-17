/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesHumano;

/**
 *
 * @author usuario
 */
public class Humano {
    private String nombre;
    private String apellido;
    private String perroDeseado;
    private Integer edad;
    private Integer documento;

    public Humano() {
    }

    public Humano(String nombre, String apellido, String perroDeseado, Integer edad, Integer documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.perroDeseado = perroDeseado;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPerroDeseado() {
        return perroDeseado;
    }

    public void setPerroDeseado(String perroDeseado) {
        this.perroDeseado = perroDeseado;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    
    
}
