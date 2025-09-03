package br.com.Exercicio01.main;

import java.util.List;
import java.util.Scanner;

import br.com.Exercicio01.dao.UsuarioDAO;
import br.com.Exercicio01.model.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- CADASTRO DE USUÁRIOS (v2.0) ---");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Usuários Cadastrados ---");
                    List<Usuario> usuarios = usuarioDAO.listar();
                    for (Usuario u : usuarios) { System.out.println(u); }
                    break;
                case 2:
                    Usuario novoUsuario = new Usuario();
                    System.out.print("Nome: ");
                    novoUsuario.setNome(scanner.nextLine());
                    System.out.print("Senha: ");
                    novoUsuario.setSenha(scanner.nextLine());
                    System.out.print("Sexo (M/F): ");
                    novoUsuario.setSexo(scanner.nextLine().charAt(0));
                    usuarioDAO.inserir(novoUsuario);
                    System.out.println("Usuário inserido com sucesso!");
                    break;
                case 3:
                    System.out.print("ID do usuário a ser atualizado: ");
                    Usuario usuarioAtualizar = new Usuario();
                    usuarioAtualizar.setId(scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.print("Novo nome: ");
                    usuarioAtualizar.setNome(scanner.nextLine());
                    System.out.print("Nova senha: ");
                    usuarioAtualizar.setSenha(scanner.nextLine());
                    System.out.print("Novo sexo (M/F): ");
                    usuarioAtualizar.setSexo(scanner.nextLine().charAt(0));
                    usuarioDAO.atualizar(usuarioAtualizar);
                    System.out.println("Usuário atualizado com sucesso!");
                    break;
                case 4:
                    System.out.print("ID do usuário a ser excluído: ");
                    usuarioDAO.excluir(scanner.nextInt());
                    System.out.println("Usuário excluído com sucesso!");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}