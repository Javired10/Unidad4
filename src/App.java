import Controller.SistemaController;
import Modelo.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        crearArchivoConPeliculasPorDefecto("datos/peliculas.csv");
        new SistemaController().iniciar();
    }

    public static void crearArchivoConPeliculasPorDefecto(String rutaArchivo) {
        File archivo = new File(rutaArchivo);

        if (archivo.exists()) return;

        archivo.getParentFile().mkdirs();

        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Titanic", 1997, "James Cameron", 195));
        peliculas.add(new Pelicula("Inception", 2010, "Christopher Nolan", 148));
        peliculas.add(new Pelicula("Matrix", 1999, "Wachowski", 136));
        peliculas.add(new Pelicula("Avatar", 2009, "James Cameron", 162));

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Pelicula item : peliculas) {
                pw.println(item.toCSV()); // Ya no usamos interfaces
            }
            System.out.println(" Archivo " + rutaArchivo + " creado con datos de prueba.");
        } catch (IOException e) {
            System.out.println(" Error al crear el archivo CSV: " + e.getMessage());
        }
    }
}