package CONEXION;
/**
 *
 * @author Martin Vaca
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.filechooser.FileSystemView;
public class Conexion 
{
    Connection con;

    String bd="restaurante";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="18010413";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx; 
    
    public Conexion()
    {
        
    }
    
    public Connection conectar()
    {
        try 
        {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,user,password);
            System.out.println("Se conecto a la base de datos: " + bd);
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("No se conecto a la base de datos: " + bd);
        }
        return cx;
    }
    
    public void desconectar()
    {
        try 
        {
            cx.close();
        } 
        catch (SQLException ex) 
        {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) 
    {
        Conexion conexion =new Conexion();
        conexion.conectar();
    }
}
