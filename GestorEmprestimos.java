public class GestorEmprestimos {
    // ISBN -> fila de usuários aguardando
    private NossoHash<String, Fila<Usuario>> filasPorIsbn;
    // ISBN -> livro (referência para alterar disponibilidade)
    private NossoHash<String, Livro> acervo;

    public GestorEmprestimos() {
        this.filasPorIsbn = new NossoHash<>();
        this.acervo = new NossoHash<>();
    }

    // Registra o livro no gestor para que ele possa ser manipulado
    public void registrarLivro(Livro livro) {
        acervo.put(livro.getIsbn(), livro);
        filasPorIsbn.put(livro.getIsbn(), new Fila<>());
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = acervo.get(isbn);
        if (livro == null) {
            System.out.println("  ERRO: Livro com ISBN " + isbn + " nao encontrado no sistema.");
            return;
        }
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("  Emprestimo realizado: '" + livro.getTitulo()
                    + "' para " + u.getNome() + ".");
        } else {
            Fila<Usuario> fila = filasPorIsbn.get(isbn);
            fila.enfileira(u);
            System.out.println("  Livro indisponivel. " + u.getNome()
                    + " entrou na fila de espera (posicao " + fila.tamanho() + ").");
        }
    }

    public void devolverLivro(String isbn) throws Exception {
        Livro livro = acervo.get(isbn);
        if (livro == null) {
            System.out.println("  ERRO: Livro com ISBN " + isbn + " nao encontrado.");
            return;
        }
        Fila<Usuario> fila = filasPorIsbn.get(isbn);
        if (fila == null || fila.filaVazia()) {
            livro.setDisponivel(true);
            System.out.println("  Livro '" + livro.getTitulo() + "' devolvido. Nenhum usuario em espera.");
        } else {
            Usuario proximo = fila.desenfileira();
            // livro continua indisponivel — vai direto para o próximo da fila
            System.out.println("  Livro '" + livro.getTitulo() + "' devolvido e automaticamente emprestado para "
                    + proximo.getNome() + ".");
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Livro livro = acervo.get(isbn);
        String titulo = (livro != null) ? livro.getTitulo() : isbn;
        Fila<Usuario> fila = filasPorIsbn.get(isbn);
        if (fila == null || fila.filaVazia()) {
            System.out.println("  Fila de espera para '" + titulo + "': [vazia]");
        } else {
            System.out.println("  Fila de espera para '" + titulo + "': " + fila);
        }
    }
}
