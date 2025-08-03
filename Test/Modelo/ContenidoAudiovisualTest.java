package Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContenidoAudiovisualTest {

    // Clase de prueba que extiende ContenidoAudiovisual
    static class ContenidoTest extends ContenidoAudiovisual {
        public ContenidoTest(String titulo, int anio) {
            super(titulo, anio);
        }

        @Override
        public String toCSV() {
            return titulo + "," + anio;
        }
    }

    @Test
    void testGetters() {
        ContenidoAudiovisual contenido = new ContenidoTest("Test Movie", 2025);
        assertEquals("Test Movie", contenido.getTitulo());
        assertEquals(2025, contenido.getAnio());
    }

    @Test
    void testToCSV() {
        ContenidoAudiovisual contenido = new ContenidoTest("Demo", 2000);
        assertEquals("Demo,2000", contenido.toCSV());
    }
}
