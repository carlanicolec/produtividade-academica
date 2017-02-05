import base.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int opcao = 555;

        while (opcao != 0) {

            System.out.println(" -- Sistema de Produtividade Acadêmica --\n\n" +
                    "1 - Criar Projeto\n" +
                    "2 - Editar Projeto\n" +
                    "3 - Incluir Publicação\n" +
                    "4 - Editar Publicação\n" +
                    "5 - Consultas\n" +
                    "6 - Relatórios\n" +
                    "0 - Sair\n");


            Scanner scan = new Scanner(System.in);
            opcao = Integer.parseInt(scan.nextLine());

            //System.out.println("opcao:" + opcao);

            if (opcao == 1) {
                Funcionalidades nova_funcionalidade = new Funcionalidades();
                nova_funcionalidade.addProjeto();

            }
            else if (opcao == 2) {
                System.out.println("Escolha a opção desejada:\n" +
                        "1 - Adicionar aluno\n" +
                        "2 - Adicionar orientador" +
                        "3 - Alterar status");
                int opc = Integer.parseInt(scan.nextLine());

                if (opc == 1){
                    System.out.println("Informe o Id do projeto:\n");
                    int id_projeto = Integer.parseInt(scan.nextLine());
                    Funcionalidades nova_funcionalidade = new Funcionalidades();
                    nova_funcionalidade.addAlunoProjeto(id_projeto);
                }
                else if (opc == 2){
                    System.out.println("Informe o Id do projeto:\n");
                    int id_projeto = Integer.parseInt(scan.nextLine());
                    Funcionalidades nova_funcionalidade = new Funcionalidades();
                    nova_funcionalidade.addOrientadorProjeto(id_projeto);
                }
                else if (opc  == 3){
                    System.out.println("Informe o Id do projeto:\n");
                    int id_projeto = Integer.parseInt(scan.nextLine());
                    Funcionalidades nova_funcionalidade = new Funcionalidades();
                    nova_funcionalidade.alterarStatusProjeto(id_projeto);
                }

            }


        }
    }
}

