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
    private String status; // 1 - Em elaboração; 2 - Em andamento; 3 - Concluido;
    private ArrayList<Usuario> participantes_projeto = new ArrayList<Usuario>();
    private ArrayList<Professor> orientadores = new ArrayList<Professor>();

}





