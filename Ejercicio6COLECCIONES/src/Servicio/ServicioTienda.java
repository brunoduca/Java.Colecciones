/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package Servicio;

import Entidades.Tienda;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ServicioTienda {

    HashMap<String, Double> tienda = new HashMap<>();
    Tienda t1 = new Tienda();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menu() throws AWTException {
        int opcion;
        System.out.println("Bienvenido!");
        do {
            System.out.println("Ingrese una de las siguientes opciones: \n"
                    + "1. Ingresar productos \n"
                    + "2. Modificar precios \n"
                    + "3. Eliminar productos \n"
                    + "4. Mostrar productos \n"
                    + "5. Salir ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    ingresarProductos();
                    break;
                case 2:
                    modificarPrecio();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println(" La opción ingresada no es correcta.");
            }
            limpiarpantalla();
        } while (opcion != 5);
        System.out.println("Muchas gracias! Hasta luego");
    }

    public static void limpiarpantalla() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
    }

    /*Introduce tu código desde aquí*/
    public void ingresarProductos() {
        String opcion;
        do {
            System.out.println("Ingrese un producto");
            t1.setProducto(leer.next().toLowerCase());
            System.out.println("Ingrese el precio del producto");
            t1.setPrecio(leer.nextDouble());
            tienda.put(t1.getProducto(), t1.getPrecio());
            System.out.println("¿Desea seguir agregando productos?(S/N)");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("S"));

    }

    public void modificarPrecio() {
        String opcion;
        System.out.println("Ingrese el producto cuyo precio desea modificar");
        opcion = leer.next().toLowerCase();
        if (tienda.containsKey(opcion)) {
            System.out.println("Ingrese el nuevo precio");
            t1.setPrecio(leer.nextDouble());
            tienda.replace(opcion, t1.getPrecio());
        }
    }

    public void eliminarProducto() {
        String opcion;
        System.out.println("Ingrese el producto que desea eliminar");
        opcion = leer.next().toLowerCase();
        tienda.remove(opcion);
    }

    public void OrdenPrecio() {
        tienda.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> System.out.println("" + entry.getKey() + " $" + entry.getValue()));
    }

    public void OrdenNombre() {
        tienda.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> System.out.println("" + entry.getKey() + " $ " + entry.getValue()));
    }

    public void mostrarProductos() {
        System.out.println("--------PRODUCTOS--------");
        tienda.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " $" + value);
        });
        System.out.println("Orden por precios:");
        OrdenPrecio();
        OrdenNombre();
    }

}
