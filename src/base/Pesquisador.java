package base;

public class Pesquisador extends Orientador{


    public Pesquisador(String nome, String email, Publicacoes publicacoes, Projeto projetos, int cpf) {
        super(nome, email, publicacoes, projetos, cpf);
    }

    public Pesquisador(String nome, String email, int cpf) {
        super(nome, email, cpf);
    }

    public Pesquisador() {
    }
}
