/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.io.*;
import java.util.ArrayList;
import myinputs.ler;

/**
 *
 * @author Alex
 */
public class Menu {
    private static final String PATH_Produtos = "../produtos.dat";
    private static final String PATH_Pedidos = "../pedidos.dat";
    
    public static int menu() {
        int opcao;
        System.out.println("--------- Menu ---------");
        System.out.println("1 - Produtos");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Sair");
        System.out.print("Introduza a opção: ");
        opcao = ler.umInt();
        return opcao;
    }
    
    public static void menu_produtos(ArrayList<Produto> produtos) {
        int opcao;
        do {
            System.out.println("------- Produtos -------");
            System.out.println("1 - Mostrar Catálogo");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Voltar");
            System.out.print("Introduza a opção: ");
            opcao = ler.umInt();
            switch(opcao) {
                case 1:
                    FuncMenu.mostrarProdutos(produtos);
                    FuncMenu.delay();
                    break;
                case 2:
                    FuncMenu.adicionarProduto(produtos);
                    break;
                case 3:
                    FuncMenu.removerProduto(produtos);
                    break;
                case 4:
                    System.out.println("");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    FuncMenu.delay();
                    break;
            }
        } while(true);
    }
    
    public static void menu_pedidos(ArrayList<Produto> produtos, ArrayList<Pedido> pedidos) {
        int opcao;
        do {
            System.out.println("------- Pedidos -------");
            System.out.println("1 - Mostrar Pedidos");
            System.out.println("2 - Adicionar Pedido");
            //System.out.println("3 - Remover Pedido");
            System.out.println("4 - Voltar");
            System.out.print("Introduza a opção: ");
            opcao = ler.umInt();
            switch(opcao) {
                case 1:
                    FuncMenu.mostrarPedidos(pedidos);
                    FuncMenu.delay();
                    break;
                case 2:
                    FuncMenu.adicionarPedido(produtos, pedidos);
                    break;
                case 3:
                    //FuncMenu.removerProduto(produtos);
                    break;
                case 4:
                    System.out.println("");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    FuncMenu.delay();
                    break;
            }
        } while(true);
    }
    
    public static void main(String[] args) {
        int escolha;
        // Lista que vai conter produtos
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        // Ler ficheiro caso exista; criar caso não exista
        try {
            File f1 = new File(PATH_Produtos);
            File f2 = new File(PATH_Pedidos);
            if (f1.exists()) {
                ObjectInputStream is1 = new ObjectInputStream(new FileInputStream(f1));
                Produto.setUltimo(is1.readInt());
                produtos = (ArrayList<Produto>) is1.readObject();
            }
            else
                f1.createNewFile();
            
            if (f2.exists()) {
                ObjectInputStream is2 = new ObjectInputStream(new FileInputStream(f2));
                pedidos = (ArrayList<Pedido>) is2.readObject();
            }
            else
                f2.createNewFile();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        do {
            escolha = menu();
            switch (escolha) {
                case 1:
                    System.out.println("");
                    menu_produtos(produtos);
                    break;
                case 2:
                    System.out.println("");
                    menu_pedidos(produtos, pedidos);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("A Encerrar...");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    FuncMenu.delay();
                    break;
            }
        } while(true);
    }
}
