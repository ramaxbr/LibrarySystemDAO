package dao;

import model.Aluno;

public interface IAlunoDAO {

    //Inserindo na interface o CRUD a ser criado posteriormente.

    public void cadastrarAluno(Aluno aluno);

    public void listarAluno(Aluno aluno);

    public void buscarAluno(int idAluno);

    public void deletarAluno(Aluno aluno);

}
