public class TesteEtapa1 {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        Livro l1 = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Livro l2 = new Livro("978-85-352-3800-1", "Algoritmos", "Cormen", 2012);
        Livro l3 = new Livro("978-85-7255-353-9", "Java - Como Programar", "Deitel", 2017);
        Livro l4 = new Livro("978-65-5519-159-0", "Clean Code", "Martin", 2009);

        // Inserções
        System.out.println("-- Inserindo livros --");
        lista.insereFim(l1);
        lista.insereFim(l2);
        lista.insereFim(l3);
        lista.insereInicio(l4);  // insere no inicio
        System.out.println("Tamanho da lista: " + lista.tamanho());

        System.out.println("\n-- Listagem do INICIO ao FIM --");
        lista.listarDoInicio();

        System.out.println("\n-- Listagem do FIM ao INICIO --");
        lista.listarDoFim();

        // Busca por ISBN
        String isbnBusca = "978-85-352-3800-1";
        Livro encontrado = lista.buscarPorIsbn(isbnBusca);
        System.out.println("Buscando " + isbnBusca + ": " + (encontrado != null ? encontrado : "nao encontrado"));

        String isbnInexistente = "000-00-000-0000-0";
        Livro naoEncontrado = lista.buscarPorIsbn(isbnInexistente);
        System.out.println("Buscando " + isbnInexistente + ": " + (naoEncontrado != null ? naoEncontrado : "nao encontrado"));

        // Remoções
        System.out.println("\n-- Removendo primeiro e ultimo --");
        Livro removido1 = lista.removePrimeiro();
        System.out.println("Removido do inicio: " + removido1);
        Livro removido2 = lista.removeUltimo();
        System.out.println("Removido do fim:    " + removido2);

        System.out.println("\n-- Lista apos remocoes (tamanho: " + lista.tamanho() + ") --");
        lista.listarDoInicio();

        // Esvaziar e testar null
        System.out.println("\n-- Esvaziando a lista --");
        lista.removePrimeiro();
        lista.removePrimeiro();
        System.out.println("Tentar remover de lista vazia: " + lista.removePrimeiro());
        System.out.println("Tamanho final: " + lista.tamanho());
    }
}
