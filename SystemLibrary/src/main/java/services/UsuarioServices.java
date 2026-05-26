package services;

import daoimpl.UsuarioDAO;
import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioServices {

    Scanner sc = new Scanner(System.in);
    public void menuUsuario(){

        boolean rodarMenu = true;
        int opcao = 0;

        do {
            System.out.println("====Menu Usuario====");
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
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    buscarUsuarioPorId();
                    break;
                case 4:
                    deletarUsuario();
                    break;
                case 0:
                    rodarMenu = false;
                    break;
                default:
                    System.out.println("Valor inválido!");
            }

        }while (rodarMenu);
    }


    public void cadastrarUsuario(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Digite o nome:");
        String nome = sc.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = sc.nextLine();

        System.out.println("Digite o telefone:");
        String telefone = sc.nextLine();

        Usuario novoUsuario = new Usuario(nome, endereco, telefone);

        usuarioDAO.cadastrarUsuario(novoUsuario);
    }

    public void listarUsuarios() {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List <Usuario> listUsuario = usuarioDAO.listarUsuario();

        if (listUsuario.isEmpty()){
            System.out.println("A lista está vazia!");
        } else {
            for (Usuario listar : listUsuario){
                System.out.println(listar);
            }
        }
    }

    public void buscarUsuarioPorId(){

    UsuarioDAO usuarioDAO = new UsuarioDAO();

        listarUsuarios();
        System.out.println("Digite o ID do usuário que deseja buscar: ");
            int idUsuario = sc.nextInt();
            sc.nextLine();
        System.out.println(usuarioDAO.buscarUsuario(idUsuario));
    }

    public void deletarUsuario(){

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    listarUsuarios();
        System.out.println("Digite o ID do usuário que deseja deletar: ");
            int idUsuario = sc.nextInt();
            sc.nextLine();

            usuarioDAO.deletarUsuario(idUsuario);
    }







}
