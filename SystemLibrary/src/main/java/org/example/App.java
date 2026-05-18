package org.example;

import daoimpl.LivroDAO;
import database.connectionFactory;
import model.Livro;
import services.BibliotecaServices;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        BibliotecaServices bibliotecaServices = new BibliotecaServices();
        connectionFactory.testConnection();
        Scanner sc = new Scanner(System.in);

        boolean rodarMenu = true;
        int opcao = 0;

        do {
            System.out.println("====Sistema da biblioteca====");
            System.out.println("Selecione uma das opções:");
            System.out.println("1- Menu Livros.");
            System.out.println("2- Menu Usuários.");
            System.out.println("0- Sair.");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    bibliotecaServices.menuLivros();
                    break;
                case 2:
                    bibliotecaServices.menuAlunos();
                    break;
                case 0:
                    rodarMenu = false;
                    break;
                default:
                    System.out.println("Valor inválido!");
            }

        }while (rodarMenu);
    }
}
