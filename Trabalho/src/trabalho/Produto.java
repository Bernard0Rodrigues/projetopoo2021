/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Produto implements Serializable {
    private static int ultimo = 0;
    private int id;
    private String marca;
    private String modelo;
    private double preco;
    private int stock;
    
    public Produto(String marca, String modelo, double preco, int stock) {
        ultimo++;
        id = ultimo;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.stock = stock;
    }
    
    public Produto(Produto p) {
        this(p.marca, p.modelo, p.preco, p.stock);
        p.setID(p.id);
        
    }
    
    public static int getUltimo() {
        return ultimo;
    }
    
    public static void setUltimo(int ultimo) {
        Produto.ultimo = ultimo;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "{ID: " + id + ", Marca: " + marca + ", Modelo: " + modelo + ", Preço: " + preco;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Produto p = (Produto) obj;
            return (this.marca.equals(p.marca) && this.modelo.equals(p.modelo) && this.preco == p.preco);
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(this);
        return p;
    }
}
