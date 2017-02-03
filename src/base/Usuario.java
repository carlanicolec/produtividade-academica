package base;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();

    public Usuario(String nome, String email, Publicacoes publicacoes, Projeto projetos) {
        this.nome = nome;
        this.email = email;
        this.publicacoes.add(publicacoes);
        this.projetos.add(projetos);
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void addPublicacao(Publicacoes publicacao){
        this.publicacoes.add(publicacao);
    }

    public void addNovoProjeto(Projeto novo_projeto){
        this.projetos.add(novo_projeto);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Publicacoes> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(ArrayList<Publicacoes> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public ArrayList<Projeto> getProjetos_passados() {
        return projetos;
    }

    public void setProjetos_passados(ArrayList<Projeto> projetos_passados) {
        this.projetos = projetos_passados;
    }

}
