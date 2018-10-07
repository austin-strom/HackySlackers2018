package BayesNew;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class BayesDriver {

    public static void init() throws FileNotFoundException, IOException {

        List<CSVRecord> trainingData = CSVFormat.DEFAULT.parse(new InputStreamReader(new FileInputStream(new File("dataset1.csv")))).getRecords();

        List<String> breastCancer = new ArrayList<>();
        List<String> prostateCancer = new ArrayList<>();
        List<String> colonCancer = new ArrayList<>();
        List<String> brainCancer = new ArrayList<>();
        List<String> lungCancer = new ArrayList<>();
        List<String> ovarianCancer = new ArrayList<>();
        List<String> noCancer = new ArrayList<>();

        for(CSVRecord record: trainingData){
            switch(record.get(5)){
                case "Breast":
                    breastCancer.add(record.toString());
                    break;
                case "Prostate":
                    prostateCancer.add(record.toString());
                    break;
                case "Colon":
                    colonCancer.add(record.toString());
                    break;
                case "Brain":
                    brainCancer.add(record.toString());
                    break;
                case "Lung":
                    lungCancer.add(record.toString());
                    break;
                case "Ovarian":
                    ovarianCancer.add(record.toString());
                    break;
                case "None":
                    noCancer.add(record.toString());
                    break;
            }
        }

        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();

        bayes.learn("Breast",breastCancer);
        bayes.learn("Prostate",prostateCancer);
        bayes.learn("Colon",colonCancer);
        bayes.learn("Brain",brainCancer);
        bayes.learn("Lung",lungCancer);
        bayes.learn("Ovarian",ovarianCancer);
        bayes.learn("None",noCancer);


        System.out.println(bayes.classify(Arrays.asList(/*NEW FEATURES*/)).getCategory());



       /* System.out.println( // will output "positive"
                bayes.classify(Arrays.asList(unknownText1)).getCategory());
        System.out.println( // will output "negative"
                bayes.classify(Arrays.asList(unknownText2)).getCategory());
*/
        /*
         * The BayesClassifier extends the abstract Classifier and provides
         * detailed classification results that can be retrieved by calling
         * the classifyDetailed Method.
         *
         * The classification with the highest probability is the resulting
         * classification. The returned List will look like this.
         * [
         *   Classification [
         *     category=negative,
         *     probability=0.0078125,
         *     featureset=[today, is, a, sunny, day]
         *   ],
         *   Classification [
         *     category=positive,
         *     probability=0.0234375,
         *     featureset=[today, is, a, sunny, day]
         *   ]
         * ]
         */
        /*((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1));
        */
        bayes.setMemoryCapacity(1000); // remember the last 500 learned classifications
    }



}
