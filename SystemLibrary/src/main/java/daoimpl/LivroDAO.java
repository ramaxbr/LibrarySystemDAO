package daoimpl;

import dao.ILivroDAO;
import database.Scripts;
import database.connectionFactory;
import model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAO implements ILivroDAO {
    Scripts scripts = new Scripts();

    @Override
    public void cadastrarLivro(Livro livro) {
        try(Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptCadastrarLivro(), PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());

            stmt.executeUpdate();
            ResultSet chavePk = stmt.getGeneratedKeys();

            if (chavePk.next()){
                livro.setIdLivro(chavePk.getInt(1));
            }


            System.out.println("Livro cadastrado com sucesso!");

        }catch (SQLException errorSQL){
            System.out.println("Erro ao cadastrar livro: " + errorSQL.getMessage());
        }
    }

    @Override
    public List listarLivro() {
        List<Livro> listLivros = new ArrayList<>();

        try(Connection conn = connectionFactory.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptListarLivro());


            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                listLivros.add(new Livro(
                   rs.getInt("idLivro"),
                   rs.getString("nome"),
                   rs.getString("autor"),
                   rs.getString("editora")
                ));
            }
        }catch (SQLException errorSQL){
            System.out.println("Erro ao listar: " + errorSQL.getMessage());
        }
        return listLivros;
    }

    @Override
    public Optional buscarLivro(int idLivro) {
        try (Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptBuscarPorIDLivros());

            stmt.setInt(1, idLivro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Livro livro = new Livro(
                        rs.getInt("idLivro"),
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("editora")

                );
                return Optional.of(livro);
            }

        } catch (SQLException errorSQL) {
            throw new RuntimeException("Erro ao encontrar o Livro: ");

        }
        System.out.println("Livro não encontrado.");
        return Optional.empty();
    }

    @Override
    public void deletarLivro(int idLivro) {

        try(Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptDeletarLivro());

            stmt.setInt(1, idLivro);

            stmt.executeUpdate();

            System.out.println("Livro excluído com sucesso!");

        }catch (SQLException errorSQL){
            throw new RuntimeException("Erro ao deletar o livro." + errorSQL);
        }
    }
}
