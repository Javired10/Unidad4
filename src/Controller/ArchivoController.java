package Controller;

// Importamos la clase Pelicula del paquete modelo
import Modelo.Pelicula;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase para manejar la lectura y escritura de archivos CSV con películas.
 */
public class ArchivoController {

    /**
     * Carga una lista de películas desde un archivo CSV.
     * @param rutaArchivo Ruta del archivo .csv
     * @return Lista de objetos Pelicula
     */
    public List<Pelicula> cargarPeliculas(String rutaArchivo) {
        List<Pelicula> peliculas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 4) {
                    String titulo = datos[0];
                    int anio = Integer.parseInt(datos[1]);
                    String director = datos[2];
                    int duracion = Integer.parseInt(datos[3]);

                    Pelicula pelicula = new Pelicula(titulo, anio, director, duracion);
                    peliculas.add(pelicula);
                }
            }
        } catch (IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Error en el formato numérico: " + e.getMessage());
        }

        return peliculas;
    }

    /**
     * Guarda una lista de películas en un archivo CSV.
     * @param rutaArchivo Ruta donde guardar el archivo
     * @param peliculas Lista de objetos Pelicula
     */
    public void guardarPeliculas(String rutaArchivo, List<Pelicula> peliculas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Pelicula p : peliculas) {
                pw.println(p.toCSV());
            }
        } catch (IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }
}