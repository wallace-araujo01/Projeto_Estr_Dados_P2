public class TesteEtapa3 {
    public static void main(String[] args) {
        System.out.println("=== TESTE ETAPA 3: NossoHash e Catalogo ===\n");

        NossoHash<String, Integer> mapa = new NossoHash<>();
        mapa.put("um", 1);
        mapa.put("dois", 2);
        mapa.put("tres", 3);
        System.out.println("get('dois'): " + mapa.get("dois"));
        System.out.println("containsKey('tres'): " + mapa.containsKey("tres"));
        System.out.println("containsKey('quatro'): " + mapa.containsKey("quatro"));
        System.out.println("containsValue(1): " + mapa.containsValue(1));
        System.out.println("containsValue(99): " + mapa.containsValue(99));

        // Catalogo de Livros
        Catalogo catalogo = new Catalogo();

        Livro l1 = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Livro l2 = new Livro("978-85-352-3800-1", "Algoritmos", "Cormen", 2012);
        Livro l3 = new Livro("978-85-7255-353-9", "Java - Como Programar", "Deitel", 2017);
        Livro l4 = new Livro("978-65-5519-159-0", "Clean Code", "Martin", 2009);

        catalogo.cadastrar(l1);
        catalogo.cadastrar(l2);
        catalogo.cadastrar(l3);
        catalogo.cadastrar(l4);

        // Busca por ISBN
        Livro encontrado = catalogo.buscar("978-85-352-3800-1");
        System.out.println("Buscado: " + encontrado);

        Livro naoAchado = catalogo.buscar("000-00-000-0000-0");
        System.out.println("ISBN inexistente: " + naoAchado);

        System.out.println("\nexiste('978-65-5519-159-0'): " + catalogo.existe("978-65-5519-159-0"));
        System.out.println("existe('000-00-000-0000-0'): " + catalogo.existe("000-00-000-0000-0"));

        System.out.println("\n-- Exibindo tabela hash completa --");
        catalogo.exibirCatalogo();
    }
}
