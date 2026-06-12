public class NoDuplo {
    private Livro info;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Livro info) {
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }

    public Livro getInfo()         { return info; }
    public NoDuplo getProximo()    { return proximo; }
    public NoDuplo getAnterior()   { return anterior; }

    public void setInfo(Livro info)          { this.info = info; }
    public void setProximo(NoDuplo proximo)  { this.proximo = proximo; }
    public void setAnterior(NoDuplo anterior){ this.anterior = anterior; }
}
