package validaciones;

/**
 *
 * @author Martin Vaca
 */
public class numerosEnteros
{
     public static boolean validarnumeros(String num) {
        return num.matches("[0-9]*");
    }
}
