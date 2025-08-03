package Vista;

import Modelo.Pelicula;
import java.util.List;
import java.util.Scanner;

/**
 * Vista en consola para interactuar con el usuario.
 */
public class ConsolaVista {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Ver películas");
        System.out.println("2. Agregar película");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles.");
        } else {
            for (Pelicula p : peliculas) {
                System.out.println("🎬 " + p.getTitulo() + " (" + p.getAnio() + ") - Dir. " + p.getDirector());
            }
        }
    }

    public Pelicula pedirDatosPelicula() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());

        return new Pelicula(titulo, anio, director, duracion);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}