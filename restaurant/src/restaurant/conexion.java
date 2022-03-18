package restaurant;
/**
 *
 * @author Martin Vaca
 */
import java.sql.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conexion 
{
    String bd="erp";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="18010413";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx; 
    
    public conexion()
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
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) 
    {
        conexion conexion =new conexion();
        conexion.conectar();
    }
}
