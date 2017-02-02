import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    private ArrayList<Projeto> projetos_passados = new ArrayList<Projeto>();
    private ArrayList<Projeto> projeto_andamento = new ArrayList<Projeto>();
}
