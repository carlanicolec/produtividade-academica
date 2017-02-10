package base;

import java.util.ArrayList;

public class Projeto {

    private int id_projeto;
    private String titulo;
    private String data_inicio;
    private String data_termino;
    private String agencia_financiadora;
    private double valor_financiado;
    private String objetivo;
    private String descricao;
    private int status; // 1 - Em elaboração; 2 - Em andamento; 3 - Concluido;
    private ArrayList<Usuario> alunos_participantes = new ArrayList<Usuario>();

    private ArrayList<Orientador> orientadores = new ArrayList<Orientador>(); // tem q ter pelo menos 1
    private ArrayList<Publicacoes> publicacoes_projeto = new ArrayList<Publicacoes>();

    //construtor com aluno, orientador e publicação
    public Projeto(int id_projeto, String titulo, String data_inicio, String data_termino, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, int status, Aluno alunos_participantes, Professor orientadores, Publicacoes publicacoes_projeto) {
        this.id_projeto = id_projeto;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.agencia_financiadora = agencia_financiadora;
        this.valor_financiado = valor_financiado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.status = status;
        this.alunos_participantes.add(alunos_participantes);
        this.orientadores.add(orientadores);
        this.publicacoes_projeto.add(publicacoes_projeto);
    }

    public Projeto(int id_projeto, String titulo, String data_inicio, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, int status) {
        this.id_projeto = id_projeto;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.agencia_financiadora = agencia_financiadora;
        this.valor_financiado = valor_financiado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.status = status;
    }

    public Projeto() {
    }

    public void addAluno(Aluno aluno){
        this.alunos_participantes.add(aluno);
    }

    public void addOrientador(Orientador orientador){
        this.orientadores.add(orientador);
    }


    public void addPublicacao (Publicacoes publicacao){
        this.publicacoes_projeto.add(publicacao);
    }

    public void alterarStatus(int opcao){
        if (opcao == 2){
            this.status = 2;
        }
        else if (opcao == 3){
            this.status = 3;
        }
    }

    public void printAlunos(){
       for (int i = 0; i<alunos_participantes.size(); i++){
           alunos_participantes.get(i).printName();
       }
    }

    public void printOrientadores(){
        for(int i =0; i<orientadores.size();i++){
            orientadores.get(i).printName();
        }
    }

    public void printPublicacoes(){
        for (int i = 0; i<publicacoes_projeto.size(); i++){
            publicacoes_projeto.get(i).printName();
        }
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    public String getAgencia_financiadora() {
        return agencia_financiadora;
    }

    public void setAgencia_financiadora(String agencia_financiadora) {
        this.agencia_financiadora = agencia_financiadora;
    }

    public double getValor_financiado() {
        return valor_financiado;
    }

    public void setValor_financiado(double valor_financiado) {
        this.valor_financiado = valor_financiado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Orientador> getOrientadores() {
        return orientadores;
    }
    public ArrayList<Usuario> getAlunos_participantes() {
        return alunos_participantes;
    }

    public void setAlunos_participantes(ArrayList<Usuario> alunos_participantes) {
        this.alunos_participantes = alunos_participantes;
    }

    public void setOrientadores(ArrayList<Orientador> orientadores) {
        this.orientadores = orientadores;
    }

    public ArrayList<Publicacoes> getPublicacoes_projeto() {
        return publicacoes_projeto;
    }

    public void setPublicacoes_projeto(ArrayList<Publicacoes> publicacoes_projeto) {
        this.publicacoes_projeto = publicacoes_projeto;
    }
}





