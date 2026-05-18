package dao;

import model.Livro;

public interface ILivroDAO {

    public void cadastrarLivro(Livro livro);

    public void listarLivro(Livro livro);

    public void buscarLivro(int idLivro);

    public void deletarLivro(Livro livro);
}
