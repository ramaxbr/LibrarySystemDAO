package model;

public class Aluno {
    private int idAluno;
    private String nome;
    private String endereco;
    private String telefone;

    //Construtor para leitura de dados
    public Aluno(int idAluno, String nome, String endereco, String telefone){
        setIdAluno(idAluno);
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    //Construtor para criação de dados
    public Aluno(String nome, String endereco, String telefone){
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    //Getters
    public int getIdAluno() {
        return idAluno;
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
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
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
        return String.format("Id: %d\n Nome: %s\n Endereço: %s\n Telefone: %s\n", idAluno, nome, endereco, telefone );
    }
}
