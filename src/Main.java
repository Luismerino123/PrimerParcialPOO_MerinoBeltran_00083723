import Articulos.ArticulosDispo;
import Inentario.Articulos;
import Articulos.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<ArticulosDispo> listaDeArticulos = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        Scanner sn = new Scanner(System.in);
        int opcion;
        while(true){
            try {
                imprimirMenu();
                opcion = sn.nextInt();
                sn.nextLine();

                if(opcion == 0){
                    System.out.println("\nHasta pronto...");
                    break;
                }

                switch (opcion){
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        modificarProducto();
                        break;
                    case 3:
                        mostrarProducto();
                        break;
                    case 4:
                        mostrarListaProductos();
                        break;
                    default:
                        System.out.println("\nPor favor seleccione una opcion del menu\n");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("\nPor favor ingrese un dato valido\n");
                sn.nextLine();
            }
        }
    }

    private static void mostrarListaProductos() {
        System.out.println("************PRODUCTOS***********");
        for (ArticulosDispo art : listaDeArticulos) {
            System.out.printf("%d - %s\n%s\n%.2f\n%s\n\n",
                    listaDeArticulos.indexOf(art) + 1,
                    art.getNombre(),
                    art.getModelo(),
                    art.getPrecio(),
                    art.getDescripcion());
        }
    }

    private static void mostrarProducto() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese el modelo del producto a mostrar:");
        String modelo = sn.nextLine();

        for (ArticulosDispo art : listaDeArticulos) {
            if (art.getModelo().equals(modelo)){
                System.out.printf("Tipo de articulo: %s\nNombre del articulo: %s\nModelo del articulo: %s\nDescripcion del articulo: %s\nPrecio del articulo: %.2f\n",
                        art.getTipo(),
                        art.getNombre(),
                        art.getModelo(),
                        art.getDescripcion(),
                        art.getPrecio());
                return;
            }
        }
    }

    private static void modificarProducto() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese el modelo del articulo a modificar:");
        String modelo = sn.nextLine();

        for (ArticulosDispo art : listaDeArticulos) {
            if (art.getModelo().equals(modelo)){
                System.out.printf("Ingrese el nuevo precio para %s en USD: $", art.getNombre());
                float nuevoPrecio = sn.nextFloat();
                art.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado exitosamente...\n");
                return;
            }
        }
    }

    private static void agregarProducto() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        String nombre = sn.nextLine();
        System.out.println("Ingrese el modelo del producto:");
        String modelo = sn.nextLine();
        System.out.println("Ingrese una descripcion detallada del producto:");
        String descripcion = sn.nextLine();
        System.out.println("Ingrese el precio del producto:");
        float precio = sn.nextFloat();

        Articulos articulo = new Articulos(nombre, modelo, descripcion, precio);
        sn.nextLine(); // Clear buffer after reading float

        System.out.println("Ingrese el tipo de aparato electronico:");
        String tipo = sn.nextLine();
        System.out.println("Ingrese el precio base del aparato:");
        float precioBase = sn.nextFloat();

        int tipoProducto = obtenerTipoProducto();
        ArticulosDispo articulosDispo = null;

        switch (tipoProducto){
            case 1:
                articulosDispo = new Telefono(articulo, tipo, precioBase);
                break;
            case 2:
                articulosDispo = new Laptop(articulo, tipo, precioBase);
                break;
        }

        listaDeArticulos.add(articulosDispo);
        System.out.println("\nArticulo agregado exitosamente...\n");
    }

    private static int obtenerTipoProducto() {
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione en que tipo de aparato electonico va a guardarlo:\n"
                    + "\t1. Telefono\n"
                    + "\t2. Laptop\n");
            System.out.print("Opcion -> ");
            int opcion = sn.nextInt();
            sn.nextLine(); // Clear buffer after reading int
            if(opcion == 1 || opcion == 2) return opcion;

            System.out.println("\nPor favor ingrese una opcion valida");}
    }
    private static void imprimirMenu() {
        System.out.println("Seleccione una opcion:\n"
                + "\t1. Agregar producto\n"
                + "\t2. Modificar producto\n"
                + "\t3. Mostrar datos de un Producto\n"
                + "\t4. Mostrar todos los productos\n"
                + "\t0. Salir"
        );
        System.out.print("Opcion -> ");
    }
}
