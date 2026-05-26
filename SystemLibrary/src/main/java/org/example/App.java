package org.example;

import database.connectionFactory;
import services.UsuarioServices;
import services.LivroServices;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        LivroServices livroServices = new LivroServices();
        UsuarioServices usuarioServices = new UsuarioServices();
        connectionFactory.testConnection();
        Scanner sc = new Scanner(System.in);

        boolean rodarMenu = true;
        int opcao = 0;

        do {
            System.out.println("====Sistema da biblioteca====");
            System.out.println("Selecione uma das opções:");
            System.out.println("1- Menu Livros.");
            System.out.println("2- Menu Usuario.");
            System.out.println("0- Sair.");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    livroServices.menuLivros();
                    break;
                case 2:
                    usuarioServices.menuUsuario();
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
