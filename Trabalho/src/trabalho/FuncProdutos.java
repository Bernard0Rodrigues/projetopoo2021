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
public class FuncProdutos {
    private static final String PATH = "../produtos.dat";
    
    public static void addPneu(ArrayList<Produto> produtos) {
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while (stock < 1) {
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.print("Tipo (Verão/Inverno/Misto): ");
        String tipo = ler.umaString();
        while (!tipo.equals("Verão") && !tipo.equals("Inverno") && !tipo.equals("Misto") ) {
            System.out.println("Tipo tem que ser Verão, Inverno ou Misto!");
            System.out.print("Introduza novamente: ");
            tipo = ler.umaString();
        }
        System.out.print("Marca do pneu: ");
        Pneus pp = new Pneus(p, tipo, ler.umaString());
        
        // Adicionar produto; Se repetido, somar stock
        boolean repetido = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Pneus)
                if ( ((Pneus) produtos.get(i)).equals(pp) ) {
                    System.out.println("Produto já existe no Catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo() - 1);
                    produtos.get(i).setStock(produtos.get(i).getStock() + stock);
                    repetido = true;
                }
        }
        if (!repetido) {
            produtos.add(pp);
            System.out.println("Produto adicionado com sucesso!");
        }
        
        // Atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addIluminacao(ArrayList<Produto> produtos) {
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while (stock < 1) {
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.print("Tipo (Farol/Luz traseira/etc): ");
        String tipo = ler.umaString();
        System.out.print("Cor (Xenon/outra): ");
        String cor = ler.umaString();
        System.out.print("Intermitente (Sim/Não)? ");
        String intermitente = ler.umaString();
        while (!intermitente.equals("Não") && !intermitente.equals("N") && !intermitente.equals("Sim") && !intermitente.equals("S")) {
            System.out.print("Opção inválida!\nIntroduza novamente: ");
            intermitente = ler.umaString();
        }
        Iluminacao pp = new Iluminacao(p, tipo, cor, intermitente);
        
        // Adicionar produto; Se repetido, somar stock
        boolean repetido = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Iluminacao)
                if ( ((Iluminacao) produtos.get(i)).equals(pp) ) {
                    System.out.println("Produto já existe no Catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo() - 1);
                    produtos.get(i).setStock(produtos.get(i).getStock()+ stock);
                    repetido = true;
                }
        }
        if (!repetido) {
            produtos.add(pp);
            System.out.println("Produto adicionado com sucesso!");
        }
        
        // Atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addCarrocaria(ArrayList<Produto> produtos){
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while(stock < 1){
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.println("Tipo (Porta/Capô/Pará-choques/Embaladeira/Vidro/Friso): ");
        String tipo = ler.umaString();
        while(!tipo.equals("Porta") && !tipo.equals("Capô") && !tipo.equals("Pára-choques") && !tipo.equals("Embaladeira") && !tipo.equals("Vidro") && !tipo.equals("Friso")){
            System.out.println("Tipo tem que ser porta, capô, pará-choques, embaladeira, vidro ou friso!");
            System.out.print("Introduza novamente: ");
            tipo = ler.umaString();
        }
        System.out.print("Marca da peça da carroçaria: ");
        Carrocaria cc = new Carrocaria(p, tipo, ler.umaString());
        
        //Adicionar produto; Se repetido, somar stock
        boolean repetido = false;
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Carrocaria){
                if(((Carrocaria) produtos.get(i)).equals(cc)){
                    System.out.println("Produto já existe no catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo()-1);
                    produtos.get(i).setStock(produtos.get(i).getStock() + stock);
                    repetido = true;
                }
            }
        }
        if(!repetido){
            produtos.add(cc);
            System.out.println("Produto adicionado com sucesso!");
        }
        
        //Atualizar ficheiro
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void addJantes(ArrayList<Produto> produtos){
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while(stock < 1){
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.print("Tipo (Aço/Ferro/Alumínio): ");
        String tipo = ler.umaString();
        System.out.print("Cor: ");
        String cor = ler.umaString();
        while(!tipo.equals("Aço") && !tipo.equals("Ferro") && !tipo.equals("Alumínio")){
            System.out.println("Tipo tem que ser aço, ferro ou alumínio!");
            System.out.print("Introduza novamente: ");
            tipo = ler.umaString();
        }
        System.out.print("Marca da jante: ");
        Jantes jj = new Jantes(p, tipo, ler.umaString(), cor);
        
        boolean repetido = false;
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Jantes)
                if(((Jantes) produtos.get(i)).equals(jj)){
                    System.out.println("Produto já existe no catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo() - 1);
                    produtos.get(i).setStock(produtos.get(i).getStock() + stock);
                    repetido = true;
                }
        }
        if(!repetido){
            produtos.add(jj);
            System.out.println("Produto adicionado com sucesso!");
        }
        
        // Atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addMotor(ArrayList<Produto> produtos){
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while(stock < 1){
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.print("Tipo (Gasolina/Gasóleo/GPL): ");
        String tipo = ler.umaString();
        System.out.print("Referência do motor: ");
        String referencia = ler.umaString();
        while(!tipo.equals("Gasolina") && !tipo.equals("Gasóleo") && !tipo.equals("GPL")){
            System.out.println("Tipo tem que ser gasolina, gasóleo ou GPL!");
            System.out.print("Introduza novamente: ");
            tipo = ler.umaString();
        }
        System.out.print("Marca do motor: ");
        String marcaMotor = ler.umaString();
        Motor mm = new Motor(p, tipo, ler.umaString(), referencia);
        
        boolean repetido = false;
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Motor)
                if(((Motor) produtos.get(i)).equals(mm)){
                    System.out.println("Produto já existe no catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo() - 1);
                    produtos.get(i).setStock(produtos.get(i).getStock() + stock);
                    repetido = true;
                }
        }
        if(!repetido){
            produtos.add(mm);
            System.out.println("Produto adicionado com sucesso!");
        }
        
        // Atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addInteriores(ArrayList<Produto> produtos){
        // Informação geral
        System.out.print("Marca: ");
        String marca = ler.umaString();
        System.out.print("Modelo: ");
        String modelo = ler.umaString();
        System.out.print("Preço: ");
        double preco = ler.umDouble();
        System.out.print("Stock: ");
        int stock = ler.umInt();
        while(stock < 1){
            System.out.print("Stock inválido!\nIntroduza novamente: ");
            stock = ler.umInt();
        }
        Produto p = new Produto(marca, modelo, preco, stock);
        
        // Informação específica (Herança)
        System.out.print("Tipo (Banco/Friso/Volante/Rádio/Encosto): ");
        String tipo = ler.umaString();
        System.out.print("Cor: ");
        String cor = ler.umaString();
        while(!tipo.equals("Banco") && !tipo.equals("Friso") && !tipo.equals("Volante") && !tipo.equals("Rádio") && !tipo.equals("Encosto")){
            System.out.println("Tipo tem que ser banco, friso, volante, rádio ou encosto");
            System.out.print("Introduza novamente: ");
            tipo = ler.umaString();
        }
        System.out.println("Marca do interior: ");
        Interiores ii = new Interiores(p, tipo, cor, ler.umaString());
        
        boolean repetido = false;
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i) instanceof Interiores)
                if(((Interiores) produtos.get(i)).equals(ii)){
                    System.out.println("Produto já existe no catálogo! Stock acrescentado ao produto.");
                    Produto.setUltimo(Produto.getUltimo() - 1);
                    produtos.get(i).setStock(produtos.get(i).getStock() +  stock);
                    repetido = true;
                }
        }
        if(!repetido){
            produtos.add(ii);
            System.out.println("Produto adicionado com sucesso!");
        }
                
        // Atualizar ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH));
            os.writeInt(Produto.getUltimo());
            os.writeObject(produtos);
            os.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


