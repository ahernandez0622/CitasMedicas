
package dao;

import conexion.Credenciales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uml.Citas;
import uml.Clinicas;


public class DAOCitas implements Operaciones{
    
       //variables
    Citas citas =new Citas();
    Credenciales bd = new Credenciales();
    List<Citas> data = new  ArrayList <>();
    List<Clinicas> data2 = new  ArrayList <>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;

    
    @Override
    public boolean insertar(Object obj) {
       
        citas= (Citas) obj;
        this.sql="insert into citas (nombresPaciente,apellidosPaciente,genero,edad,fechCita,horaCita,idClinica) values (?,?,?,?,?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
            
           
            this.pst.setString(1, this.citas.getNombresPaciente());         
            this.pst.setString(2, this.citas.getApellidosPaciente());
            this.pst.setString(3,String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());
            this .pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());
            
            this.pst.setInt(7,this.citas.getIdClinica().getIdClinica());
                        
            
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas>0)
            {
                return true;
            }else
            {
                return false;
            }
            
            
            
        }catch(SQLException|ClassNotFoundException e)
        {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"La clinica seleccionada no existe");
            System.out.println("Excepciones controladas: "+e.getMessage());
           
            return false;
        }
        
        
       
    }

    @Override
    public boolean eliminar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        citas= (Citas) obj;
        this.sql="delete from citas where codigo=?";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
                       
            this.pst.setInt(1, this.citas.getCodigo());   
            
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas>0)
            {
                return true;
            }else
            {
                return false;
            }
            
            
            
        }catch(SQLException|ClassNotFoundException e)
        {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean modificar(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    citas= (Citas) obj;
        this.sql="update citas set nombresPaciente=?,apellidosPaciente=?,genero=?,edad=?,fechCita=?,horaCita=?,idClinica=? where codigo=?";
        try {
            Class.forName(bd.getDriver());
            this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(), bd.getContrasena());
            this.pst=this.con.prepareStatement(this.sql);
            
           
            this.pst.setString(1, this.citas.getNombresPaciente());         
            this.pst.setString(2, this.citas.getApellidosPaciente());
            this.pst.setString(3,String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());
            this .pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());            
            this.pst.setInt(7,this.citas.getIdClinica().getIdClinica());
            this.pst.setInt(8,this.citas.getCodigo());
                                    
            
            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas>0)
            {
                return true;
            }else
            {
                return false;
            }
            
            
            
        }catch(SQLException|ClassNotFoundException e)
        {
           // e.printStackTrace();
            System.out.println("Excepciones controladas: "+e.getMessage());
            return false;
        }
        
       
    
    
    }

    @Override
    public List<?> seleccionar() {
        this.sql="select * from citas";
       try {
           Class.forName(bd.getDriver());
           this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(),bd.getContrasena());
           this.pst=this.con.prepareStatement(sql);//hara un select
           this.rs=this.pst.executeQuery();//guardar la ejecucion de la sentencia
           
           
           while (this.rs.next())
           {
               data.add(new Citas(this.rs.getInt("codigo"),
                                      this.rs.getString("nombresPaciente"),
                                      this.rs.getString("apellidosPaciente"),
                                      this.rs.getString("genero").charAt(0),
                                      this.rs.getInt("edad"),
                                      this.rs.getDate("fechCita"),
                                      this.rs.getString("horaCita"),
                                      new Clinicas(this.rs.getInt("idClinica"))               
                                    ));
           }
           this.con.close();
           this .rs.close();
           
           
       }catch (SQLException|ClassNotFoundException e)
       {
       //e.printStackTrace();
       System.out.println("Excepciones controladas: "+e.getMessage());
       }
       
      return this.data;  

    }
    
   public List<?> seleccionarTabla() {
       this.sql="select * from clinicas";
       try {
           Class.forName(bd.getDriver());
           this.con=DriverManager.getConnection(bd.getUrl(),bd.getUsuario(),bd.getContrasena());
           this.pst=this.con.prepareStatement(sql);//hara un select
           this.rs=this.pst.executeQuery();//guardar la ejecucion de la sentencia
           
           
           while (this.rs.next())
           {
               data2.add(new Clinicas(this.rs.getInt("idClinica"),
                                      this.rs.getString("nombClinica"),
                                      this.rs.getInt("Empleados"),
                                      this.rs.getString("encargado")
               
                                    ));
           }
           this.con.close();
           this .rs.close();
           
           
       }catch (SQLException |ClassNotFoundException e)
       {
       //e.printStackTrace();
       System.out.println("Excepciones controladas: "+e.getMessage());
       }
       
      return this.data;  

       
   
   }
    
    
               
    
    
    
    
}
