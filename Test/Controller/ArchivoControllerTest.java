package Controller;

import Modelo.Pelicula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoControllerTest {

    private final String rutaTest = "datos/test_peliculas.csv";
    private ArchivoController archivo;

    @BeforeEach
    void preparar() throws IOException {
        archivo = new ArchivoController();
        Files.createDirectories(Paths.get("datos"));
        Files.deleteIfExists(Paths.get(rutaTest)); // Limpieza previa
    }

    @Test
    void testGuardarPeliculas() {
        List<Pelicula> lista = List.of(
                new Pelicula("Matrix", 1999, "Wachowski", 136),
                new Pelicula("Interstellar", 2014, "Christopher Nolan", 169)
        );

        archivo.guardarPeliculas(rutaTest, lista);
        File archivoGenerado = new File(rutaTest);

        assertTrue(archivoGenerado.exists(), "El archivo debería haberse creado");

        try {
            List<String> lineas = Files.readAllLines(archivoGenerado.toPath());
            assertEquals(2, lineas.size());
            assertEquals("Matrix,1999,Wachowski,136", lineas.get(0));
        } catch (IOException e) {
            fail("No se pudo leer el archivo generado");
        }
    }

    @Test
    void testCargarPeliculasDesdeArchivoValido() throws IOException {
        Files.write(Paths.get(rutaTest), List.of(
                "Titanic,1997,James Cameron,195",
                "Avatar,2009,James Cameron,162"
        ));

        List<Pelicula> peliculas = archivo.cargarPeliculas(rutaTest);

        assertEquals(2, peliculas.size());
        assertEquals("Titanic", peliculas.get(0).getTitulo());
        assertEquals(1997, peliculas.get(0).getAnio());
        assertEquals("James Cameron", peliculas.get(0).getDirector());
        assertEquals(195, peliculas.get(0).getDuracion());
    }

    @Test
    void testCargarArchivoInexistente() {
        List<Pelicula> peliculas = archivo.cargarPeliculas("datos/no_existe.csv");
        assertTrue(peliculas.isEmpty(), "Si el archivo no existe, la lista debe estar vacía");
    }

    @Test
    void testCargarArchivoConFormatoInvalido() throws IOException {
        Files.write(Paths.get(rutaTest), List.of(
                "Invalido,sin,campos"
        ));

        List<Pelicula> peliculas = archivo.cargarPeliculas(rutaTest);
        assertEquals(0, peliculas.size(), "No se deben cargar líneas con formato inválido");
    }

    @AfterEach
    void limpiar() throws IOException {
        Files.deleteIfExists(Paths.get(rutaTest));
    }
}
