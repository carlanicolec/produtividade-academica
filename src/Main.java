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
            opcao = scan.nextInt();

            //System.out.println("opcao:" + opcao);

            if (opcao == 1) {

                System.out.println("Insira o Id do projeto:");
                int id = scan.nextInt();
                System.out.println("Insira a data de início do projeto:");
                String data_inicio = scan.nextLine();
                System.out.println("Insira a data de término do projeto:");
                String data_termino = scan.nextLine();
                System.out.println("Insira o título do projeto:");
                String titulo = scan.nextLine();
                System.out.println("Insira o nome da agência financiadora do projeto:");
                String agencia = scan.nextLine();
                System.out.println("Insira o valor financiado:");
                double valor = scan.nextDouble();
                System.out.println("Insira o objetivo do projeto:");
                String objetivo = scan.nextLine();
                System.out.println("Insira a descrição do projeto:");
                String descricao = scan.nextLine();
                System.out.println("Insira o status do projeto: " +
                        "1 - Em elaboração\n" +
                        "2 - Em andamento\n" +
                        "3 - Concluído\n");
                int status = scan.nextInt();

                Dados dados = new Dados();

                Projeto novo_projeto = new Projeto(id, titulo, data_inicio, data_termino, agencia, valor, objetivo, descricao, status);


                System.out.println("Deseja add um aluno ao projeto?\n 1 - Sim \n 2 - Não\n");
                int escolha_aluno = scan.nextInt();
                if (escolha_aluno == 1) {
                    System.out.println("Nome do aluno:\n");
                    String nome_aluno = scan.nextLine();
                    System.out.println("Email do aluno:\n");
                    String email_aluno = scan.nextLine();
                    System.out.println("Insira a opção desejada:\n" +
                            "1 - Aluno de graduação\n" +
                            "2 - Aluno de mestrado\n" +
                            "3 - Aluno de doutorado\n");
                    int tipo_aluno = scan.nextInt();


                    Aluno novo_aluno = new Aluno(nome_aluno, email_aluno, tipo_aluno);
                    novo_projeto.addAluno(novo_aluno);
                    novo_aluno.addNovoProjeto(novo_projeto);

                    dados.todos_projetos.add(novo_projeto);
                    dados.todos_usuarios.add(novo_aluno);
                }

                // add orientador
                System.out.println("Deseja add um orientador ao projeto?\n 1 - Sim \n 2 - Não\n");
                int escolha_orientador = scan.nextInt();
                if (escolha_orientador == 1) {
                    System.out.println("Nome do orientador:\n");
                    String nome_orientador = scan.nextLine();
                    System.out.println("Email do orientador:\n");
                    String email_orientador = scan.nextLine();
                    System.out.println("Tipo orientador:\n" +
                            "1 - Professor\n" +
                            "2 - Pesquisador\n");
                    int tipo_orientador = scan.nextInt();
                    if (tipo_orientador == 1) {
                        Professor novo_prof = new Professor(nome_orientador, email_orientador);
                        novo_projeto.addOrientador(novo_prof);
                        novo_prof.addNovoProjeto(novo_projeto);
                        dados.todos_usuarios.add(novo_prof);
                    } else if (tipo_orientador == 2) {
                        Pesquisador novo_pesq = new Pesquisador(nome_orientador, email_orientador);
                        novo_projeto.addOrientador(novo_pesq);
                        novo_pesq.addNovoProjeto(novo_projeto);
                        dados.todos_usuarios.add(novo_pesq);
                    }
                }
            /*    System.out.println(novo_projeto.getAgencia_financiadora());
                System.out.println(novo_projeto.getAlunos_participantes());
                System.out.println(novo_projeto.getData_inicio());
                System.out.println(novo_projeto.getData_termino());
                System.out.println(novo_projeto.getDescricao());
                System.out.println(novo_projeto.getId_projeto());
                System.out.println(novo_projeto.getObjetivo());
                System.out.println(novo_projeto.getOrientadores());
                System.out.println(novo_projeto.getStatus());
                System.out.println(novo_projeto.getTitulo());
                System.out.println(novo_projeto.getValor_financiado());
*/


            System.out.println(dados.todos_usuarios.);
            }


            else if (opcao == 2){


            }






        }
    }
}
