package services;

import daoimpl.LivroDAO;
import model.Livro;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaServices {
    Scanner sc = new Scanner(System.in);
    public void menuLivros(){

        boolean rodarMenu = true;
        int opcao = 0;

        do {
            System.out.println("====Menu Livros====");
            System.out.println("Selecione uma das opções:");
            System.out.println("1- Cadastrar.");
            System.out.println("2- Listar");
            System.out.println("3- Buscar por ID");
            System.out.println("4- Deletar.");
            System.out.println("0- Sair.");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    buscarLivroPorId();
                    break;
                case 4:
                    deletarLivro();
                    break;
                case 0:
                    rodarMenu = false;
                    break;
                default:
                    System.out.println("Valor inválido!");
            }

        }while (rodarMenu);
    }

    public void menuAlunos(){

    }


    public void cadastrarLivro(){
        System.out.println("Digite o nome do livro:");
        String nomeLivro = sc.nextLine();

        System.out.println("Digite o autor do livro:");
        String autorLivro = sc.nextLine();

        System.out.println("Digite a editora do livro");
        String editoraLivro = sc.nextLine();


        LivroDAO cadastrarLivro = new LivroDAO();

        Livro novoLivro = new Livro(nomeLivro, autorLivro, editoraLivro);

        cadastrarLivro.cadastrarLivro(novoLivro);
    }

    public void listarLivros(){
        LivroDAO livroDAO = new LivroDAO();

        List<Livro> listarTodos = livroDAO.listarLivro();

        if (listarTodos.isEmpty()){
            throw new RuntimeException("Nenhum livro encontrado!");
        }else {
            for (Livro listar : listarTodos){
                System.out.println(listar);
            }
        }
    }

    public void buscarLivroPorId(){
        LivroDAO livroDAO = new LivroDAO();

        listarLivros();

        System.out.println("Digite o id do livro que deseja buscar:");
        int idLivro = sc.nextInt();
        sc.nextLine();

        System.out.println(livroDAO.buscarLivro(idLivro));

    }

    public void deletarLivro(){
        LivroDAO livroDAO = new LivroDAO();

        listarLivros();

        System.out.println("Digite o id que deseja excluir: ");
        int idLivro = sc.nextInt();

        livroDAO.deletarLivro(idLivro);

    }


}
