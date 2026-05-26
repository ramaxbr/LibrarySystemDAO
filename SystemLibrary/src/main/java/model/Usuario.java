package model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String endereco;
    private String telefone;

    //Construtor para leitura de dados
    public Usuario(int idUsuario, String nome, String endereco, String telefone){
        setIdUsuario(idUsuario);
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    //Construtor para criação de dados
    public Usuario(String nome, String endereco, String telefone){
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    //Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    //Setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\n Nome: %s\n Endereço: %s\n Telefone: %s\n", idUsuario, nome, endereco, telefone );
    }
}
