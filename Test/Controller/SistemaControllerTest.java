package Controller;

import Modelo.Pelicula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaControllerTest {

    private final String rutaTest = "datos/test_peliculas.csv";

    @BeforeEach
    void prepararArchivo() throws IOException {
        Files.createDirectories(Paths.get("datos"));
        Files.write(Paths.get(rutaTest), List.of(
                "Inception,2010,Christopher Nolan,148",
                "Coco,2017,Lee Unkrich,105"
        ));
    }

    @Test
    void testCargarPeliculasDesdeCSV() {
        // Simular que el controlador usa el archivo de prueba
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));  // salir de inmediato

        SistemaController sistema = new SistemaController() {
            {
                // Redefinimos rutaArchivo dentro del constructor
                super.vista = new VistaFalsa(); // Evitar consola real
                super.archivo = new Controller.ArchivoController();
                List<Pelicula> pelis = archivo.cargarPeliculas(rutaTest);
                super.peliculaCtrl = new Controller.PeliculaController(pelis);
                super.rutaArchivo = rutaTest;
            }
        };

        List<Pelicula> lista = sistema.peliculaCtrl.obtenerPeliculas();
        assertEquals(2, lista.size());
        assertEquals("Inception", lista.get(0).getTitulo());
    }

    @AfterEach
    void limpiarArchivo() throws IOException {
        Files.deleteIfExists(Paths.get(rutaTest));
    }

    // Vista falsa que no requiere consola real
    static class VistaFalsa extends Vista.ConsolaVista {
        @Override
        public int leerOpcion() {
            return 3; // Simula que el usuario elige "Salir"
        }

        @Override
        public void mostrarMensaje(String mensaje) {
            // No hace nada en test
        }

        @Override
        public void mostrarPeliculas(List<Pelicula> peliculas) {
            // No imprime
        }

        @Override
        public Pelicula pedirDatosPelicula() {
            return new Pelicula("Fake", 2020, "Director Falso", 120);
        }
    }
}
