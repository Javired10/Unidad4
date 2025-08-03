package Controller;

import Modelo.Pelicula;
import Vista.ConsolaVista;

import java.util.List;

/**
 * Controlador principal del sistema.
 */
public class SistemaController {
    ConsolaVista vista;
    ArchivoController archivo;
    PeliculaController peliculaCtrl;
    String rutaArchivo = "datos/peliculas.csv";

    public SistemaController() {
        vista = new ConsolaVista();
        archivo = new ArchivoController();
        List<Pelicula> cargadas = archivo.cargarPeliculas(rutaArchivo);
        peliculaCtrl = new PeliculaController(cargadas);
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1 -> vista.mostrarPeliculas(peliculaCtrl.obtenerPeliculas());
                case 2 -> {
                    Pelicula nueva = vista.pedirDatosPelicula();
                    peliculaCtrl.agregarPelicula(nueva);
                    archivo.guardarPeliculas(rutaArchivo, peliculaCtrl.obtenerPeliculas());
                    vista.mostrarMensaje("✅ Película guardada.");
                }
                case 3 -> vista.mostrarMensaje("👋 Saliendo del sistema.");
                default -> vista.mostrarMensaje("⚠ Opción no válida.");
            }
        } while (opcion != 3);
    }
}