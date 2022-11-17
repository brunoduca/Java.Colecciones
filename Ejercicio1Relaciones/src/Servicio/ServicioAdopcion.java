/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import EntidadesHumano.Humano;
import EntidadesPerro.Perro;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ServicioAdopcion {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Humano h1 = new Humano();
    Perro p1 = new Perro();
    HashMap<Humano, Perro> adopcionMap = new HashMap<>();

    public void Menu() {
        int opcion;
        do{
        System.out.println("Ingrese una de las siguientes opciones: \n"
                + "1. Ingresar persona \n"
                + "2. Ingresar perro \n"
                + "3. Mostrar adopciones compatibles \n"
                + "4. Salir");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                IngresarPersona();
                break;
            case 2:
                IngresarPerro();
                break;
            case 3:
                Compatibilidad();
                break;
            case 4:
                break;
            default:
                System.out.println("La opción ingresada no es válida");
        }
        }while (opcion < 4);
        System.out.println("¡Hasta luego!");
    }

    public void IngresarPersona() {
        System.out.println("--------------HUMANO------------");
        h1 = new Humano();
        System.out.println("Ingrese el nombre de la persona:");
        h1.setNombre(leer.next());
        System.out.println("Ingrese el apellido de la persona:");
        h1.setApellido(leer.next());
        System.out.println("Ingrese la edad de la persona:");
        h1.setEdad(leer.nextInt());
        System.out.println("Ingrese el documento de la persona:");
        h1.setDocumento(leer.nextInt());
        System.out.println("Ingrese la raza de perro deseado:");
        h1.setPerroDeseado(leer.next());
        System.out.println("");
    }

    public void IngresarPerro() {
        System.out.println("--------------PERRO-------------");
        p1 = new Perro();
        System.out.println("Ingrese el nombre del perro:");
        p1.setNombre(leer.next());
        System.out.println("Ingrese la raza del perro:");
        p1.setRaza(leer.next());
        System.out.println("Ingrese el tamaño del perro:");
        p1.setTamanio(leer.nextDouble());
        System.out.println("Ingrese la edad del perro");
        p1.setEdad(leer.nextInt());
        adopcionMap.put(h1, p1);
    }

    public void Compatibilidad() {
        int cont = 0;
        for (Map.Entry<Humano, Perro> entry : adopcionMap.entrySet()) {
            Humano key = entry.getKey();
            Perro value = entry.getValue();
            if (entry.getKey().getPerroDeseado().equals(entry.getValue().getRaza())) {
                adopcionMap.replace(key, p1);
                System.out.println("---------ADOPCIONES COMPATIBLES--------");
                System.out.println(key + " " + value);
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("No se han encontrado adopciones compatibles");
        }
        System.out.println("-----------OTRAS POSIBLES ADOPCIONES---------");
        for (Map.Entry<Humano, Perro> entry : adopcionMap.entrySet()) {
            Humano key = entry.getKey();
            Perro value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }

}
