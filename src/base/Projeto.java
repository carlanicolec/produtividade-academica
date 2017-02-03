package base;

import java.util.ArrayList;
import java.util.Date;

public class Projeto {

    private int id_projeto;
    private String titulo;
    private Date data_inicio;
    private Date data_termino;
    private String agencia_financiadora;
    private double valor_financiado;
    private String objetivo;
    private String descricao;
    private int status; // 1 - Em elaboração; 2 - Em andamento; 3 - Concluido;
    private ArrayList<Usuario> alunos_participantes = new ArrayList<Usuario>();
    private ArrayList<Professor> orientadores = new ArrayList<Professor>(); // tem q ter pelo menos 1
    private ArrayList<Publicacoes> publicacoes_projeto = new ArrayList<Publicacoes>();

    //construtor com aluno, orientador e publicação
    public Projeto(int id_projeto, String titulo, Date data_inicio, Date data_termino, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, int status, Aluno alunos_participantes, Professor orientadores, Publicacoes publicacoes_projeto) {
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

    public Projeto(int id_projeto, String titulo, Date data_inicio, Date data_termino, String agencia_financiadora, double valor_financiado, String objetivo, String descricao, int status) {
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

    public void addOrientador(Professor prof){
        this.orientadores.add(prof);
    }

    public void addPublicacao (Publicacoes publicacao){
        this.publicacoes_projeto.add(publicacao);
    }

    public void alterarStatus(int opcao){
        if (opcao == 1){
            this.status = 1;
        }
        else if (opcao == 2){
            this.status = 2;
        }
        else if (opcao == 3){
            this.status = 3;
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

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public void setData_termino(Date data_termino) {
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

    public ArrayList<Usuario> getAlunos_participantes() {
        return alunos_participantes;
    }

    public void setAlunos_participantes(ArrayList<Usuario> alunos_participantes) {
        this.alunos_participantes = alunos_participantes;
    }

    public ArrayList<Professor> getOrientadores() {
        return orientadores;
    }

    public void setOrientadores(ArrayList<Professor> orientadores) {
        this.orientadores = orientadores;
    }

    public ArrayList<Publicacoes> getPublicacoes_projeto() {
        return publicacoes_projeto;
    }

    public void setPublicacoes_projeto(ArrayList<Publicacoes> publicacoes_projeto) {
        this.publicacoes_projeto = publicacoes_projeto;
    }
}





