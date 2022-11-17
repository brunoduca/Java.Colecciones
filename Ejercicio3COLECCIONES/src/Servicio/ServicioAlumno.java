/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alumno;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ServicioAlumno {

    Alumno alumnos = new Alumno();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<String> alumnoIng = new ArrayList<>();
    ArrayList<Integer> not1 = new ArrayList<>();

    public void ingresarAlumno() {
        String opcion;
        do {
            System.out.println("Ingrese el nombre del alumno");
            alumnoIng.add(leer.next());
            alumnos.setNombre(alumnoIng);
            ingresarNotas();
            System.out.println("¿Desea ingresar un nuevo alumno? (S/N)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("S"));
    }

    public void ingresarNotas() {
        System.out.println("Ingrese la primer nota");
        int nota1 = leer.nextInt();
        System.out.println("Ingrese la segunda nota");
        int nota2 = leer.nextInt();
        System.out.println("Ingrese la tercer nota");
        int nota3 = leer.nextInt();
        int promedio;
        promedio = (nota1 + nota2 + nota3) / 3;
        not1.add(promedio);
        alumnos.setNotas(not1);
        alumnoIng.add(alumnos.getNotas().toString());
        not1.clear();
    }

    public void mostrarDatos() {
        String nombre1;
        System.out.println("Ingrese el nombre del alumno de quien desea conocer el promdeio");
        nombre1 = leer.next();
        int cont = 0;
        for (String aux : alumnoIng) {
            cont++;
            if (aux.equalsIgnoreCase(nombre1)) {
                System.out.println(alumnoIng.subList(cont, cont + 1));
                System.out.println("El prmedio de " + nombre1 + " es:");
                
            }
        }
    }
}
