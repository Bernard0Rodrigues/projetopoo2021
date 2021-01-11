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
public class Carrocaria extends Produto{
    private String tipo; // Porta/Capô/Pará-choques/Embaladeira/Vidro/Friso
    private String marcaPecaCarrocaria;
    
    public Carrocaria(Produto p, String tipo, String marcaPecaCarrocaria) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.marcaPecaCarrocaria = marcaPecaCarrocaria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarcaParteCarrocaria() {
        return marcaPecaCarrocaria;
    }

    public void setMarcaParteCarrocaria(String marcaPecaCarrocaria) {
        this.marcaPecaCarrocaria = marcaPecaCarrocaria;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo de peça da carroçaria: " + tipo + ", Marca da peça: " + marcaPecaCarrocaria + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Carrocaria c = (Carrocaria) obj;
            return (super.equals(c) && this.tipo.equals(c.tipo) && this.marcaPecaCarrocaria.equals(c.marcaPecaCarrocaria));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Carrocaria cc = new Carrocaria(p, tipo, marcaPecaCarrocaria);
        return cc;
    }
}
