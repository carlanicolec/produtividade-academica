import base.Dados;
import base.Funcionalidades;
import base.IntegerOutOfRangeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = 555;
        Dados dados = new Dados();
        Scanner scan = new Scanner(System.in);
        Funcionalidades nova_funcionalidade = new Funcionalidades();
        boolean done = false;
        while (opcao != 0) {
            do {
                try {
                    System.out.println(" -- Sistema de Produtividade Acadêmica --\n\n" +
                            "1 - Criar Projeto\n" +
                            "2 - Editar Projeto\n" +
                            "3 - Incluir Publicação\n" +
                            "4 - Consultas\n" +
                            "5 - Relatórios\n" +
                            "0 - Sair\n");

                    opcao = Integer.parseInt(scan.nextLine());
                    if (opcao < 0 || opcao > 5) throw new IntegerOutOfRangeException();
                    if (opcao == 1) {
                        nova_funcionalidade.addProjeto(dados);
                    } else if (opcao == 2) {
                        nova_funcionalidade.editarProjeto(dados);
                    } else if (opcao == 3) {
                        nova_funcionalidade.addPublicacao(dados);

                    } else if (opcao == 4) {
                        nova_funcionalidade.consultas(dados);
                    } else if (opcao == 5) {
                        nova_funcionalidade.relatorios(dados);
                    }
                    done = true;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("Insira um número inteiro\n");
                } catch (IntegerOutOfRangeException e) {
                    System.out.println(e);
                    System.out.println("Insira um número entre 0 e 5\n");
                } catch (java.lang.NullPointerException e) {
                    System.out.println(e);
                }
            }while (!done);
        }
    }
}