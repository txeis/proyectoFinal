/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author idoia
 */
public class Vnomina extends JFrame{

     JPanel c;
     int estado;
     BaseDatos con;
    
     JLabel mesHoras;
     JLabel nombre;
     JLabel categoria;
     JLabel hijos;
     JLabel SB;
     JLabel IRPF;
     JLabel extra;
     JLabel SN;
     
    public Vnomina(String cadena, BaseDatos con,int estado, Empleado emp, int mes){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(600,400);
        this.setLocation(800,200);
        this.setVisible(true);
        if(estado==0){
            c.setBackground(Color.GREEN);
        }
        if(estado==1){
            c.setBackground(Color.CYAN);
        }
        c.setLayout(new GridLayout(8,1,10,10));
        
        
        Nomina nomina=new Nomina(con,estado,emp,mes);
        
        nomina.calculoNomina();
        
        mesHoras=new JLabel("Nómina del mes de "+nomina.getMesN()+"     Horas realizadas: "+nomina.gethMes());
        nombre=new JLabel("Trabajador: "+emp.getNom()+" "+emp.getApe()+" con dni: "+emp.getDni());
        categoria=new JLabel("Categoría: "+emp.getCategoria()+" ("+nomina.getDinCat()+" €)");
        hijos=new JLabel("Número de hijos para descuento de IRPF: "+emp.getnHij());
        SB=new JLabel("Salario bruto: "+nomina.getBruto()+" €");
        IRPF=new JLabel("IRPF a descontar: "+nomina.getIrpf()+" €");
        extra=new JLabel("Pagas extras: "+nomina.getExtra()+" €");
        SN=new JLabel("Salario neto total: "+nomina.getNeto()+" €");
        
        c.add(mesHoras);
        c.add(nombre);
        c.add(categoria);
        c.add(hijos);
        c.add(SB);
        c.add(IRPF);
        c.add(extra);
        c.add(SN);
    }
    
    
    
}
