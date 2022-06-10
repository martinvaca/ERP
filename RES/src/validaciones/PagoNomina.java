package validaciones;

import java.util.Scanner;
import javax.swing.JTextField;

/**
 *
 * @author Martin Vaca
 */
public class PagoNomina 
{
    Scanner sc = new Scanner(System.in);
    int Semana = 0;
    int Mes =0;
    int salario=0;
    
    
    public void Pago(JTextField Salario)
    {
        System.out.println("¿Cuantos meses Trabajo?");
        Mes = sc.nextInt();
        Semana= Mes*4;
        salario=salario*Semana;
        
    }
    
}
