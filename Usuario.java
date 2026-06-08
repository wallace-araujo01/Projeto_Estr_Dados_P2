public class Usuario {
    private int matricula;
    private String nome;
    private String email;

    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    } 
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return "[" + matricula + "] " + nome + " - " + email;
    }
}