package base;


public class Orientador extends Usuario {
    public Orientador(String nome, String email, Publicacoes publicacoes, Projeto projetos) {
        super(nome, email, publicacoes, projetos);
    }

    public Orientador(String nome, String email) {
        super(nome, email);
    }

    public Orientador() {
    }
}
