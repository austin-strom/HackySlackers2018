package naivebayes.old.experiments;


public class MainBayes {

    public static void main(String []args){

    }


    /*private static List<Example> readFile(String filename) {
        List <Example> examples = new ArrayList<Example>();
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            while(sc.hasNextLine()) {
                String[] tokens = sc.nextLine().split(",");
                double[] input = new double[30];
                for(int i = 0; i < tokens.length; i++) {
                    input[i] = Double.parseDouble(tokens[i]);
                }


                //examples.add(new Example(input))
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return examples;
    }*/
}
