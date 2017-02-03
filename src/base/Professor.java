package base;

public class Professor extends Usuario {

    private int tipo; //1 - professor; 2 - pesquisador;

    public Professor(String nome, String email, int tipo) {
        super(nome, email);
        this.tipo = tipo;
    }

    public Professor(String nome, String email, Publicacoes publicacoes, Projeto projetos, int tipo) {
        super(nome, email, publicacoes, projetos);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
