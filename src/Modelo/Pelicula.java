package Modelo;

public class Pelicula extends ContenidoAudiovisual {
    private String director;
    private int duracion;

    public Pelicula(String titulo, int anio, String director, int duracion) {
        super(titulo, anio);
        this.director = director;
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toCSV() {
        return String.format("%s,%d,%s,%d", titulo, anio, director, duracion);
    }
}