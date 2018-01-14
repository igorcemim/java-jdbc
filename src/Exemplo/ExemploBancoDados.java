package Exemplo;

import Exemplo.Model.Contato;
import Exemplo.Model.ContatoDAO;
import java.util.ArrayList;
import java.util.Calendar;

public class ExemploBancoDados {
    
    private static void testePesquisar() {
        ContatoDAO contatoDao = new ContatoDAO();
        ArrayList<Contato> contatos = contatoDao.pesquisar();
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
    
    private static void testeSalvar() {
        Contato contato = new Contato();
        contato.setNome("Igor Cemim");
        contato.setEmail("igor@cemim.com.br");
        contato.setEndereco("Rua Correa de Mello, 440");
        contato.setDataNascimento(Calendar.getInstance());
        
        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.salvar(contato);
    }

    public static void main(String[] args) {
        testePesquisar();
    }

}
