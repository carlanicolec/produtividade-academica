package base;

import java.util.ArrayList;

public class Dados {
    public ArrayList<Projeto> todos_projetos = new ArrayList<Projeto>();
    public ArrayList<Publicacoes> todas_publicacoes = new ArrayList<Publicacoes>();
    public ArrayList<Usuario> todos_usuarios = new ArrayList<Usuario>();


    public void addProjeto(Projeto novo_projeto){
        this.todos_projetos.add(novo_projeto);
    }

    public void addPublicacao(Publicacoes nova_publicacao){
        this.todas_publicacoes.add(nova_publicacao);
    }

    public void addUsuario(Usuario novo_usuario){
        this.todos_usuarios.add(novo_usuario);
    }


    //usuarios
    public void printUsuarios(){
        for(int i = 0; i < todos_usuarios.size(); i++){
           System.out.println(todos_usuarios.get(i).getNome());
        }
    }

    public void printEmailUsuario(){
        for(int i = 0; i < todos_usuarios.size(); i++){
            System.out.println(todos_usuarios.get(i).getEmail());
        }

    }

    public void printProjetosUsuario(){
        for(int i = 0; i < todos_usuarios.size(); i++){
            System.out.println(todos_usuarios.get(i).getProjetos());
        }
    }

    public void printPublicacoesUsuario(){
        for(int i = 0; i < todos_usuarios.size(); i++){
        }
    }

    //publicacao
    public void printParticipantesPublicacao(){
        for (int i = 0; i < todas_publicacoes.size(); i++){
            System.out.println(todas_publicacoes.get(i).getParticipante_publicacao().get(i).getNome());
        }
    }

    //projeto


    public void printAlunosProjeto(int id){
        for (int i = 0; i < todos_projetos.size(); i++){
            if (todos_projetos.get(i).getId_projeto() == id){
                todos_projetos.get(i).printAlunos();
            }
        }
    }

    public void printOrientadoresProjeto(int id) {
        for (int i = 0; i < todos_projetos.size(); i++) {
            if (todos_projetos.get(i).getId_projeto() == id) {
                todos_projetos.get(i).printOrientadores();
            }
        }
    }

    public void printPublicacoesProjeto(int id){

    }

    public void printPublicacoesProjeto(){
        for (int i = 0; i < todos_projetos.size(); i++){
            System.out.println(todos_projetos.get(i).getPublicacoes_projeto().get(i).getTitulo());
        }
    }

    public void printTituloProjeto(){
        for (int i = 0; i < todos_projetos.size(); i++){
            System.out.println(todos_projetos.get(i).getTitulo());
        }
    }

}
