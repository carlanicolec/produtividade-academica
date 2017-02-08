import base.Dados;
import base.Funcionalidades;
import base.Pesquisador;
import base.Professor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = 555;
        Dados dados = new Dados();
        Scanner scan = new Scanner(System.in);
        Funcionalidades nova_funcionalidade = new Funcionalidades();
        Professor novo_prof = new Professor();
        Pesquisador novo_pesq = new Pesquisador();


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
           }
            else if (opcao == 2) {
               System.out.println("Escolha a opção desejada:\n" +
                       "1 - Adicionar aluno\n" +
                       "2 - Adicionar orientador\n" +
                       "3 - Alterar status");
               int opc = Integer.parseInt(scan.nextLine());
               if (opc == 1) {
                   System.out.println("Informe o Id do projeto:\n");
                   int id_projeto = Integer.parseInt(scan.nextLine());
                   nova_funcionalidade.addAlunoProjeto(id_projeto, dados);
               } else if (opc == 2) {
                   System.out.println("Informe o Id do projeto:\n");
                   int id_projeto = Integer.parseInt(scan.nextLine());
                   System.out.println("Informe o tipo do orientador:\n 1 - Professor\n 2 - Pesquisador\n");
                   int tipo_orientador = Integer.parseInt(scan.nextLine());
                   if (tipo_orientador == 1) {
                       nova_funcionalidade.addOrientadorProjeto(id_projeto, dados, novo_prof);
                   } else if (tipo_orientador == 2) {
                       nova_funcionalidade.addOrientadorProjeto(id_projeto, dados, novo_pesq);
                   }
               } else if (opc == 3) {
                   System.out.println("Informe o Id do projeto:\n");
                   int id_projeto = Integer.parseInt(scan.nextLine());
                   nova_funcionalidade.alterarStatusProjeto(id_projeto, dados);
               }
           }
           else if (opcao == 3) {
               nova_funcionalidade.addPublicacao(dados);

           }else if (opcao == 5) {
               System.out.println("Escolha o tipo de relatório desejado:\n" +
                       "1 - Número de colaboradores\n" +
                       "2 - Número de projetos em elaboração\n" +
                       "3 - Número de projetos em andamento\n" +
                       "4 - Número de projetos concluidos\n" +
                       "5 - Número total de projetos\n" +
                       "6 - Número de produção acadêmica por tipo de produção\n");

               int escolha = Integer.parseInt(scan.nextLine());
               if (escolha == 1) {
                   System.out.println("Número de colaboradores" + dados.todos_usuarios.size());
               } else if (escolha == 2) {
                   int count = 0;
                   for (int i = 0; i < dados.todos_projetos.size(); i++) {
                       if (dados.todos_projetos.get(i).getStatus() == 1) {
                           count++;
                       }
                   }
                   System.out.println("Número de projetos em elaboração" + count);

               } else if (escolha == 3) {
                   int count = 0;
                   for (int i = 0; i < dados.todos_projetos.size(); i++) {
                       if (dados.todos_projetos.get(i).getStatus() == 2) {
                           count++;
                       }
                   }
                   System.out.println("Número de projetos em andamento" + count);

               } else if (escolha == 4) {
                   int count = 0;
                   for (int i = 0; i < dados.todos_projetos.size(); i++) {
                       if (dados.todos_projetos.get(i).getStatus() == 3) {
                           count++;
                       }
                   }
                   System.out.println("Número de projetos concluídos" + count);

               } else if (escolha == 5) {
                   System.out.println("Número total de projetos" + dados.todos_projetos.size());
               } else if (escolha == 6) {
                   System.out.println("Escolha o tipo de produção desejada:\n 1 - Publicações\n 2 - Orientações\n");
                   int choice = Integer.parseInt(scan.nextLine());
                   if (choice == 1) { //publicacoes
                       System.out.println("Número total de publicações" + dados.todas_publicacoes.size());
                   } else if (choice == 2) {

                   }
               }
           }
        }
    }
}
