
package Exemplo.Model;

import Exemplo.Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class ContatoDAO {
    
    private Connection connection;
    
    public ContatoDAO() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public void salvar(Contato contato) {
        try {
            String sql =
                    "insert into contato" + 
                    "(nome, email, endereco, dataNascimento) " +
                    "values(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

            statement.execute();
            statement.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Contato> pesquisar() {
        ArrayList<Contato> contatos = new ArrayList();
        
        try {
            PreparedStatement statement = connection.prepareStatement("select * from contato");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("nome"));
                contato.setEndereco(resultSet.getString("nome"));
                
                Date date = resultSet.getDate("dataNascimento");
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(date);
                contato.setDataNascimento(dataNascimento);
                
                contatos.add(contato);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return contatos;
    }
    
}
