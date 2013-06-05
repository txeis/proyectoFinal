/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;

/**
 *
 * @author Alumno
 */
public abstract class Empleado implements Comparable <Empleado>{
    
    private String dni="a";
    private String nom="a";//nombre
    private String ape="a";//apellidos
    private int nHij=0;//numero de hijos
    private String categoria="C";
    
    
    public Empleado(String dni,String nom,String ape,int nHij,String categoria){
        this.dni=dni;
        this.nom=nom;
        this.ape=ape;
        this.nHij=nHij;
        this.categoria=categoria;
    }
    /**
     * Constructor para usar en el listado
     * @param dni
     * @param nom
     * @param ape 
     */
    public Empleado(String dni,String nom,String ape){
        this.dni=dni;
        this.nom=nom;
        this.ape=ape;
    }
    @Override
    public int compareTo(Empleado emp){
        int com=nom.compareTo(emp.nom);
        if(com==0){
            int com2=ape.compareTo(emp.ape);
            return com2;
        }
        else{
            return com;
        }
    }
    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the ape
     */
    public String getApe() {
        return ape;
    }

    /**
     * @param ape the ape to set
     */
    public void setApe(String ape) {
        this.ape = ape;
    }

    /**
     * @return the nHij
     */
    public int getnHij() {
        return nHij;
    }

    /**
     * @param nHij the nHij to set
     */
    public void setnHij(int nHij) {
        this.nHij = nHij;
    }

    /**
     * @return the categoría
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoría to set
     */
    public void setCategoría(String categoria) {
        this.categoria = categoria;
    }
    public static boolean dniCorrecto(String dni){
        char c;
        if(dni.length()!=9 ){
            return false;
        }
        for(int n=0;n<8;n++){
            if(numLetra(dni.charAt(n))!=1){
                return false;
            }
        }
        if(numLetra(dni.charAt(8))!=2){
            return false;
        }
        return true;
    }
    
    public String[] muestraEmp(Empleado emp){
        String tipo="";
        if(emp instanceof Oficinas){
            tipo="OFICINAS";
        }
        if(emp instanceof Laboral){
            tipo="LABORALES";
        }
        String[] arrayEmp={dni,nom,ape,tipo};
        return arrayEmp;
    }
    public int empCorrecto(Empleado emp){
        if(!dniCorrecto(dni)){return 1;}
        if(nom.length()<=0||nom.length()>50 || isNumeric(nom)){return 2;}
        if(ape.length()<=0||ape.length()>100 || isNumeric(ape)){return 3;}
        if(nHij<0||nHij>100){return 4;}
        if(emp instanceof Oficinas){
            if(categoria.length()!=1 || isNumeric(categoria) || (categoria.charAt(0)<'A' || categoria.charAt(0)>'C')){return 5;}
        }
        if(emp instanceof Laboral){
            if(categoria.length()!=1 || isNumeric(categoria) || (categoria.charAt(0)<'D' || categoria.charAt(0)>'F')){return 5;}
        }
        
        return 0;
    }
    
   protected static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }    
   protected static int numLetra(char c){
        if((c>='a' && c<='z')||(c>='A' && c<='Z')){
            return 2;
        }
        if(c>='0' && c<='9'){
            return 1;
        }
        return 0;
    }
   
}
    
