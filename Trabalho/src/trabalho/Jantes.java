/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author bernardorodrigues
 */
public class Jantes extends Produto{
    private String tipo; // Aço/Ferro/Alumínio
    private String marcaJante;
    private String cor;
    
    public Jantes(Produto p, String tipo, String marcaJante, String cor) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.marcaJante = marcaJante;
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarcaParteJante() {
        return marcaJante;
    }

    public void setMarcaJante(String marcaJante) {
        this.marcaJante = marcaJante;
    }
    
    public String getCorJante(){
        return cor;
    }
    
    public void setCorJante(String cor){
        this.cor = cor;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo de jante: " + tipo + ", Marca da jante: " + marcaJante + "Cor da jante: " + cor + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Jantes j = (Jantes) obj;
            return (super.equals(j) && this.tipo.equals(j.tipo) && this.marcaJante.equals(j.marcaJante));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Jantes jj = new Jantes(p, tipo, marcaJante, cor);
        return jj;
    }
}
