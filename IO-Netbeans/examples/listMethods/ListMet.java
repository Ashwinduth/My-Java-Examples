package listMethods;
import java.lang.reflect.*;
/**
 *
 * @author sai
 */

public class ListMet {
public static void lm(Class cl)
{
 try {
            Method[] m = cl.getMethods();
            System.out.println("\nClass: "+cl.getName());
            System.out.println("No. of classes= "+m.length+"\n");
            for (int i = 0; i < m.length; i++)
            System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }

}
}
