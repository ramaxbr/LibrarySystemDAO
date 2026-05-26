package database;

public class Scripts {

    //Livro
    public String scriptCadastrarLivro(){
            String sql = "INSERT INTO livro (nome, autor, editora) VALUES (?, ?, ?)";
        return sql;
    }

    public String scriptListarLivro(){
            String sql = "SELECT * FROM livro";
        return sql;
    }

    public String scriptBuscarPorIDLivros(){
            String sql = "SELECT * FROM livro WHERE idLivro = ?";
        return sql;
    }

    public String scriptDeletarLivro(){
        String sql = "Delete FROM livro WHERE idLivro = ?";
            return sql;
    }


    //Usuario
    public String scriptCadastrarUsuario(){
        String sql = "INSERT INTO usuario (nome, endereco, telefone) VALUES (?, ?, ?)";
        return sql;
    }

    public String scriptListarUsuario(){
            String sql = "SELECT * FROM usuario";
        return sql;
    }

    public String scriptBuscarPorIDUsuario(){
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        return sql;
    }

    public String scriptDeletarUsuario(){
            String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        return sql;
    }

}
