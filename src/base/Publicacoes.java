package base;

import java.util.ArrayList;

public class Publicacoes {

    private String titulo;
    private String conferencia;
    private int ano_publicacao;
    private int id_projeto; //ver se é melhor assim
    private ArrayList<Usuario> participante_publicacao = new ArrayList<Usuario>();

    public Publicacoes(String titulo, String conferencia, int ano_publicacao, Usuario participante_publicacao) {
        this.titulo = titulo;
        this.conferencia = conferencia;
        this.ano_publicacao = ano_publicacao;
        this.participante_publicacao.add(participante_publicacao);
    }

    public Publicacoes() {
    }


    private void addNovoParticipante(Usuario participante){
        this.participante_publicacao.add(participante);
    }

    public void printName(){
        System.out.println(this.getTitulo());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }


    public ArrayList<Usuario> getParticipante_publicacao() {
        return participante_publicacao;
    }

    public void setParticipante_publicacao(Usuario autor) {
        this.participante_publicacao.add(autor);
    }
}