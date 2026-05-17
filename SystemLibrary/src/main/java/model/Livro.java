package model;

public class Livro {
    private String nome;
    private int idLivro;
    private String autor;
    private String editora;

    //Construtor para leitura de dados
    Livro(int idLivro, String nome, String autor, String editora){
        setIdLivro(idLivro);
        setNome(nome);
        setAutor(autor);
        setEditora(editora);
    }
    //Construtor para criação de dados
    Livro(String nome, String autor, String editora){
        setNome(nome);
        setAutor(autor);
        setEditora(editora);
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return String.format("id: %d\n Livro: %s\n Autor: %s\n Editora: %s\n", idLivro, nome, autor, editora);
    }
}


