/*
 Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. 
- El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
- si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
- Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario 
- se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package Servicio;

import Entidades.Pais;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ServicioPais {

    HashSet<Pais> p1 = new HashSet<>();

    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void ingresarPais() {
        String opcion;
        do {
            Pais p2 = new Pais();
            System.out.println("Ingrese un país:");
            p2.setPais(leer.next());
            p1.add(p2);
            System.out.println("Ingrese alguna de las siguientes opciones: \n"
                    + "1. Ingresar un nuevo país  \n"
                    + "2. Salir");
            opcion = leer.next();
        } while (opcion.equals("1"));
        mostrarPais();
        mostrarPaisOrdenado();
        eliminarPais();
    }

    public void mostrarPais() {
        System.out.println("------LISTA DE PAÍSES-----");
        for (Pais pais : p1) {
            System.out.println(pais.getPais());
            System.out.println("");
        }
    }

    public static Comparator<Pais> orden = (Pais o1, Pais o2) -> o1.getPais().compareTo(o2.getPais());

    public void mostrarPaisOrdenado() {
        ArrayList<Pais> pais1 = new ArrayList(p1);
        Collections.sort(pais1, orden);
        System.out.println("");
        System.out.println("------LISTA DE PAÍSES ORDENADOS-----");
        
        for (Pais pais : pais1) {
            System.out.println(pais.getPais());
            System.out.println("");
        }
    }

    public void eliminarPais() {
        Iterator<Pais> it = p1.iterator();
        int cont = 0;
        String opcion2;
        System.out.println("Ingrese un país a eliminar");
        String opcion1 = leer.next();
        while (it.hasNext()) {
            if (it.next().getPais().equalsIgnoreCase(opcion1)) {
                it.remove();
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Lo sentimos. No se ha encontrado el país ingresado");
            System.out.println("¿Desea ingresaro otro? (S/N)");
            opcion2 = leer.next();
            if (opcion2.equalsIgnoreCase("S")) {
                eliminarPais();
            }
        }
        System.out.println("-----------NUEVA---------");
        mostrarPaisOrdenado();
    }

}
