package base;

import java.util.Scanner;

public class Funcionalidades {
    Scanner scan = new Scanner(System.in);
    Projeto novo_projeto = new Projeto();
    Professor novo_prof = new Professor();
    Pesquisador novo_pesq = new Pesquisador();

    public void addProjeto(Dados dados){

        System.out.println("Insira o Id do projeto:");
        int id = Integer.parseInt(scan.nextLine());

        System.out.println("Insira a data de início do projeto:");
        String data_inicio = scan.nextLine();
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

        Projeto novo_projeto = new Projeto(id, titulo, data_inicio, agencia, valor, objetivo, descricao, 1);

        dados.addProjeto(novo_projeto);

        System.out.println("Nome do orientador:\n");
        String nome_orientador = scan.nextLine();
        System.out.println("Email do orientador:\n");
        String email_orientador = scan.nextLine();
        System.out.println("CPF do orientador");
        int cpf = Integer.parseInt(scan.nextLine());
        System.out.println("Tipo orientador:\n" +
                "1 - Professor\n" +
                "2 - Pesquisador");
        int tipo_orientador = Integer.parseInt(scan.nextLine());

        if (tipo_orientador == 1) {
            Professor novo_prof = new Professor(nome_orientador, email_orientador,cpf);
            novo_projeto.addOrientador(novo_prof);
            novo_prof.addNovoProjeto(novo_projeto);
            dados.todos_usuarios.add(novo_prof);
        } else if (tipo_orientador == 2) {
            Pesquisador novo_pesq = new Pesquisador(nome_orientador, email_orientador,cpf);
            novo_projeto.addOrientador(novo_pesq);
            novo_pesq.addNovoProjeto(novo_projeto);
            dados.todos_usuarios.add(novo_pesq);
        }
    }

