package Controller;

import Modelo.Pelicula;
import java.util.List;

/**
 * Controlador para manejar la lista de películas en memoria.
 */
public class PeliculaController {
    private final List<Pelicula> peliculas;

    public PeliculaController(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Pelicula nueva) {
        peliculas.add(nueva);
    }
}