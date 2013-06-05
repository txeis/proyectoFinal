/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public class Laboral extends Empleado{
    private int horas[]=new int[12];

    public Laboral(String dni,String nom,String ape,int nHij,String categoria, int horas[]){
        super(dni,nom,ape,nHij,categoria);
        this.horas=horas;
    }
    /**
     * Constructor para usar en el listado
     * @param dni
     * @param nom
     * @param ape 
     */
    public Laboral(String dni,String nom,String ape){
        super(dni,nom,ape);
    }
    
    public int labCorrecto(Empleado emp){
        int m=empCorrecto(emp);
        if(m==0){
            for(int n=0;n<horas.length;n++){
                if(horas[n]<0 || horas[n]>=100){return n+6;}
            }
        }
        else{
            return m;
        }
        return 0;
    }
    /**
     * @return the horas
     */
    public int[] getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int[] horas) {
        this.horas = horas;
    }
    
   
}

