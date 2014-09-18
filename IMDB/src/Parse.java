import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 * Created by simon_zhang on 9/3/14.
 */
public class Parse {

    public static void main(String args[]) {

        String myToken = "AB";
        String hash = "";
        hash = fromString(myToken);
        System.out.println(myToken +"\t"+ hash);

    }

    public static String fromString(String string) {
        checkArgument(string.length() >= 2,
                "input string (%s) must have at least 2 characters", string);
        checkArgument(string.length() % 2 == 0,
                "input string (%s) must have an even number of characters", string);

        byte[] bytes = new byte[string.length() / 2];
        for (int i = 0; i < string.length(); i += 2) {
            int ch1 = decode(string.charAt(i)) << 4;
            int ch2 = decode(string.charAt(i + 1));
            bytes[i / 2] = (byte) (ch1 + ch2);
        }
        return openFileToString(bytes);
    }

    public String openFileToString(byte[] _bytes)
    {
        String file_string = "";

        for(int i = 0; i < _bytes.length; i++)
        {
            file_string += (char)_bytes[i];
        }

        return file_string;
    }



}


//
//        System.out.println("Hello World");
//
//        String filename = "/Users/simon_zhang/Downloads/IMDB/movie.txt";
//
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//            FileWriter fw = new FileWriter("movie1.txt");
//            PrintWriter pw = new PrintWriter(fw);
//
//            // skip header
//            reader.readLine();
//
//            String line;
//            while ((line = reader.readLine()) != null)
//            {
//
//                String[] data = line.split(",", -1);
//                String newData = data[0] + ",";
//                String movie = "";
//
//                if(data.length > 4) {
//                    for(int i = 1; i < data.length - 2; i++) {
//                        movie = movie + data[i];
//                    }
//                } else {
//                    movie = data[1];
//                }
//
//                movie = movie.replace("'", "");
//                newData = newData + movie + "," + data[data.length - 2] + "," + data[data.length - 1];
//
//                pw.println(newData);
//            }
//            reader.close();
//            pw.close();
//
//        }
//        catch (Exception e)
//        {
//            System.err.format("Exception occurred trying to read '%s'.", filename);
//            e.printStackTrace();
//        }
//
//
//
//
//
//

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




