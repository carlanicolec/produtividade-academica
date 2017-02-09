import base.Dados;
import base.Funcionalidades;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = 555;
        Dados dados = new Dados();
        Scanner scan = new Scanner(System.in);
        Funcionalidades nova_funcionalidade = new Funcionalidades();


        while (opcao != 0) {
            System.out.println(" -- Sistema de Produtividade Acadêmica --\n\n" +
                    "1 - Criar Projeto\n" +
                    "2 - Editar Projeto\n" +
                    "3 - Incluir Publicação\n" +
                    "4 - Consultas\n" +
                    "5 - Relatórios\n" +
                    "0 - Sair\n");

           opcao = Integer.parseInt(scan.nextLine());

           if (opcao == 1) {
               nova_funcionalidade.addProjeto(dados);
           }else if (opcao == 2) {
              nova_funcionalidade.editarProjeto(dados);
           }else if (opcao == 3) {
               nova_funcionalidade.addPublicacao(dados);

           }else if (opcao == 4){

           }
           else if (opcao == 5) {
               nova_funcionalidade.relatorios(dados);
           }
        }
    }
}
