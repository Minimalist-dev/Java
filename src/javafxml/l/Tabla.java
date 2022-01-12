package javafxml.l;

/**
 *
 * @author neury-dev
 */
public class Tabla {
    private int id;
    private String titulo;
    private String autor;
    private int year;
    private int pagina;

    public Tabla(int id, String titulo, String autor, int year, int pagina) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.pagina = pagina;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPagina() {
        return pagina;
    }
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
}
