import java.util.Scanner;
public class BibliotecaDigital {
    private Catalogo catalogo;
    private ListaDupla acervo;
    private GestorEmprestimos gestor;
    private Scanner sc;

    public BibliotecaDigital() {
        this.catalogo = new Catalogo();
        this.acervo = new ListaDupla();
        this.gestor = new GestorEmprestimos();
        this.sc = new Scanner(System.in);
    }

    public void cadastrarLivro(Livro livro) {
        acervo.insereFim(livro);
        catalogo.cadastrar(livro);
        gestor.registrarLivro(livro);
    }

    private void menu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║      BIBLIOTECA DIGITAL - MENU       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Cadastrar livro                  ║");
        System.out.println("║  2. Buscar livro por ISBN            ║");
        System.out.println("║  3. Listar acervo (inicio -> fim)    ║");
        System.out.println("║  4. Listar acervo (fim -> inicio)    ║");
        System.out.println("║  5. Solicitar emprestimo             ║");
        System.out.println("║  6. Devolver livro                   ║");
        System.out.println("║  7. Ver fila de espera               ║");
        System.out.println("║  8. Exibir catalogo (tabela hash)    ║");
        System.out.println("║  0. Sair                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Opcao: ");
    }

    public void executar() throws Exception {
        System.out.println("Bem-vindo(a) a Biblioteca Digital!");
        int opcao;
        do {
            menu();
            opcao = sc.nextInt();
            System.out.println();
            switch (opcao) {
                case 1 -> opcaoCadastrarLivro();
                case 2 -> opcaoBuscarLivro();
                case 3 -> { System.out.println("Acervo (inicio ao fim):"); acervo.listarDoInicio(); }
                case 4 -> { System.out.println("Acervo (fim ao inicio):"); acervo.listarDoFim(); }
                case 5 -> opcaoSolicitarEmprestimo();
                case 6 -> opcaoDevolverLivro();
                case 7 -> opcaoVerFila();
                case 8 -> catalogo.exibirCatalogo();
                case 0 -> System.out.println("Encerrando o sistema. Ate logo!");
                default -> System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        sc.close();
    }

    private void opcaoCadastrarLivro() {
        System.out.print("ISBN: ");      String isbn  = sc.nextLine().trim();
        System.out.print("Titulo: ");    String titulo = sc.nextLine().trim();
        System.out.print("Autor: ");     String autor  = sc.nextLine().trim();
        System.out.print("Ano de publicacao: "); int ano = Integer.parseInt(sc.nextLine().trim());
        cadastrarLivro(new Livro(isbn, titulo, autor, ano));
    }

    private void opcaoBuscarLivro() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine().trim();
        Livro l = catalogo.buscar(isbn);
        if (l != null) System.out.println("  Encontrado: " + l);
        else           System.out.println("  Livro nao encontrado.");
    }

    private void opcaoSolicitarEmprestimo() {
        System.out.print("ISBN do livro: ");
        String isbn = sc.nextLine().trim();
        System.out.print("Matricula do usuario: ");
        int mat = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nome do usuario: ");
        String nome = sc.nextLine().trim();
        System.out.print("Email do usuario: ");
        String email = sc.nextLine().trim();
        gestor.solicitarEmprestimo(isbn, new Usuario(mat, nome, email));
    }

    private void opcaoDevolverLivro() throws Exception{
        System.out.print("ISBN do livro: ");
        String isbn = sc.nextLine().trim();
        gestor.devolverLivro(isbn);
    }

    private void opcaoVerFila() {
        System.out.print("ISBN do livro: ");
        String isbn = sc.nextLine().trim();
        gestor.listarFilaDeEspera(isbn);
    }

    public static void main(String[] args) throws Exception {
        new BibliotecaDigital().executar();
    }
}
