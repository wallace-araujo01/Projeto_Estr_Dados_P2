public class Catalogo {
    private NossoHash<String, Livro> mapa;

    public Catalogo() {
        this.mapa = new NossoHash<>();
    }

    public void cadastrar(Livro livro) {
        mapa.put(livro.getIsbn(), livro);
        System.out.println("  Livro cadastrado no catalogo: " + livro.getTitulo());
    }

    public Livro buscar(String isbn) {
        return mapa.get(isbn);
    }

    public boolean existe(String isbn) {
        return mapa.containsKey(isbn);
    }

    public void exibirCatalogo() {
        mapa.exibeMap();
    }
}
