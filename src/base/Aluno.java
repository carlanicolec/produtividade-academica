package base;

public class Aluno extends Usuario {
    private int tipo_aluno; //1 - graduação; 2 - mestrado; 3 - doutorado;


    public Aluno(String nome, String email, Publicacoes publicacoes, Projeto projetos, int tipo){
        super(nome, email, publicacoes, projetos);
        this.tipo_aluno = tipo;
    }

    public Aluno(String nome, String email, int tipo_aluno) {
        super(nome, email);
        this.tipo_aluno = tipo_aluno;
    }

    public Aluno() {
    }

    public int getTipo_aluno() {
        return tipo_aluno;
    }

    public void setTipo_aluno(int tipo_aluno) {
        this.tipo_aluno = tipo_aluno;
    }
}
