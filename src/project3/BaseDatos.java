/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.sql.*;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Alumno
 */
public class BaseDatos{
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    String user="usuario";
    String password="1234";
    String url="jdbc:mysql://localhost/empleados";
  
    BaseDatos(){
        
        
        try {
            con=DriverManager.getConnection(url,user,password);
            st=con.createStatement();
            
        } 
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
            System.out.println(("ERROR: "+ex));
            
        } 
    }
    
    public void listado(String tabla){
        try{
            rs = st.executeQuery("SELECT * FROM "+tabla);
        while(rs.next()){
                 //   al=new Alumno(rs.getString(1),rs.getString(2),rs.getInt(3));
                 //   vL.imprime(al);
                }
            }
            catch(SQLException ex){
                Vmensaje m=new Vmensaje("error:  "+ex);
            } 
    }
    
    public Empleado buscarEmpleado(String dni, int estado){
        try{
            
            if(estado==0){
                rs=st.executeQuery("Select * from oficinas where dni LIKE '"+dni+"';");
                if(rs.next()){
                    Oficinas oficinas=new Oficinas(rs.getString(1),rs.getString(2),
                            rs.getString(3),Integer.parseInt(rs.getString(4)),rs.getString(5),
                            rs.getString(6));
                    return oficinas;
                }
                else{
                    Vmensaje msj=new Vmensaje("No existe el dni.");
                }
            }
            if(estado==1){
                rs=st.executeQuery("Select * from laboral where dni LIKE '"+dni+"';");
                if(rs.next()){
                    
                    int [] horas={Integer.parseInt(rs.getString(6)),Integer.parseInt(rs.getString(7)),
                    Integer.parseInt(rs.getString(8)),Integer.parseInt(rs.getString(9)),
                    Integer.parseInt(rs.getString(10)),Integer.parseInt(rs.getString(11)),
                    Integer.parseInt(rs.getString(12)),Integer.parseInt(rs.getString(13)),
                    Integer.parseInt(rs.getString(14)),Integer.parseInt(rs.getString(15)),
                    Integer.parseInt(rs.getString(16)),Integer.parseInt(rs.getString(17))};
                
                
                    Laboral laboral=new Laboral(rs.getString(1),rs.getString(2),
                            rs.getString(3),Integer.parseInt(rs.getString(4)),rs.getString(5), horas);
                    return laboral;
                }
                else{
                    Vmensaje msj=new Vmensaje("No existe el dni.");
                }
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }  
        return null;
    }
    
    /**
     * buscar parte del apellido
     */
    
    public void buscarApellido(String ape, int estado){
        
     try{
            if(estado==0){
                rs=st.executeQuery("Select dni,nombre,apellidos from oficinas where apellidos LIKE '%"+ape+"%';");
                
                TreeSet<Empleado> ts=new TreeSet();
                while(rs.next()){
                    Oficinas oficinas=new Oficinas(rs.getString(1),rs.getString(2),rs.getString(3));
                    ts.add(oficinas);
                }
                visualiza(ts);
                
            }
            if(estado==1){
                rs=st.executeQuery("Select dni,nombre,apellidos from laboral where apellidos LIKE '%"+ape+"%';");
                TreeSet<Empleado> ts2=new TreeSet();
                while(rs.next()){
                    Laboral laboral=new Laboral(rs.getString(1),rs.getString(2),rs.getString(3));
                    ts2.add(laboral);
                    
                }
                visualiza(ts2);
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }  
    }
    
    public int hMes(Empleado emp,String mes){
        try{
            rs=st.executeQuery("Select "+mes+" from laboral where dni LIKE '"+emp.getDni()+"';");
            if(rs.next()){
                int hMes=rs.getInt(1);
                return hMes;
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
            return 0;
        }
        return 0;
    }
    public int dineroCat(String cat){
        try{
            rs=st.executeQuery("Select sueldoBase from categoria where codigo LIKE '"+cat+"';");
            if(rs.next()){
                int dinCat=rs.getInt(1);
                return dinCat;
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
            return 0;
        }
        return 0;
    }
    
    
    /**
     * Controla si el empleado ya existe en la tabla
     */
    public boolean existe(Empleado empleado){
        try{
            if(empleado instanceof Oficinas){
                rs=st.executeQuery("Select dni from oficinas where dni LIKE '"+empleado.getDni()+"';");
            }
            else if(empleado instanceof Laboral){
                rs=st.executeQuery("Select dni from laboral where dni LIKE '"+empleado.getDni()+"';");
            }
            else{
                Vmensaje msj=new Vmensaje("No se ha recivido el objeto correcto.");
            }
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
        } 
        return false;
    }
   /**
    * Cierra la conexion
    */
    public void cerrar(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
            if (con!=null){
                con.close();
            }
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("Error cerrando la conexión: "+ex);
            
        }   
    }
    /**
     * Compruebo que el registro no exista ya, y si no existe lo creo
     * @param empleado 
     */
    public boolean altaEmpleado(Empleado empleado){  
        try {
            if(!existe(empleado)){
                if(empleado instanceof Laboral){
                    Laboral laboral=(Laboral)empleado;
                    int [] horas=laboral.getHoras();
                    int h1=horas[0];
                    int h2=horas[1];
                    int h3=horas[2];
                    int h4=horas[3];
                    int h5=horas[4];
                    int h6=horas[5];
                    int h7=horas[6];
                    int h8=horas[7];
                    int h9=horas[8];
                    int h10=horas[9];
                    int h11=horas[10];
                    int h12=horas[11];
                    st.executeUpdate("INSERT INTO laboral VALUES ('"+laboral.getDni()+
                        "','"+laboral.getNom()+"','"+laboral.getApe()+
                        "','"+laboral.getnHij()+
                        "','"+laboral.getCategoria()+
                        "','"+h1+"','"+h2+"','"+h3+"','"+h4+
                        "','"+h5+"','"+h6+"','"+h7+"','"+h8+
                        "','"+h9+"','"+h10+"','"+h11+"','"+h12+"');");
                    return true;
                }
                if(empleado instanceof Oficinas){
                    Oficinas oficina=(Oficinas)empleado;
                    st.executeUpdate("INSERT INTO oficinas VALUES ('"+oficina.getDni()+
                        "','"+oficina.getNom()+
                        "','"+oficina.getApe()+
                        "','"+oficina.getnHij()+
                        "','"+oficina.getCategoria()+
                        "','"+oficina.getPuesto()+"');");
                    return true;
                }
            }
            else{
                Vmensaje msj=new Vmensaje("Ya existe un empleado con ese dni.");
                return false;
            }
        } catch (SQLException ex){
           Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }
        return false;
    } 
    
    public boolean modifEmp(Empleado empleado){
        try {
            if(empleado instanceof Laboral){
                Laboral laboral=(Laboral)empleado;
                int [] horas=laboral.getHoras();
                int h1=horas[0];
                int h2=horas[1];
                int h3=horas[2];
                int h4=horas[3];
                int h5=horas[4];
                int h6=horas[5];
                int h7=horas[6];
                int h8=horas[7];
                int h9=horas[8];
                int h10=horas[9];
                int h11=horas[10];
                int h12=horas[11];
                st.executeUpdate("UPDATE laboral SET nombre= '"+laboral.getNom()+
                    "',apellidos= '"+laboral.getApe()+
                    "',hijos= '"+laboral.getnHij()+
                    "',categoria= '"+laboral.getCategoria()+
                    "',hEnero= '"+h1+"',hFebrero= '"+h2+"',hMarzo= '"+h3+"',hAbril= '"+h4+
                    "',hMayo= '"+h5+"',hJunio= '"+h6+"',hJulio= '"+h7+"',hAgosto= '"+h8+
                    "',hSeptiembre= '"+h9+"',hOctubre= '"+h10+"',hNoviembre= '"+h11+"',hDiciembre= '"+h12+"' where dni= '"+laboral.getDni()+"';");
                return true;
            }
            if(empleado instanceof Oficinas){
                Oficinas oficina=(Oficinas)empleado;
                st.executeUpdate("UPDATE oficinas SET nombre= '"+oficina.getNom()+
                    "',apellidos= '"+oficina.getApe()+
                    "',hijos= '"+oficina.getnHij()+
                    "',categoria= '"+oficina.getCategoria()+
                    "',puesto= '"+oficina.getPuesto()+"' WHERE dni= '"+oficina.getDni()+"';");
                return true;
            }

            else{
                Vmensaje msj=new Vmensaje("Ya existe un empleado con ese dni.");
                return false;
            }
        } catch (SQLException ex){
           Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }
        return false;
    
    }
    
    public boolean bajaEmpleado(Empleado empleado){  
        try {
            if(empleado instanceof Laboral){
                st.executeUpdate("DELETE from laboral where dni LIKE '"+empleado.getDni()+"';");
                return true;
            }
            if(empleado instanceof Oficinas){
                st.executeUpdate("DELETE from oficinas where dni LIKE '"+empleado.getDni()+"';");
                return true;
            }
        } 
        catch (SQLException ex){
                Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }
        return false;
    } 
    public void listadoEmp(){   
    String[] data=new String[3];
    try {
            st=con.createStatement();
            
            rs=st.executeQuery("SELECT dni, nombre, apellidos  FROM oficinas;");
            
            //insertamos el contenido de las columnas
            TreeSet<Empleado> ts=new TreeSet();
            while(rs.next()){
               Empleado emp=new Oficinas(rs.getString(1),rs.getString(2),rs.getString(3));
               ts.add(emp);
            }
            rs=st.executeQuery("SELECT dni, nombre, apellidos  FROM laboral;");
            
            while(rs.next()){
               Empleado emp=new Laboral(rs.getString(1),rs.getString(2),rs.getString(3));
               ts.add(emp);
            }
            visualiza(ts);
            
            
        } catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
        }    
    }
    public void visualiza(TreeSet ts){
        Empleado emp;
            Iterator it=ts.iterator();
            Vlistado list=new Vlistado();
            while(it.hasNext()){
                emp=(Empleado)it.next();
                list.muestraEmp(emp);
            }
    }
    
    
    
}
