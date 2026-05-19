package dao;

import model.Livro;

import java.util.List;
import java.util.Optional;

public interface ILivroDAO {

    public void cadastrarLivro(Livro livro);

    public List listarLivro();

    public Optional<Livro> buscarLivro(int idLivro);

    public void deletarLivro(int idLivro);
}
