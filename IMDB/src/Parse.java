import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 * Created by simon_zhang on 9/3/14.
 */
public class Parse {

    public static void main(String args[])
    {

        System.out.println("Hello World");

        String filename = "/Users/simon_zhang/Downloads/IMDB/movie.txt";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            FileWriter fw = new FileWriter("movie1.txt");
            PrintWriter pw = new PrintWriter(fw);

            // skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null)
            {

                String[] data = line.split(",", -1);
                String newData = data[0] + ",";
                String movie = "";

                if(data.length > 4) {
                    for(int i = 1; i < data.length - 2; i++) {
                        movie = movie + data[i];
                    }
                } else {
                    movie = data[1];
                }

                movie = movie.replace("'", "");
                newData = newData + movie + "," + data[data.length - 2] + "," + data[data.length - 1];

                pw.println(newData);
            }
            reader.close();
            pw.close();

        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
        // Parse **CAST**
//        String filename = "/Users/simon_zhang/Downloads/IMDB/cast.txt";
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//
//            String line;
//            while ((line = reader.readLine()) != null)
//            {
//
//                // adding missing ]
//                if(!line.endsWith(","))
//                {
//                    if(!line.endsWith("]"))
//                    {
//                        line = line+"]";
//                    }
//                }
//
//
//                // remove all sing quotes
//
//                line = line.replace("'","");
//                line = line.replace("[","'");
//                line = line.replace("]","'");
//
//
//                System.out.println(line);
//
//            }
//            reader.close();
//
//        }
//        catch (Exception e)
//        {
//            System.err.format("Exception occurred trying to read '%s'.", filename);
//            e.printStackTrace();
//
//        }
    }

}


