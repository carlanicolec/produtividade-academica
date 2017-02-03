package base;

import java.util.ArrayList;

public class Publicacoes {

    private String titulo;
    private String conferencia;
    private int ano_publicacao;
    private int id_projeto; //ver se é melhor assim
    private String publicacao;
    private ArrayList<Usuario> participante_publicacao = new ArrayList<Usuario>();

    private void addPublicacao(String titulo, String conferencia, int ano, int id, String publicacao, Usuario participante){
        this.titulo = titulo;
        this.conferencia = conferencia;
        this.ano_publicacao = ano;
        this.id_projeto = id;
        this.publicacao = publicacao;
        this.participante_publicacao.add(participante);

    }

    private void addNovoParticipante(Usuario participante){
        this.participante_publicacao.add(participante);
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

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public ArrayList<Usuario> getParticipante_publicacao() {
        return participante_publicacao;
    }

    public void setParticipante_publicacao(ArrayList<Usuario> participante_publicacao) {
        this.participante_publicacao = participante_publicacao;
    }
}