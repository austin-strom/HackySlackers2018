import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class TsvReader {
    public static void Reader(String Filename) throws Exception{
        StringTokenizer st ;
        BufferedReader TSVFile = new BufferedReader(new FileReader(Filename));
        String dataRow = TSVFile.readLine(); // Read first line.
        while (dataRow != null){
            st = new StringTokenizer(dataRow,"\t");
            List<String>dataArray = new ArrayList<String>() ;
            while(st.hasMoreElements()){
                dataArray.add(st.nextElement().toString());
            }
            for (String item:dataArray) {
                System.out.print(item + "  ");
            }
            System.out.println(); // Print the data line.
            dataRow = TSVFile.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        TSVFile.close();
        // End the printout with a blank line.
        System.out.println();
    }
}

