package Modelo;

public abstract class ContenidoAudiovisual {
    protected String titulo;
    protected int anio;

    public ContenidoAudiovisual(String titulo, int anio) {
        this.titulo = titulo;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    // Método abstracto que las subclases deben implementar
    public abstract String toCSV();
}