package Exemplo;

import Exemplo.Model.Contato;
import Exemplo.Model.ContatoDAO;

import java.util.Calendar;
import java.util.List;
import java.io.Console;
import java.lang.System;

public class Main {

    private static Console console;

    private static void testePesquisar() {
        System.out.println("\n# Pesquisa #\n");
        ContatoDAO contatoDao = new ContatoDAO();
        List<Contato> contatos = contatoDao.pesquisar();
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }

    private static void testeCadastrar() {
        String nome, email, endereco;
        int dia, mes, ano;

        System.out.println("\n# Cadastro #\n");
        nome = console.readLine("Informe o nome: ");
        email = console.readLine("Informe o e-mail: ");
        endereco = console.readLine("Informe o endereço: ");

        dia = Integer.parseInt(console.readLine("Informe o dia de nascimento: "));
        mes = Integer.parseInt(console.readLine("Informe o mês de nascimento (0-11): "));
        ano = Integer.parseInt(console.readLine("Informe o ano de nascimento: "));

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(ano, mes, dia);
        contato.setDataNascimento(dataNascimento);

        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.salvar(contato);

        System.out.println("\nContato cadastrado.\n");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        int opcao = -1;
        console = System.console();

        do {
            System.out.println("\nMenu\n");
            System.out.println("1 - Pesquisar");
            System.out.println("2 - Cadastrar");
            System.out.println("0 - Sair\n");

            opcao = Integer.parseInt(console.readLine("Opção: "));

            switch (opcao) {
                case 1:
                    testePesquisar();
                    break;

                case 2:
                    testeCadastrar();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção inválida.\n");
            }
        } while (opcao != 0);
    }

}
