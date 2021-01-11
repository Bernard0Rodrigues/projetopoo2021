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
public class Pneus extends Produto {
    private String tipo; // Inverno, Verão ou Misto
    private String marcaPneu;
    
    public Pneus(Produto p, String tipo, String marcaPneu) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.marcaPneu = marcaPneu;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarcaPneu() {
        return marcaPneu;
    }

    public void setMarcaPneu(String marcaPneu) {
        this.marcaPneu = marcaPneu;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo de Pneu: " + tipo + ", Marca do Pneu: " + marcaPneu + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Pneus p = (Pneus) obj;
            return (super.equals(p) && this.tipo.equals(p.tipo) && this.marcaPneu.equals(p.marcaPneu));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Pneus pp = new Pneus(p, tipo, marcaPneu);
        return pp;
    }
}
