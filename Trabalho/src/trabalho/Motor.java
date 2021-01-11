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
public class Motor extends Produto{
    private String tipo; // Gasolina/Gasóleo/GPL
    private String marcaMotor;
    private String referenciaMotor;
    
    public Motor(Produto p, String tipo, String marcaMotor, String referenciaMotor) {
        super(p);
        Produto.setUltimo(Produto.getUltimo() - 1);
        super.setID(super.getID() - 1);
        this.tipo = tipo;
        this.marcaMotor = marcaMotor;
        this.referenciaMotor = referenciaMotor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarcaMotor() {
        return marcaMotor;
    }

    public void setMarcaMotor(String marcaMotor) {
        this.marcaMotor = marcaMotor;
    }
    
    public String getReferenciaMotor(){
        return referenciaMotor;
    }
    
    public void setReferenciaMotor(){
        this.referenciaMotor = referenciaMotor;
    } 
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo de motor: " + tipo + ", Marca do motor: " + marcaMotor + "Referência do motor: " + referenciaMotor + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Motor m = (Motor) obj;
            return (super.equals(m) && this.tipo.equals(m.tipo) && this.marcaMotor.equals(m.marcaMotor));
        }
        return false;
    }
    
    @Override
    public Object clone() {
        Produto p = new Produto(super.getMarca(), super.getModelo(), super.getPreco(), super.getStock());
        p.setID(super.getID());
        Motor mm = new Motor(p, tipo, marcaMotor, referenciaMotor);
        return mm;
    }
}
