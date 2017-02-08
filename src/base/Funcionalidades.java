package base;

import java.util.Scanner;

public class Funcionalidades {
    Scanner scan = new Scanner(System.in);
    Projeto novo_projeto = new Projeto();

    public void addProjeto(Dados dados){

        System.out.println("Insira o Id do projeto:");
        int id = Integer.parseInt(scan.nextLine());

        System.out.println("Insira a data de início do projeto:");
        String data_inicio = scan.nextLine();
        System.out.println("Insira a data de término do projeto:");
        String data_termino = scan.nextLine();
        System.out.println("Insira o título do projeto:");
        String titulo = scan.nextLine();
        System.out.println("Insira o nome da agência financiadora do projeto:");
        String agencia = scan.nextLine();
        System.out.println("Insira o valor financiado:");
        double valor = Double.parseDouble(scan.nextLine());
        System.out.println("Insira o objetivo do projeto:");
        String objetivo = scan.nextLine();
        System.out.println("Insira a descrição do projeto:");
        String descricao = scan.nextLine();

        Projeto novo_projeto = new Projeto(id, titulo, data_inicio, data_termino, agencia, valor, objetivo, descricao, 1);

        dados.addProjeto(novo_projeto);

        dados.printTituloProjeto();

        System.out.println("Nome do orientador:\n");
        String nome_orientador = scan.nextLine();
        System.out.println("Email do orientador:\n");
        String email_orientador = scan.nextLine();
        System.out.println("Tipo orientador:\n" +
                "1 - Professor\n" +
                "2 - Pesquisador\n");
        int tipo_orientador = Integer.parseInt(scan.nextLine());

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

    public void addAlunoProjeto(int id_projeto, Dados dados) {

        for (int i = 0; i < dados.todos_projetos.size(); i++) {

            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto && dados.todos_projetos.get(i).getStatus() == 1) {
                System.out.println("Nome do aluno:\n");
                String nome_aluno = scan.nextLine();
                System.out.println("Email do aluno:\n");
                String email_aluno = scan.nextLine();
                System.out.println("Insira a opção desejada:\n" +
                        "1 - Aluno de graduação\n" +
                        "2 - Aluno de mestrado\n" +
                        "3 - Aluno de doutorado\n");

                int tipo_aluno = Integer.parseInt(scan.nextLine());

                Aluno novo_aluno = new Aluno(nome_aluno, email_aluno, tipo_aluno);

                dados.todos_projetos.get(i).addAluno(novo_aluno);
                novo_aluno.addNovoProjeto(dados.todos_projetos.get(i));
                dados.todos_usuarios.add(novo_aluno);
            }else{
                System.out.println("Não foi possível adcionar o aluno a esse projeto\n");
            }
        }
    }

    public void addOrientadorProjeto(int id_projeto, Dados dados, Orientador orientador) {

        for (int i = 0; i < dados.todos_projetos.size(); i++) {

            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto) {
                Projeto temp = dados.todos_projetos.get(i);
                System.out.println("Nome do Orientador:\n");
                String nome_orientador = scan.nextLine();
                System.out.println("Email do Orientador:\n");
                String email_orientador = scan.nextLine();
                temp.addOrientador(orientador);
                orientador.addNovoProjeto(dados.todos_projetos.get(i));

            } else {
                System.out.println("Projeto inexistente\n");
            }
        }
        dados.printOrientadoresProjeto();
    }

    public void alterarStatusProjeto(int id_projeto, Dados dados) {
        for (int i = 0; i < dados.todos_projetos.size(); i++) {
            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto) {
                int status = dados.todos_projetos.get(i).getStatus();
                System.out.println("Status atual:" + status);
                if (status == 1) {
                    dados.todos_projetos.get(i).alterarStatus(2);
                    System.out.println("Status alterado para 'Em andamento'");
                } else if (status == 2) {
                    dados.todos_projetos.get(i).alterarStatus(3);
                    System.out.println("Status alterado para 'Concluído'");
                }
            }
        }
    }

    public void addPublicacao(Dados dados){
        Usuario autor = new Usuario();
        System.out.println("Informe o título:\n");
        String titulo = scan.nextLine();
        System.out.println("Informe a conferência onde foi publicada:\n");
        String conferencia = scan.nextLine();
        System.out.println("Informe o ano da publicação:\n");
        int ano_publicacao = Integer.parseInt(scan.nextLine());
        System.out.println("Informe nome do autor:\n");
        autor.setNome(scan.nextLine());
        System.out.println("Informe o email do autor:\n");
        autor.setEmail(scan.nextLine());
        Publicacoes nova_publicacao = new Publicacoes(titulo,conferencia, ano_publicacao, autor);
        System.out.println("Deseja atrelar a Publicação a um projeto existente?\n 1 - Sim\n 2 - Não\n");
        int opc = Integer.parseInt(scan.nextLine());
        if (opc ==1){
            System.out.println("Informe o id do projeto\n");
            int id = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getId_projeto() == id && dados.todos_projetos.get(i).getStatus() == 1) {
                    dados.todos_projetos.get(i).addPublicacao(nova_publicacao);
                    System.out.println("Publicação adcionada com sucesso\n");
                } else {
                    System.out.println("Não foi possível adcionar a esse projeto\n");
                }
            }
        }
        autor.addPublicacao(nova_publicacao);
        dados.todas_publicacoes.add(nova_publicacao);
        dados.todos_usuarios.add(autor);
    }




}