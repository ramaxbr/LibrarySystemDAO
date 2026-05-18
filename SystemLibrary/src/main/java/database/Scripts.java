package database;

public class Scripts {

    public String scriptCadastrarLivro(){
            String sql = "INSERT INTO livro (nome, autor, editora) VALUES (?, ?, ?)";
        return sql;
    }

}
