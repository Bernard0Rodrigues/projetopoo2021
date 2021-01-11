/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author Alex
 */
public class Iluminacao extends Produto {
    private String tipo; // Farol, Luz traseira, etc
    private String cor;
    private String intermitente; // Sim | Não
    
    public Iluminacao(Produto p, String tipo, String cor, String intermitente) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.cor = cor;
        this.intermitente = intermitente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIntermitente() {
        return intermitente;
    }

    public void setIntermitente(String intermitente) {
        this.intermitente = intermitente;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo de Iluminação: " + tipo + ", Cor: " + cor + ", Intermitente: " + intermitente + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Iluminacao p = (Iluminacao) obj;
            return (super.equals(p) && this.tipo.equals(p.tipo) && this.cor.equals(p.cor) && this.intermitente.equals(p.intermitente));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Iluminacao i = new Iluminacao(p, tipo, cor, intermitente);
        return i;
    }
}
