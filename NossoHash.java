@SuppressWarnings("unchecked")
public class NossoHash<K, V> {
    private static final int CAPACIDADE_INICIAL = 16;
    private Entrada<K, V>[] tabela;
    private int tamanho;

    public NossoHash() {
        tabela = new Entrada[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    // Função hash vista em aula: usa hashCode() do Java comprimido para o tamanho da tabela
    private int funcaoHash(K key) {
        int hash = key.hashCode();
        if (hash < 0) hash = -hash;
        return hash % tabela.length;
    }

    public void put(K key, V value) {
        int pos = funcaoHash(key);
        Entrada<K, V> nova = new Entrada<>(key, value);
        // Insere no início da cadeia (encadeamento externo)
        nova.proximo = tabela[pos];
        tabela[pos] = nova;
        tamanho++;
    }

    public V get(K key) {
        int pos = funcaoHash(key);
        Entrada<K, V> atual = tabela[pos];
        while (atual != null) {
            if (atual.key.equals(key)) return atual.value;
            atual = atual.proximo;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int pos = funcaoHash(key);
        Entrada<K, V> atual = tabela[pos];
        while (atual != null) {
            if (atual.key.equals(key)) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < tabela.length; i++) {
            Entrada<K, V> atual = tabela[i];
            while (atual != null) {
                if (atual.value != null && atual.value.equals(value)) return true;
                atual = atual.proximo;
            }
        }
        return false;
    }

    public void exibeMap() {
        System.out.println("=== Tabela Hash (" + tamanho + " entradas) ===");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("  [" + String.format("%2d", i) + "] ");
            if (tabela[i] == null) {
                System.out.println("vazio");
            } else {
                Entrada<K, V> atual = tabela[i];
                while (atual != null) {
                    System.out.print("(" + atual.key + " -> " + atual.value + ")");
                    if (atual.proximo != null) System.out.print(" -> ");
                    atual = atual.proximo;
                }
                System.out.println();
            }
        }
    }

    public int tamanho() {
        return tamanho;
    }
}
