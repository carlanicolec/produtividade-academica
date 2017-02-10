package base;

public class Professor extends Orientador {


    public Professor(String nome, String email, Publicacoes publicacoes, Projeto projetos, int cpf) {
        super(nome, email, publicacoes, projetos, cpf);

    }

    public Professor(String nome, String email, int cpf) {
        super(nome, email, cpf);
    }


    public Professor() {
    }
}
