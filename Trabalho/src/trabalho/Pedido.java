/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Alex
 */
public class Pedido implements Serializable {
    private String nome;
    private LocalDate data;
    private LocalTime hora;
    private ArrayList<Produto> produtos;
    private ArrayList<Integer> quantidades;
    
    public Pedido(String nome) {
        this.nome = nome;
        data = LocalDate.now();
        hora = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = (ArrayList<Produto>) produtos.clone();
    }
    
    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }
    
    public void setQuantidades(ArrayList<Integer> quantidades) {
        this.quantidades = (ArrayList<Integer>) quantidades.clone();
    }

    @Override
    public String toString() {
        String s = "Cliente: " + nome + ", Data: " + data + ", Hora: " + hora + "\nProdutos:";
        for (int i = 0; i < produtos.size(); i++) {
            s += "\n   " + (i+1) + ". " + produtos.get(i).toString() + ", Quantidade: " + quantidades.get(i);
        }
        return s;
    }
    
    
}
