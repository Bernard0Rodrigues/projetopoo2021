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
public class Interiores extends Produto{
    private String tipo; // Banco/Friso/Volante/Rádio/Encosto
    private String cor;
    private String marcaInterior;
    
    public Interiores(Produto p, String tipo, String cor, String marcaInterior) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.cor = cor;
        this.marcaInterior = marcaInterior;
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
    
    public String getMarcaInterior(){
        return marcaInterior;
    }
    
    public void setMarcaInterior(){
        this.marcaInterior = marcaInterior;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Cor do interior: " + cor + ", Marca do interior: " + marcaInterior + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Interiores i = (Interiores) obj;
            return (super.equals(i) && this.marcaInterior.equals(i.marcaInterior) && this.marcaInterior.equals(i.marcaInterior));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Interiores ii = new Interiores(p, tipo, cor, marcaInterior);
        return ii;
    }
}
