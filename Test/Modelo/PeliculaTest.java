package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
    void testDatosPelicula() {
        Pelicula p = new Pelicula("Inception", 2010, "Christopher Nolan", 148);
        assertEquals("Inception", p.getTitulo());
        assertEquals(2010, p.getAnio());
        assertEquals("Christopher Nolan", p.getDirector());
        assertEquals(148, p.getDuracion());
    }

    @Test
    void testToCSV() {
        Pelicula p = new Pelicula("Matrix", 1999, "Wachowski", 136);
        assertEquals("Matrix,1999,Wachowski,136", p.toCSV());
    }
}