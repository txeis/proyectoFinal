/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author txeis
 */
public class Categoria {
    
    private char categoria;
    private double sueldo;
   // BaseDatos con;
    
    public Categoria(char categoria,double sueldo){
        this.categoria=categoria;
        this.sueldo=sueldo;
       /* con=new BaseDatos();
        con.altaCategoria(this);*/
    }
    
    
    
    /**
     * @return the categoria
     */
    public char getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
