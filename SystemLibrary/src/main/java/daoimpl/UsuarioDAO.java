package daoimpl;

import dao.IUsuarioDAO;
import database.Scripts;
import database.connectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO implements IUsuarioDAO {
    Scripts scripts = new Scripts();

    public void cadastrarUsuario(Usuario usuario){
        try (Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptCadastrarUsuario(), PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getEndereco());
            stmt.executeUpdate();

            ResultSet chavePk = stmt.getGeneratedKeys();

            if (chavePk.next()){
                usuario.setIdUsuario(chavePk.getInt(1));
            }

            System.out.println("Usuario cadastrado com sucesso!");
        }catch (SQLException errorSQL){
            System.out.println("Erro ao cadastrar o usuario: " + errorSQL.getMessage());
        }
    }

    @Override
    public List listarUsuario(){
        List <Usuario> listUsuario = new ArrayList<>();

        try (Connection conn = connectionFactory.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptListarUsuario());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                listUsuario.add(new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                ));
            }
        }catch (SQLException errorSQL){
            System.out.println("Erro ao listar: " + errorSQL.getMessage());
        }
        return listUsuario;
    }

    @Override
    public Optional buscarUsuario(int idUsuario){


        try(Connection conn = connectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptBuscarPorIDUsuario());

           stmt.setInt(1, idUsuario);
           ResultSet rs = stmt.executeQuery();

           if (rs.next()){
               Usuario usuario = new Usuario(
                       rs.getInt("idUsuario"),
                       rs.getString("nome"),
                       rs.getString("endereco"),
                       rs.getString("telefone")
               );
               return Optional.of(usuario);
           }
        }catch (SQLException errorSQL){
            System.out.println("Erro ao buscar usuário: " + errorSQL.getMessage());
        }
        System.out.println("Usuário não encontrado!");
        return Optional.empty();
    }

    @Override
    public void deletarUsuario(int idUsuario){
        try (Connection conn = connectionFactory.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(scripts.scriptDeletarUsuario());

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();

            System.out.println("Usuário deletado com sucesso!");

        }catch (SQLException errorSQL){
            System.out.println("Erro ao deletar o usuário: " + errorSQL.getMessage());
        }
    }

    @Override
    public void locacaoUsuario(int idLivro){

    }
}
