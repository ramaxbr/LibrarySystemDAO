package daoimpl;

import dao.ILivroDAO;
import database.Scripts;
import database.connectionFactory;
import model.Livro;

import java.sql.*;

public class LivroDAO implements ILivroDAO {
    Scripts scripts = new Scripts();

    @Override
    public void cadastrarLivro(Livro livro) {
        try(Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptCadastrarLivro(), PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());

            ResultSet chavePk = stmt.getGeneratedKeys();

            if (chavePk.next()){
                livro.setIdLivro(chavePk.getInt(1));
            }

            stmt.executeUpdate();
            System.out.println("Livro cadastrado com sucesso!");

        }catch (SQLException errorSQL){
            System.out.println("Erro ao cadastrar livro: " + errorSQL.getMessage());
        }
    }

    @Override
    public void listarLivro(Livro livro) {

    }

    @Override
    public void buscarLivro(int idLivro) {

    }

    @Override
    public void deletarLivro(Livro livro) {

    }
}
