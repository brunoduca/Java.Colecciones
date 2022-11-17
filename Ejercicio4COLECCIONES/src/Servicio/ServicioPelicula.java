/*
 Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
22
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package Servicio;

import Entidad.Pelicula;
import java.util.*;
import sun.security.pkcs11.P11Util;

/**
 *
 * @author usuario
 */
public class ServicioPelicula {

    ArrayList<Pelicula> pelicula1 = new ArrayList<>();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearPeli() {
        String opcion;
        do {
            Pelicula p1 = new Pelicula();
            System.out.println("Ingrese el nombre de la película");
            p1.setTitulo(leer.next());
            //String titulo = leer.next(),
            System.out.println("Ingrese el director de la misma");
            p1.setDirector(leer.next());
            //String director = leer.next();
            System.out.println("Ingrese la duración en minutos");
            p1.setDuracion(leer.nextInt());
            //Integer duracion = leer.nextint();
            pelicula1.add(p1);
            //pelicula1.add(new Pelicula(titula, director, duracion));
            System.out.println("¿Desea ingresar una nueva película? (S/N)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("S"));
    }

    public void mostrarPeli() {
        System.out.println("--------Películas---------");
        Iterator<Pelicula> it = pelicula1.iterator();
        while (it.hasNext()) {
            Pelicula aux = it.next();
            System.out.println(aux.getTitulo() + "\n"
                    + aux.getDirector() + "\n"
                    + aux.getDuracion());
            System.out.println("----------");
        }
        System.out.println("");
    }

    public void pelisMasHora() {
        System.out.println("--Películas de más de una hora--");
        for (Pelicula aux1 : pelicula1) {
            if (aux1.getDuracion() >= 60) {
                System.out.println(aux1.getTitulo());
                System.out.println("");
            }
        }
        System.out.println("");
    }
    public static Comparator<Pelicula> ordenaDuracMayor = (Pelicula o1, Pelicula o2) -> o2.getDuracion().compareTo(o1.getDuracion());
    public static Comparator<Pelicula> ordenaDuracMenor = (Pelicula o1, Pelicula o2) -> o1.getDuracion().compareTo(o2.getDuracion());
    public static Comparator<Pelicula> ordenaDirector = (Pelicula o1, Pelicula o2) -> o1.getDirector().compareTo(o2.getDirector());
    public static Comparator<Pelicula> ordenaTitulo = (Pelicula o1, Pelicula o2) -> o1.getTitulo().compareTo(o2.getTitulo());

    // o1 y o2 son objetos que se utilizan para comparar. Hay que respetar el nombre de los mismos en ambas partes de la función.
    public void pelisMayorAMenor() {
        System.out.println("--Orden películas de mayor a menor--");
        Collections.sort(pelicula1, ordenaDuracMayor);
        Iterator<Pelicula> it = pelicula1.iterator();
        while (it.hasNext()) {
            Pelicula aux = it.next();
            System.out.println(aux.getTitulo() + "\n"
                    + aux.getDirector() + "\n"
                    + aux.getDuracion());

            System.out.println("");
        }
    }

    public void pelisMenorAMayor() {
        System.out.println("Orden peliculas de menor a mayor");
        Collections.sort(pelicula1, ordenaDuracMenor);
        Iterator<Pelicula> it = pelicula1.iterator();
        while (it.hasNext()) {
            Pelicula aux1 = it.next();
            System.out.println(aux1.getTitulo() + "\n"
                    + aux1.getDirector() + "\n"
                    + aux1.getDuracion());
            System.out.println("");
        }
    }
        public void ordenPelisTitulo() {
        System.out.println("--Orden alfabético de títulos--");
        Collections.sort(pelicula1, ordenaTitulo);
        Iterator<Pelicula> it1 = pelicula1.iterator();
        while (it1.hasNext()) {
            Pelicula next = it1.next();
            System.out.println(next.getTitulo());
            System.out.println("");
        }
    }

    public void ordenPelisDirector() {
        System.out.println("--Orden alfabético de directores--");
        Collections.sort(pelicula1, ordenaDirector);
        Iterator<Pelicula> it1 = pelicula1.iterator();
        while (it1.hasNext()) {
            Pelicula next = it1.next();
            System.out.println(next.getDirector() + "\n"
                    + next.getTitulo());
            System.out.println("");
        }
    }
    
}
