package services;

import daoimpl.LivroDAO;
import model.Livro;

import java.util.Scanner;

public class BibliotecaServices {

    public void menuLivros(){
        Scanner sc = new Scanner(System.in);
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

                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = sc.nextLine();

                    System.out.println("Digite o autor do livro:");
                    String autorLivro = sc.nextLine();

                    System.out.println("Digite a editora do livro");
                    String editoraLivro = sc.nextLine();


                    LivroDAO cadastrarLivro = new LivroDAO();

                    Livro novoLivro = new Livro(nomeLivro, autorLivro, editoraLivro);

                    cadastrarLivro.cadastrarLivro(novoLivro);

                    break;
                case 2:

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

}
