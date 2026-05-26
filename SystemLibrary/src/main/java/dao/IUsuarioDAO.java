package dao;

import model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    //Inserindo na interface o CRUD a ser criado posteriormente.

    public void cadastrarUsuario(Usuario usuario);

    public List listarUsuario();

    public Optional<Usuario> buscarUsuario(int idUsuario);

    public void deletarUsuario(int idUsuario);

    public void locacaoUsuario(int idLivro);

}
