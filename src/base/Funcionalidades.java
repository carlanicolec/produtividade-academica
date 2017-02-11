package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Funcionalidades extends Exception{
    Scanner scan = new Scanner(System.in);
    Projeto novo_projeto = new Projeto();
    Professor novo_prof = new Professor();
    Pesquisador novo_pesq = new Pesquisador();
    boolean done;
    public void addProjeto(Dados dados) {
        int id = 0;
        done = false;
        do {
            try {
                System.out.println("Insira o Id do projeto:");
                id = Integer.parseInt(scan.nextLine());
                for (int i =0; i<dados.todos_projetos.size();i++){
                    if (dados.todos_projetos.get(i).getId_projeto() == id) throw new ExistingID();
                }
                done = true;
            }catch (ExistingID e){
                System.out.println(e);
                System.out.println("o ID informado já é atrelado a um projeto\n");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);


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
        done = false;
        int cpf = 0;
        do {
            try {
                System.out.println("CPF do orientador");
                cpf = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < dados.todos_usuarios.size(); i++) {
                    if (dados.todos_usuarios.get(i).getCpf() == cpf) throw new ExistingCPF();
                }
                done = true;
            }catch (ExistingCPF e){
                System.out.println(e);
                System.out.println("CPF já atrelado a um usuário\n");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);

        done = false;
        do{
            try {
                System.out.println("Tipo orientador:\n" +
                        "1 - Professor\n" +
                        "2 - Pesquisador");
                int tipo_orientador = Integer.parseInt(scan.nextLine());
                if (tipo_orientador > 1 || tipo_orientador <2) throw new IntegerOutOfRangeException();
                if (tipo_orientador == 1) {
                    Professor novo_prof = new Professor(nome_orientador, email_orientador, cpf);
                    novo_projeto.addOrientador(novo_prof);
                    novo_prof.addNovoProjeto(novo_projeto);
                    dados.todos_usuarios.add(novo_prof);
                } else if (tipo_orientador == 2) {
                    Pesquisador novo_pesq = new Pesquisador(nome_orientador, email_orientador, cpf);
                    novo_projeto.addOrientador(novo_pesq);
                    novo_pesq.addNovoProjeto(novo_projeto);
                    dados.todos_usuarios.add(novo_pesq);
                }
                done = true;
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira o número 1 ou o número 2\n");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);
    }

    public void addAlunoProjeto(int id_projeto, Dados dados) {
        done =false;
        for (int i = 0; i < dados.todos_projetos.size(); i++) {
            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto) {
                if (dados.todos_projetos.get(i).getStatus() == 1) {
                    System.out.println("Nome do aluno:");
                    String nome_aluno = scan.nextLine();
                    System.out.println("Email do aluno:");
                    String email_aluno = scan.nextLine();
                    int cpf = 0;
                    do {
                        try {
                            System.out.println("CPF do aluno:");
                            cpf = Integer.parseInt(scan.nextLine());
                            for (int j = 0; j < dados.todos_usuarios.size(); j++) {
                                if (dados.todos_usuarios.get(j).getCpf() == cpf) throw new ExistingCPF();
                            }
                            done = true;
                        }catch (ExistingCPF e){
                            System.out.println(e);
                            System.out.println("CPF já atrelado a um usuário\n");
                        }catch (NumberFormatException e){
                            System.out.println(e);
                            System.out.println("Insira um número inteiro\n");

                        }
                    }while (!done);
                    done = false;
                    int tipo_aluno = 0;
                    do {
                        try {
                            System.out.println("Insira a opção desejada:\n" +
                                    "1 - Aluno de graduação\n" +
                                    "2 - Aluno de mestrado\n" +
                                    "3 - Aluno de doutorado\n");

                            tipo_aluno = Integer.parseInt(scan.nextLine());
                            if (tipo_aluno < 1 || tipo_aluno > 3) throw new IntegerOutOfRangeException();
                        }catch (IntegerOutOfRangeException e){
                            System.out.println(e);
                            System.out.println("Insira um número de 1 a 3");
                        }catch (NumberFormatException e){
                            System.out.println(e);
                            System.out.println("Insira um número inteiro\n");

                        }
                    }while (!done);
                    Aluno novo_aluno = new Aluno(nome_aluno, email_aluno, tipo_aluno, cpf);

                    dados.todos_projetos.get(i).addAluno(novo_aluno);
                    novo_aluno.addNovoProjeto(dados.todos_projetos.get(i));
                    dados.todos_usuarios.add(novo_aluno);
                }else{
                    System.out.println("Projeto não está na fase de elaboração. Não podem ser feitas alterações\n");
                }
            }
        }
    }

    public void editarProjeto(Dados dados){
        int opc = 0;
        done = false;
        do {
            try {
                System.out.println("Escolha a opção desejada:\n" +
                        "1 - Adicionar aluno\n" +
                        "2 - Adicionar orientador\n" +
                        "3 - Alterar status");

                opc = Integer.parseInt(scan.nextLine());
                if (opc < 1 || opc > 3) throw new IntegerOutOfRangeException();
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira um número de 1 a 3");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);
        done = false;
        int id_projeto = 0;
        do {
            try {
                System.out.println("Informe o Id do projeto:\n");
                id_projeto = Integer.parseInt(scan.nextLine());
                int count = 0;
                for (int i = 0; i<dados.todos_projetos.size(); i++){
                    if (dados.todos_projetos.get(i).getId_projeto()!= id_projeto){
                        count++;
                    }
                    if (count == dados.todos_projetos.size()){//se o count for igual ao size é pq percorreu todo o arraylist e não encontrou o id
                        throw new EmptyID();
                    }
                }
                done = true;
            }catch (EmptyID e){
                System.out.println(e);
                System.out.println("Insira o ID de um projeto existente\n");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");
            }
        }while (!done);
        done = false;
        if (opc == 1) {
            addAlunoProjeto(id_projeto, dados);
        } else if (opc == 2) {
            do {
                try {
                    System.out.println("Informe o tipo do orientador:\n 1 - Professor\n 2 - Pesquisador\n");
                    int tipo_orientador = Integer.parseInt(scan.nextLine());
                    if (tipo_orientador<1 || tipo_orientador >2) throw new IntegerOutOfRangeException();
                    if (tipo_orientador == 1) {
                        addOrientadorProjeto(id_projeto, dados, novo_prof);
                    } else if (tipo_orientador == 2) {
                        addOrientadorProjeto(id_projeto, dados, novo_pesq);
                    }
                }catch (IntegerOutOfRangeException e){
                    System.out.println(e);
                    System.out.println("Insira o número 1 ou o número 2\n");
                }
            }while (!done);
            done = false;
        } else if (opc == 3) {
            alterarStatusProjeto(id_projeto, dados);
        }
    }

    public void addOrientadorProjeto(int id_projeto, Dados dados, Orientador orientador) {
       done = false;
        for (int i = 0; i < dados.todos_projetos.size(); i++) {

            if (dados.todos_projetos.get(i).getId_projeto() == id_projeto) {
                if (dados.todos_projetos.get(i).getStatus() == 1) {
                    Projeto temp = dados.todos_projetos.get(i);
                    System.out.println("Nome do Orientador:\n");
                    String nome_orientador = scan.nextLine();
                    System.out.println("Email do Orientador:\n");
                    String email_orientador = scan.nextLine();
                    int cpf = 0;
                    do {
                        try {
                            System.out.println("CPF do orientador:");
                            cpf = Integer.parseInt(scan.nextLine());
                            for (int j = 0; j < dados.todos_usuarios.size(); j++) {
                                if (dados.todos_usuarios.get(j).getCpf() == cpf) throw new ExistingCPF();
                            }
                            done = true;
                        }catch (ExistingCPF e){
                            System.out.println(e);
                            System.out.println("CPF já atrelado a um usuário\n");
                        }catch (NumberFormatException e){
                            System.out.println(e);
                            System.out.println("Insira um número inteiro\n");

                        }
                    }while (!done);
                    done = false;

                    orientador.setNome(nome_orientador);
                    orientador.setEmail(email_orientador);
                    orientador.setCpf(cpf);
                    temp.addOrientador(orientador);
                    orientador.addNovoProjeto(dados.todos_projetos.get(i));
                    dados.todos_usuarios.add(orientador);
                }else {
                    System.out.println("Projeto não está na fase de elaboração. Não podem ser feitas alterações\n");
                }
            }
        }
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
                    if (dados.todos_projetos.get(i).getPublicacoes_projeto().size() > 0) {//verificar por size
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

        int opcao = 0;
        do {
            try {
                System.out.println("O autor já é cadastrado no sistema?\n 1 - Sim\n 2 - Não\n");
                opcao = Integer.parseInt(scan.nextLine());

                opcao = Integer.parseInt(scan.nextLine());
                if (opcao < 1 || opcao> 2) throw new IntegerOutOfRangeException();
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira um número de 1 a 2");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);
        if (opcao == 1){
            int cpf = 0;
            done = false;
            do {
                try {
                    System.out.println("CPF do autor:");
                    cpf = Integer.parseInt(scan.nextLine());
                    int count = 0;
                    for (int j = 0; j < dados.todos_usuarios.size(); j++) {
                        if (dados.todos_usuarios.get(j).getCpf() != cpf){
                            count++;
                        }
                        if (count ==  dados.todos_usuarios.size()){
                            throw new EmptyCPF();
                        }
                    }
                    done = true;
                }catch (EmptyCPF e){
                    System.out.println(e);
                    System.out.println("CPF não cadastrado. Insira um CPF válido\n");
                }catch (NumberFormatException e){
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");

                }
            }while (!done);
            done = false;

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
            int cpf = 0;
            do {
                try {
                    System.out.println("Insira o CPF do autor:");
                    cpf = Integer.parseInt(scan.nextLine());
                    for (int j = 0; j < dados.todos_usuarios.size(); j++) {
                        if (dados.todos_usuarios.get(j).getCpf() == cpf) throw new ExistingCPF();
                    }
                    done = true;
                }catch (ExistingCPF e){
                    System.out.println(e);
                    System.out.println("CPF já atrelado a um usuário\n");
                }catch (NumberFormatException e){
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");

                }
            }while (!done);
            done = false;
            autor.setCpf(cpf);
            dados.todos_usuarios.add(autor);
        }
        Publicacoes nova_publicacao = new Publicacoes(titulo,conferencia, ano_publicacao, autor);
        int opc = 0;
        do {
            try {
                System.out.println("Deseja atrelar a Publicação a um projeto existente?\n 1 - Sim\n 2 - Não\n");
                opc = Integer.parseInt(scan.nextLine());
                if (opc < 1 || opc > 2) throw new IntegerOutOfRangeException();
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira um número de 1 a 2");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);

        if (opc ==1) {
            int id = 0;
            do {
                try {
                    System.out.println("Informe o Id do projeto:\n");
                    id = Integer.parseInt(scan.nextLine());
                    int count = 0;
                    for (int i = 0; i<dados.todos_projetos.size(); i++){
                        if (dados.todos_projetos.get(i).getId_projeto()!= id){
                            count++;
                        }
                        if (count == dados.todos_projetos.size()){//se o count for igual ao size é pq percorreu todo o arraylist e não encontrou o id
                            throw new EmptyID();
                        }
                    }
                    done = true;
                }catch (EmptyID e){
                    System.out.println(e);
                    System.out.println("Insira o ID de um projeto existente\n");
                }catch (NumberFormatException e){
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");
                }
            }while (!done);
            done = false;

            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getId_projeto() == id) {
                    if (dados.todos_projetos.get(i).getStatus() == 2){
                        dados.todos_projetos.get(i).addPublicacao(nova_publicacao);
                        System.out.println("Publicação adcionada com sucesso\n");
                    }else{
                        System.out.println("Projeto não está na fase 'em andamento'. Não podem ser feitas alterações\n");
                    }

                }
            }
        }

        autor.addPublicacao(nova_publicacao);
        dados.todas_publicacoes.add(nova_publicacao);

    }

    public void relatorios(Dados dados){
        int opc = 0;
        done = false;
        do {
            try {
                System.out.println("Escolha o tipo de relatório desejado:\n" +
                        "1 - Número de colaboradores\n" +
                        "2 - Número de projetos em elaboração\n" +
                        "3 - Número de projetos em andamento\n" +
                        "4 - Número de projetos concluidos\n" +
                        "5 - Número total de projetos\n" +
                        "6 - Número de Publicações\n");

                opc = Integer.parseInt(scan.nextLine());
                if (opc < 1 || opc > 6) throw new IntegerOutOfRangeException();
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira um número de 1 a 6");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);
        done = false;

        if (opc == 1) {
            System.out.println("Número de colaboradores " + dados.todos_usuarios.size());
        } else if (opc == 2) {
            int count = 0;
            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getStatus() == 1) {
                    count++;
                }
            }
            System.out.println("Número de projetos em elaboração " + count);

        } else if (opc == 3) {
            int count = 0;
            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getStatus() == 2) {
                    count++;
                }
            }
            System.out.println("Número de projetos em andamento " + count);

        } else if (opc == 4) {
            int count = 0;
            for (int i = 0; i < dados.todos_projetos.size(); i++) {
                if (dados.todos_projetos.get(i).getStatus() == 3) {
                    count++;
                }
            }
            System.out.println("Número de projetos concluídos " + count);

        } else if (opc == 5) {
            System.out.println("Número total de projetos " + dados.todos_projetos.size());
        } else if (opc == 6) {
            System.out.println("Número total de publicações " + dados.todas_publicacoes.size());
            }
        }

    public void consultas(Dados dados){
        int opcao = 0;
        done = false;
        do {
            try {
                System.out.println("Escolha a opção de consulta desejada:\n"+
                        "1 - Consulta por colaborador\n"+
                        "2 - Consulta por projeto");

                opcao = Integer.parseInt(scan.nextLine());
                if (opcao < 1 || opcao > 2) throw new IntegerOutOfRangeException();
            }catch (IntegerOutOfRangeException e){
                System.out.println(e);
                System.out.println("Insira um número de 1 a 6");
            }catch (NumberFormatException e){
                System.out.println(e);
                System.out.println("Insira um número inteiro\n");

            }
        }while (!done);
        done = false;

        if (opcao == 1){
            int cpf = 0;
            done = false;
            do {
                try {
                    System.out.println("Insira o CPF do colaborador:");
                    cpf = Integer.parseInt(scan.nextLine());
                    int count = 0;
                    for (int j = 0; j < dados.todos_usuarios.size(); j++) {
                        if (dados.todos_usuarios.get(j).getCpf() != cpf){
                            count++;
                        }
                        if (count ==  dados.todos_usuarios.size()){
                            throw new EmptyCPF();
                        }
                    }
                    done = true;
                }catch (EmptyCPF e){
                    System.out.println(e);
                    System.out.println("CPF não cadastrado. Insira um CPF válido\n");
                }catch (NumberFormatException e){
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");

                }
            }while (!done);
            done = false;

            for (int i = 0; i<dados.todos_usuarios.size(); i++){
                if (dados.todos_usuarios.get(i).getCpf() == cpf){
                    Usuario colaborador = dados.todos_usuarios.get(i);
                    System.out.println("Nome do colaborador: " + colaborador.getNome()+"\n");
                    System.out.println("Email do colaborador: " + colaborador.getEmail()+"\n");
                    System.out.println("Projetos:");
                    for (int j = 0; j<colaborador.getProjetos().size(); j++){
                        System.out.println( "Título do projeto " + colaborador.getProjetos().get(j).getTitulo()+"\n"+
                                            "Data de término "+ colaborador.getProjetos().get(j).getData_termino()+"\n");
                    }
                    System.out.println("Publicações:");
                    for (int b = 0; b<colaborador.getPublicacoes().size(); b++){
                        System.out.println( "Título da publicação " + colaborador.getPublicacoes().get(b).getTitulo()+"\n"+
                                            "Ano da publicação " + colaborador.getPublicacoes().get(b).getAno_publicacao()+"\n");
                    }
                }
            }
        }
        else if (opcao == 2){
            done = false;
            int id= 0;
            do {
                try {
                    System.out.println("Informe o Id do projeto:\n");
                    id = Integer.parseInt(scan.nextLine());
                    int count = 0;
                    for (int i = 0; i<dados.todos_projetos.size(); i++){
                        if (dados.todos_projetos.get(i).getId_projeto()!= id){
                            count++;
                        }
                        if (count == dados.todos_projetos.size()){//se o count for igual ao size é pq percorreu todo o arraylist e não encontrou o id
                            throw new EmptyID();
                        }
                    }
                    done = true;
                }catch (EmptyID e){
                    System.out.println(e);
                    System.out.println("Insira o ID de um projeto existente\n");
                }catch (NumberFormatException e){
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");
                }
            }while (!done);

            for (int i = 0; i<dados.todos_projetos.size(); i++){
                if (dados.todos_projetos.get(i).getId_projeto() == id){
                    Projeto projeto = dados.todos_projetos.get(i);
                    System.out.println("ID:  " + projeto.getId_projeto()+"\n"+
                                        "Título: " + projeto.getTitulo() +"\n"+
                                        "Data de início: " + projeto.getData_inicio()+"\n"+
                                        "Data de término: " + projeto.getData_termino()+"\n"+
                                        "Agencia financiadora: " + projeto.getAgencia_financiadora()+"\n"+
                                        "Valor financiado: " + projeto.getValor_financiado()+"\n"+
                                        "Objetivo: " + projeto.getObjetivo()+"\n"+
                                        "Descrição: "+ projeto.getDescricao()+"\n"+
                                        "Status: " + projeto.getStatus()+"\n");

                    System.out.println("Alunos:\n");
                    for (int j = 0; j<projeto.getAlunos_participantes().size(); j++){
                        System.out.println("Nome: " + projeto.getAlunos_participantes().get(j).getNome()+"\n"+
                                           "Email " + projeto.getAlunos_participantes().get(j).getEmail()+"\n"+
                                            "CPF " + projeto.getAlunos_participantes().get(j).getCpf()+"\n");

                    }
                    System.out.println("Orientadores:\n");
                    for (int b = 0; b<projeto.getOrientadores().size(); b++){
                        System.out.println("Nome: "+ projeto.getOrientadores().get(b).getNome() + "\n"+
                                            "Email "+ projeto.getOrientadores().get(b).getEmail()+"\n"+
                                            "CPF " + projeto.getOrientadores().get(b).getCpf()+"\n");
                    }
                    System.out.println("Publicações\n");
                    for (int n = 0; n<projeto.getPublicacoes_projeto().size(); n++){
                        System.out.println("Título "+ projeto.getPublicacoes_projeto().get(n).getTitulo()+"\n"+
                                            "Conferência "+ projeto.getPublicacoes_projeto().get(n).getConferencia()+"\n"+
                                            "Ano de Publicação"+ projeto.getPublicacoes_projeto().get(n).getAno_publicacao()+"\n");
                    }

                }
            }
        }


    }

    public static Date formataData(String data) throws Exception {
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = (java.util.Date)formatter.parse(data);
        return date;
    }


}