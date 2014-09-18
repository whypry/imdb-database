
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by simon_zhang on 9/11/14.
 */
public class op2 {
    public static void main(String[] args) {
        try{
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String line;
                int sum = 0;
                while ((line = reader.readLine()) != null)
                {
                    sum = sum + Integer.parseInt(line);
                }
                reader.close();
            System.out.println(sum);
        }
        catch (Exception e)
        {
            System.err.format("Exception occured trying to read '%s'.", args[0]);
            e.printStackTrace();
        }
    }
}
