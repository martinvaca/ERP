package restaurant;

/**
 *
 * @author Martin Vaca
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Tiempo 
{
    Calendar fecha= new GregorianCalendar();
    
    String a =Integer.toString(fecha.get(Calendar.YEAR));
    String m =Integer.toString(fecha.get(Calendar.MONTH)+ 1);
    String d =Integer.toString(fecha.get(Calendar.DATE));
    
    String fechacomp= "fecha: "+ a+"-"+m+"-"+d;
    String hora= Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
    String minuto=Integer.toString(fecha.get(Calendar.MINUTE));
    
    String horaComp = "Hora: "+hora+":"+minuto;
}
