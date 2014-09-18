import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by simon_zhang on 9/12/14.
 */

public class op1avg {
    public static void main(String[] args) {
        String filename = args[0];

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".out"));
            String line = reader.readLine();
            int sum = 0;
            int count = 0;

            while (line != null)
            {
                String[] parts = line.split("\t");
                sum = sum + Integer.parseInt(parts[2]);
                line = reader.readLine();
                count++;
            }
            reader.close();
            writer.write(count + "\t" + sum);
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
    }
}
