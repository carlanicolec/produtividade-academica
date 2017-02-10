package base;


public class Orientador extends Usuario {
    public Orientador(String nome, String email, Publicacoes publicacoes, Projeto projetos, int cpf) {
        super(nome, email, publicacoes, projetos, cpf);
    }

    public Orientador(String nome, String email, int cpf) {
        super(nome, email, cpf);
    }

    public Orientador() {
    }
}
