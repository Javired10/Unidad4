package Controller;

import Modelo.Pelicula;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeliculaControllerTest {

    @Test
    void testObtenerPeliculasIniciales() {
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Coco", 2017, "Lee Unkrich", 105));

        PeliculaController controller = new PeliculaController(lista);
        List<Pelicula> resultado = controller.obtenerPeliculas();

        assertEquals(1, resultado.size());
        assertEquals("Coco", resultado.get(0).getTitulo());
    }

    @Test
    void testAgregarPelicula() {
        List<Pelicula> lista = new ArrayList<>();
        PeliculaController controller = new PeliculaController(lista);

        Pelicula nueva = new Pelicula("Inception", 2010, "Christopher Nolan", 148);
        controller.agregarPelicula(nueva);

        List<Pelicula> resultado = controller.obtenerPeliculas();
        assertEquals(1, resultado.size());
        assertEquals("Inception", resultado.get(0).getTitulo());
    }
}