    public void addAlunoProjeto(int id_projeto, Dados dados) {
        for (int i = 0; i < dados.todos_projetos.size(); i++) {
            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto && dados.todos_projetos.get(i).getStatus() == 1) {
                System.out.println("Nome do aluno:");
                String nome_aluno = scan.nextLine();
                System.out.println("Email do aluno:");
                String email_aluno = scan.nextLine();
                System.out.println("CPF do aluno:");
                int cpf = Integer.parseInt(scan.nextLine());
                System.out.println("Insira a opção desejada:\n" +
                        "1 - Aluno de graduação\n" +
                        "2 - Aluno de mestrado\n" +
                        "3 - Aluno de doutorado\n");

                int tipo_aluno = Integer.parseInt(scan.nextLine());

                Aluno novo_aluno = new Aluno(nome_aluno, email_aluno, tipo_aluno, cpf);

                dados.todos_projetos.get(i).addAluno(novo_aluno);
                novo_aluno.addNovoProjeto(dados.todos_projetos.get(i));
                dados.todos_usuarios.add(novo_aluno);
            }
        }
    }

    public void editarProjeto(Dados dados){
        System.out.println("Escolha a opção desejada:\n" +
                "1 - Adicionar aluno\n" +
                "2 - Adicionar orientador\n" +
                "3 - Alterar status");
        int opc = Integer.parseInt(scan.nextLine());
        if (opc == 1) {
            System.out.println("Informe o Id do projeto:\n");
            int id_projeto = Integer.parseInt(scan.nextLine());
            addAlunoProjeto(id_projeto, dados);
        } else if (opc == 2) {
            System.out.println("Informe o Id do projeto:\n");
            int id_projeto = Integer.parseInt(scan.nextLine());
            System.out.println("Informe o tipo do orientador:\n 1 - Professor\n 2 - Pesquisador\n");
            int tipo_orientador = Integer.parseInt(scan.nextLine());
            if (tipo_orientador == 1) {
                addOrientadorProjeto(id_projeto, dados, novo_prof);
            } else if (tipo_orientador == 2) {
                addOrientadorProjeto(id_projeto, dados, novo_pesq);
            }
        } else if (opc == 3) {
            System.out.println("Informe o Id do projeto:\n");
            int id_projeto = Integer.parseInt(scan.nextLine());
            alterarStatusProjeto(id_projeto, dados);
        }
    }

    public void addOrientadorProjeto(int id_projeto, Dados dados, Orientador orientador) {
        for (int i = 0; i < dados.todos_projetos.size(); i++) {

            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto && dados.todos_projetos.get(i).getStatus() == 1) {
                Projeto temp = dados.todos_projetos.get(i);
                System.out.println("Nome do Orientador:\n");
                String nome_orientador = scan.nextLine();
                System.out.println("Email do Orientador:\n");
                String email_orientador = scan.nextLine();
                System.out.println("CPF do Orientador:");
                int cpf = Integer.parseInt(scan.nextLine());
                orientador.setNome(nome_orientador);
                orientador.setEmail(email_orientador);
                orientador.setCpf(cpf);
                temp.addOrientador(orientador);
                orientador.addNovoProjeto(dados.todos_projetos.get(i));
                dados.todos_usuarios.add(orientador);
            }else if (dados.todos_projetos.get(i).getStatus() != 1){
                System.out.println("Projeto não está na fase de elaboração, logo não podem ser feitas alterações\n");
            }
        }
       // dados.printOrientadoresProjeto(1);
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
                    if (dados.todos_projetos.get(i).getPublicacoes_projeto() != null) {
                        System.out.println("Insira a data de hoje: ");
                        String data_termino = scan.nextLine();
                        dados.todos_projetos.get(i).setData_termino(data_termino);
                        dados.todos_projetos.get(i).alterarStatus(3);
                        System.out.println("Status alterado para 'Concluído'");
                    }else {
                        System.out.println("Um projeto só pode ser concluído se houver pelo menos uma publicação associada a ele\n");
                    }
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
        System.out.println("O autor já é cadastrado no sistema?\n 1 - Sim\n 2 - Não\n");
        int opcao = Integer.parseInt(scan.nextLine());
        if (opcao == 1){
            System.out.println("Informe o CPF do autor:\n");
            int cpf = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < dados.todos_usuarios.size(); i++){
                if (dados.todos_usuarios.get(i).getCpf() == cpf){
                    autor = dados.todos_usuarios.get(i);
                    System.out.println("Autor adicionado com sucesso\n");
                }
            }
        }else {
            System.out.println("Informe nome do autor:\n");
            autor.setNome(scan.nextLine());
            System.out.println("Informe o email do autor:\n");
            autor.setEmail(scan.nextLine());
            System.out.println("Informe o CPF do autor:\n");
            int cpf = Integer.parseInt(scan.nextLine());
            autor.setCpf(cpf);
        }
        Publicacoes nova_publicacao = new Publicacoes(titulo,conferencia, ano_publicacao, autor);
        System.out.println("Deseja atrelar a Publicação a um projeto existente?\n 1 - Sim\n 2 - Não\n");
        int opc = Integer.parseInt(scan.nextLine());
        if (opc ==1) {
            System.out.println("Informe o id do projeto\n");
            int id = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getId_projeto() == id && dados.todos_projetos.get(i).getStatus() == 1) {
                    dados.todos_projetos.get(i).addPublicacao(nova_publicacao);
                    System.out.println("Publicação adcionada com sucesso\n");
                }
            }

        }

        autor.addPublicacao(nova_publicacao);
        dados.todas_publicacoes.add(nova_publicacao);
        dados.todos_usuarios.add(autor);
    }

    public void relatorios(Dados dados){
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

    public void consultas(Dados dados){
        System.out.println("Escolha a opção de consulta desejada:\n"+
                            "1 - Consulta por colaborador\n"+
                            "2 - Consulta por projeto");
        int opcao = Integer.parseInt(scan.nextLine());
        if (opcao == 1){
            System.out.println("Insira o CPF do colaboraborador:");
            int cpf = Integer.parseInt(scan.nextLine());
            for (int i = 0; i<dados.todos_usuarios.size(); i++){
                if (dados.todos_usuarios.get(i).getCpf() == cpf){
                    Usuario colaborador = dados.todos_usuarios.get(i);
                    System.out.println("Nome do colaborador: " + colaborador.getNome());
                    System.out.println("Email do colaborador: " + colaborador.getEmail());
                    System.out.println("Projetos:\n");
                    for (int j = 0; j<colaborador.getProjetos().size(); j++){
                        System.out.println("Projeto " + j+1 +
                                            "Título do projeto " + colaborador.getProjetos().get(j).getTitulo()+
                                            "Data de término "+ colaborador.getProjetos().get(j).getData_termino());
                    }
                    System.out.println("Publicações\n");
                    for (int b = 0; b<colaborador.getPublicacoes().size(); b++){
                        System.out.println("Publicação " + b+1 +
                                            "Título da publicação " + colaborador.getPublicacoes().get(b).getTitulo()+
                                            "Ano da publicação " + colaborador.getPublicacoes().get(b).getAno_publicacao());
                    }
                }
            }
        }
        else if (opcao == 2){
            System.out.println("Insira o ID do projeto:");
            int id = Integer.parseInt(scan.nextLine());
            for (int i = 0; i<dados.todos_projetos.size(); i++){
                if (dados.todos_projetos.get(i).getId_projeto() == id){
                    Projeto projeto = dados.todos_projetos.get(i);
                    System.out.println("ID:  " + projeto.getId_projeto()+
                                        "Título: " + projeto.getTitulo() +
                                        "Data de início: " + projeto.getData_inicio()+
                                        "Data de término: " + projeto.getData_termino()+
                                        "Agencia financiadora: " + projeto.getAgencia_financiadora()+
                                        "Valor financiado: " + projeto.getValor_financiado()+
                                        "Objetivo: " + projeto.getObjetivo()+
                                        "Descrição: "+ projeto.getDescricao()+
                                        "Status: " + projeto.getStatus());

                    System.out.println("Alunos:\n");
                    for (int j = 0; j<projeto.getAlunos_participantes().size(); j++){
                        System.out.println("Aluno " + j+1);
                        System.out.println("Nome: " + projeto.getAlunos_participantes().get(j).getNome()+
                                           "Email " + projeto.getAlunos_participantes().get(j).getEmail()+
                                            "CPF " + projeto.getAlunos_participantes().get(j).getCpf());

                    }
                    System.out.println("Orientadores:\n");
                    for (int b = 0; b<projeto.getOrientadores().size(); b++){
                        System.out.println("Orientador " + b+1);
                        System.out.println("Nome: "+ projeto.getOrientadores().get(b).getNome() +
                                            "Email "+ projeto.getOrientadores().get(b).getEmail()+
                                            "CPF " + projeto.getOrientadores().get(b).getCpf());
                    }
                    System.out.println("Publicações\n");
                    for (int n = 0; n<projeto.getPublicacoes_projeto().size(); n++){
                        System.out.println("Publicação "+ n+1);
                        System.out.println("Título "+ projeto.getPublicacoes_projeto().get(n).getTitulo()+
                                            "Conferência "+ projeto.getPublicacoes_projeto().get(n).getConferencia()+
                                            "Ano de Publicação"+ projeto.getPublicacoes_projeto().get(n).getAno_publicacao());
                    }

                }
            }
        }


    }

}