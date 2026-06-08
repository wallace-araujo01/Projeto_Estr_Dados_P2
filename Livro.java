public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPub;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int anoPub, boolean disponivel) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
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

    public int getAnoPub() {
        return anoPub;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titulo + " - " + autor + " ( " + anoPub + " ) [" + disponivel + "]";
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}