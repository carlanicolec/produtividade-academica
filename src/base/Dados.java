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

    public void printUsuarios(){
            }
}
