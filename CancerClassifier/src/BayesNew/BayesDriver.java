package BayesNew;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class BayesDriver {

    public static void init(String age, String race, String gender, String familyHistory, String BMI, String type) throws FileNotFoundException, IOException {

        //TODO: With type we have the ability to specify the types of cancer we are searching for. This may be helpful

        List<String> inputValues = new ArrayList<>();
        inputValues.add(age);
        inputValues.add(race);
        inputValues.add(gender);
        inputValues.add(familyHistory);
        inputValues.add(BMI);


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


        System.out.println(bayes.classify(inputValues).getCategory());

        System.out.println("Detailed Content: \n");
        System.out.println(((BayesClassifier<String, String>) bayes).classifyDetailed(inputValues));


        bayes.setMemoryCapacity(1000); // remember the last 500 learned classifications
    }



}
