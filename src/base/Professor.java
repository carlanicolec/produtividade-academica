package base;

public class Professor extends Orientador {


    public Professor(String nome, String email, Publicacoes publicacoes, Projeto projetos, int tipo) {
        super(nome, email, publicacoes, projetos);

    }

    public Professor(String nome, String email) {
        super(nome, email);
    }


    public Professor() {
    }
}
