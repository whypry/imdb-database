import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by simon_zhang on 9/12/14.
 */
public class op2avg {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int count = 0;
            int sum = 0;

            while (line != null)
            {
                String[] parts = line.split("\t");
                count = count + Integer.parseInt(parts[0]);
                sum = sum + Integer.parseInt(parts[1]);
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