package base;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private int cpf;

    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();

    public Usuario(String nome, String email, Publicacoes publicacoes, Projeto projetos, int cpf){
        this.nome = nome;
        this.email = email;
        this.publicacoes.add(publicacoes);
        this.projetos.add(projetos);
        this.cpf = cpf;
    }

    public Usuario(String nome, String email, int cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Usuario() {
    }

    public void addPublicacao(Publicacoes publicacao){
        this.publicacoes.add(publicacao);
    }

    public void addNovoProjeto(Projeto novo_projeto){
        this.projetos.add(novo_projeto);
    }

    public void printName(){
        System.out.println(this.getNome());
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }


    public ArrayList<Publicacoes> getPublicacoes() {
        return publicacoes;
    }
    public void setPublicacoes(Publicacoes publicacao) {
        this.publicacoes.add(publicacao);
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }
}
