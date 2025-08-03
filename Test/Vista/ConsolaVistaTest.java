package Vista;

import Modelo.Pelicula;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsolaVistaTest {

    @Test
    void testMostrarPeliculasVacia() {
        ConsolaVista vista = new ConsolaVista();
        vista.mostrarPeliculas(List.of()); // No hay assert directo porque imprime a consola
    }

    @Test
    void testMostrarPeliculasConContenido() {
        ConsolaVista vista = new ConsolaVista();
        vista.mostrarPeliculas(List.of(
                new Pelicula("Inception", 2010, "Christopher Nolan", 148)
        ));
    }

    @Test
    void testPedirDatosPelicula() {
        // Simular entrada de usuario:
        // "Matrix", "1999", "Wachowski", "136"
        String simulatedInput = String.join("\n", "Matrix", "1999", "Wachowski", "136");
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsolaVista vista = new ConsolaVista();
        Pelicula pelicula = vista.pedirDatosPelicula();

        assertEquals("Matrix", pelicula.getTitulo());
        assertEquals(1999, pelicula.getAnio());
        assertEquals("Wachowski", pelicula.getDirector());
        assertEquals(136, pelicula.getDuracion());
    }
}