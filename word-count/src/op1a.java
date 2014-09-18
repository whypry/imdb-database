import java.io.*;

/**
 * Created by simon_zhang on 9/11/14.
 */
public class op1a {

    public static void main(String[] args) {
        String filename = args[0];

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".out"));
            String line;
            int count = 0;
            line = reader.readLine();

            while (line != null)
            {
                count++;
                line = reader.readLine();
            }
            reader.close();
            writer.write(count);
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
    }
}
