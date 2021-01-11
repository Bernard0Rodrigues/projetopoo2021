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
public class FuncMenu {
    private static final String PATH_Produtos = "../produtos.dat";
    private static final String PATH_Pedidos = "../pedidos.dat";
    
    public static void delay() {
        System.out.print("Pressione <ENTER> para continuar...");
        ler.umaString();
        System.out.println("");
    }
    
    public static void mostrarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        System.out.println("---------- Catálogo ----------");
        System.out.println("  --> Pneus");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Pneus) {
                System.out.print(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        System.out.println("\n  --> Iluminação");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Iluminacao) {
                System.out.print(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        System.out.println("\n  --> Carroçaria");
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Carrocaria){
                System.out.print(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        System.out.println("\n  --> Jantes");
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Jantes){
                System.out.println(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        System.out.println("\n  --> Motor");
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Motor){
                System.out.println(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        System.out.println("\n  --> Interiores");
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Interiores){
                System.out.println(produtos.get(i).toString() + ", Stock: " + produtos.get(i).getStock());
                System.out.println("");
            }
        }
        
        System.out.println("------------------------------");
    }
    
    public static void adicionarProduto(ArrayList<Produto> produtos) {
        // Mostrar Categorias
        System.out.println("  1. Pneus");
        System.out.println("  2. Iluminação");
        System.out.println("  3. Carroçaria");
        System.out.println("  4. Jantes");
        System.out.println("  5. Motor");
        System.out.println("  6. Interiores");
        System.out.print("Qual o nº da categoria do produto que deseja adicionar? ");
        int num = ler.umInt();
        while (num < 1 || num > 6) {
            System.out.print("A categoria escolhida não existe!\nIntroduza novamente: ");
            num = ler.umInt();
        }
        // Adicionar Produto
        switch(num) {
            case 1:
                FuncProdutos.addPneu(produtos);
                break;
            case 2:
                FuncProdutos.addIluminacao(produtos);
                break;
            case 3:
                FuncProdutos.addCarrocaria(produtos);
                break;
            case 4:
                FuncProdutos.addJantes(produtos);
                break;
            case 5:
                FuncProdutos.addMotor(produtos);
                break;
            case 6:
                FuncProdutos.addInteriores(produtos);
                break;
        }
        delay();
    }
    
    public static void removerProduto(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Lista vazia!");
            delay();
            return;
        }
        mostrarProdutos(produtos);
        System.out.print("Qual o ID do produto que quer remover? ");
        int index = -1, id = ler.umInt();
        
        // verificar se ID existe
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getID() == id)
                index = i;
        }
        if (index == -1) {
            System.out.println("ID não existe!");
            delay();
            return;
        }
        
        System.out.print("Stock a remover: ");
        int rem = ler.umInt();
        while (rem < 0 || rem > produtos.get(index).getStock() ) {
            System.out.println("Stock inválido! Tem que ser positivo e menor ou igual a " + produtos.get(index).getStock());
            System.out.print("Introduza novamente: ");
            rem = ler.umInt();
        }
        
        // diminuir quantidade ou apagar produto
        if (rem != produtos.get(index).getStock())
            produtos.get(index).setStock(produtos.get(index).getStock() - rem);
        else
            produtos.remove(index);
        
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH_Produtos));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Produto removido com sucesso!");
        delay();
    }
    
    
    // Pedidos
    public static void mostrarPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        System.out.println("---------- Pedidos ----------");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i).toString());
            if (i != pedidos.size() - 1)
                System.out.println("");
        }
        System.out.println("-----------------------------");
    }
    
    public static void adicionarPedido(ArrayList<Produto> produtos, ArrayList<Pedido> pedidos) {
        if (produtos.isEmpty()) {
            System.out.println("Não existem produtos disponíveis!");
            delay();
            return;
        }
        ArrayList<Produto> artigos = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        System.out.print("Cliente: ");
        String nome = ler.umaString();
        Pedido p = new Pedido(nome);
        
        // Mostrar Produtos para escolha
        System.out.println("Nº de artigos disponíveis: " + produtos.size());
        System.out.print("Quantos artigos quer adicionar ao pedido? ");
        int num = ler.umInt();
        while (num > produtos.size()) {
            System.out.println("O catálogo só dispõe de " + produtos.size() + " artigos!");
            System.out.print("Introduza novamente: ");
            num = ler.umInt();
        }
        
        // Adicionar Produtos ao Pedido
        mostrarProdutos(produtos);
        int index = -1, id, quantidade;
        for (int i = 0; i < num; i++) {
            System.out.print("ID do produto: ");
            id = ler.umInt();
            // Verificar se ID existe
            for (int j = 0; j < produtos.size(); j++) {
                if (produtos.get(j).getID() == id)
                    index = j;
            }
            if (index == -1) {
                System.out.println("ID não existe! Volte a introduzir novamente.");
                i--;
                continue;
            }
            
            // Caso ID exista
            System.out.print("Quantidade: ");
            quantidade = ler.umInt();
            // Verificar se existe stock disponível
            while (produtos.get(index).getStock() < quantidade) {
                System.out.println("O produto tem um stock máximo de " + produtos.get(index).getStock() + "!");
                System.out.print("Introduza novamente: ");
                quantidade = ler.umInt();
            }
            // Caso haja stock
            artigos.add(produtos.get(index));
            quantidades.add(quantidade);
            // Diminuir stock do catálogo adicionado ao pedido
            if (produtos.get(index).getStock() == quantidade)
                produtos.remove(index);
            else
                produtos.get(index).setStock(produtos.get(index).getStock() - quantidade);
            
            if (num > 1) {
                if (i != num - 1)
                    System.out.println((i+1) + "º Produto adicionado! Adicione o próximo produto.");
                else
                    System.out.println("Todos os artigos foram adicionados ao pedido!");
            }
            // Resetar index
            index = -1;
        }
        
        p.setProdutos(artigos);
        p.setQuantidades(quantidades);
        
        // Atualizar arraylist
        pedidos.add(p);
        
        // Atualizar ficheiros
        try {
            ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream(PATH_Produtos));
            ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream(PATH_Pedidos));
            os1.writeObject(produtos);
            os2.writeObject(pedidos);
            os1.flush();
            os2.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        delay();
    }
}
