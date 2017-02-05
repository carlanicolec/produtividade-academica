package base;

public class Pesquisador extends Orientador{


    public Pesquisador(String nome, String email, Publicacoes publicacoes, Projeto projetos) {
        super(nome, email, publicacoes, projetos);
    }

    public Pesquisador(String nome, String email) {
        super(nome, email);
    }

    public Pesquisador() {
    }
}
