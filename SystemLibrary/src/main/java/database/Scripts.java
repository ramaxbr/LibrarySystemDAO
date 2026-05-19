package database;

public class Scripts {

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

}
