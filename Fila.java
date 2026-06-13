public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void enfileira(T info) {
        No<T> novo = new No<>(info);
        if (ultimo == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public T desenfileira() throws Exception {
        if (filaVazia()) 
            throw new FilaVaziaException();
        T info = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null; // evita memory leak
        }
        tamanho--;
        return info;
    }

    public T primeiro() throws Exception {
        if (filaVazia()) 
            throw new FilaVaziaException();
        return primeiro.getInfo();
    }

    public boolean filaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (filaVazia()) return "[fila vazia]";
        StringBuilder sb = new StringBuilder();
        No<T> atual = primeiro;
        while (atual != null) {
            sb.append("[").append(atual.getInfo()).append("]");
            if (atual.getProximo() != null) sb.append("->");
            atual = atual.getProximo();
        }
        sb.append("->\\");
        return sb.toString();
    }
}

class FilaVaziaException extends Exception {
    public FilaVaziaException() {
        super("Fila esta vazia");
    }
}
