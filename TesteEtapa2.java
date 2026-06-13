public class TesteEtapa2 {
    public static void main(String[] args) throws Exception{
        // Teste direto da Fila
        Fila<String> filaStr = new Fila<>();
        filaStr.enfileira("Alice");
        filaStr.enfileira("Bob");
        filaStr.enfileira("Carlos");
        System.out.println("Estado: " + filaStr);
        System.out.println("Tamanho: " + filaStr.tamanho());
        System.out.println("Primeiro: " + filaStr.primeiro());
        System.out.println("Desenfileira: " + filaStr.desenfileira());
        System.out.println("Apos remocao: " + filaStr);

        Fila<Integer> filaInt = new Fila<>();
        try {
            filaInt.desenfileira();
        } catch (FilaVaziaException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        // GestorEmprestimos
        System.out.println("\n=== Simulacao GestorEmprestimos ===\n");

        Livro livro = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Usuario u1 = new Usuario(1001, "Ana Lima", "ana@uni.br");
        Usuario u2 = new Usuario(1002, "Bruno Souza", "bruno@uni.br");
        Usuario u3 = new Usuario(1003, "Carla Dias", "carla@uni.br");

        GestorEmprestimos gestor = new GestorEmprestimos();
        gestor.registrarLivro(livro);

        System.out.println("-- Emprestimo do livro disponivel --");
        gestor.solicitarEmprestimo(livro.getIsbn(), u1);

        System.out.println("\n-- Tentativas com livro indisponivel (geram fila) --");
        gestor.solicitarEmprestimo(livro.getIsbn(), u2);
        gestor.solicitarEmprestimo(livro.getIsbn(), u3);

        System.out.println("\n-- Fila de espera atual --");
        gestor.listarFilaDeEspera(livro.getIsbn());

        System.out.println("\n-- Primeira devolucao (atende proximo da fila: Bruno) --");
        gestor.devolverLivro(livro.getIsbn());

        System.out.println("\n-- Fila apos primeira devolucao --");
        gestor.listarFilaDeEspera(livro.getIsbn());

        System.out.println("\n-- Segunda devolucao (atende Carla) --");
        gestor.devolverLivro(livro.getIsbn());

        System.out.println("\n-- Terceira devolucao (fila vazia, livro fica disponivel) --");
        gestor.devolverLivro(livro.getIsbn());

        System.out.println("\n-- Estado final do livro --");
        System.out.println(livro);
    }
}
