import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private static final String RUTA_TEST = "datos/test_peliculas.csv";

    @BeforeEach
    void borrarArchivoPrevio() throws IOException {
        Files.createDirectories(Paths.get("datos"));
        Files.deleteIfExists(Paths.get(RUTA_TEST));
    }

    @Test
    void testCrearArchivoConPeliculasPorDefecto() {
        // Ejecutamos el método
        App.crearArchivoConPeliculasPorDefecto(RUTA_TEST);

        File archivo = new File(RUTA_TEST);
        assertTrue(archivo.exists(), " El archivo CSV debería haberse creado");

        try {
            List<String> lineas = Files.readAllLines(archivo.toPath());
            assertEquals(4, lineas.size(), "El archivo debe contener 4 películas");
            assertTrue(lineas.get(0).startsWith("Titanic"), "La primera línea debe ser Titanic");
        } catch (IOException e) {
            fail(" No se pudo leer el archivo generado");
        }
    }

    @Test
    void testNoSobrescribeArchivoExistente() throws IOException {
        // Crear archivo manualmente
        Files.write(Paths.get(RUTA_TEST), List.of("PeliculaX,2000,Falso,90"));

        // Ejecutar el método que NO debe sobrescribir
        App.crearArchivoConPeliculasPorDefecto(RUTA_TEST);

        List<String> lineas = Files.readAllLines(Paths.get(RUTA_TEST));
        assertEquals(1, lineas.size(), " El archivo no debe ser sobrescrito si ya existe");
        assertEquals("PeliculaX,2000,Falso,90", lineas.get(0));
    }

    @AfterEach
    void limpiar() throws IOException {
        Files.deleteIfExists(Paths.get(RUTA_TEST));
    }
}
