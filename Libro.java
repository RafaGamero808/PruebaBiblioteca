public class Libro {

    public String isbn;
    public String titulo;
    public int numeroPaginas;
    public String autor;
    public boolean prestado;

    //constructor
    public Libro(String isbn, String titulo, int numeroPaginas, String autor, boolean prestado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.prestado = prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    //método para comprobar disponibilidad del libro

    public void disponibilidad() {
        if (this.prestado) {
            prestado = true;
            System.out.println("El libro" + " " + this.titulo + " " + "del autor" + " " + this.autor + " " + "no está disponible");
        }
        else {
            prestado = false;
            System.out.println("El libro" + " " + this.titulo + " " + "del autor" + " " + this.autor + " " + "está disponible");
        }
    }



}
