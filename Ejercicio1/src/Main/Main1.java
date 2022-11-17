/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author usuario
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String opcion, opcion2;
        ArrayList<String> perros = new ArrayList();
        do {
            System.out.println("¿Desea agregar una raza nueva?(S/N)");
            opcion = leer.next();
            if (opcion.equalsIgnoreCase("S")) {
                System.out.println("Ingrese una nueva raza");
                perros.add(leer.next());
            }
        } while (opcion.equalsIgnoreCase("S"));

        System.out.println(perros);

        System.out.println("Ingrese una raza a analizar");
        opcion2 = leer.next();
        Iterator<String> aux = perros.iterator();
        int i = 0;
        while (aux.hasNext()) {
            if (aux.next().equalsIgnoreCase(opcion2)) {
                aux.remove();
                i++;
            }
            if (i < 0) {
                System.out.println("No se ha encontrado la raza");
            }
        }
            aux = perros.iterator();
            while (aux.hasNext()) {
                System.out.println(aux.next());
                
            }
            /*Collections.sort(perros);
            System.out.println(perros);*/

    }
}
