package BayesNew;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class NEWBAYES {
    public void init(String age, String race, String gender, String familyHistory, String BMI, String type) throws FileNotFoundException, IOException,URISyntaxException {

        //TODO: With type we have the ability to specify the types of cancer we are searching for. This may be helpful


        List<String> inputValues = new ArrayList<>();
        inputValues.add(age);
        inputValues.add(race);
        inputValues.add(gender);
        inputValues.add(familyHistory);
        inputValues.add(BMI);

        int breastCancerCounter = 0;
        int prostateCancerCounter = 0;
        int colonCancerCounter = 0;
        int brainCancerCounter = 0;
        int lungCancerCounter = 0;
        int ovarianCancerCounter = 0;
        int noCancerCounter = 0;

        List<CSVRecord> trainingData = CSVFormat.DEFAULT.parse(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Owner\\Desktop\\Hackathons\\HackySlackers2018\\CancerClassifier\\src\\BayesNew\\dataset1.csv")))).getRecords();

        List<String> breastCancer = new ArrayList<>();
        List<String> prostateCancer = new ArrayList<>();
        List<String> colonCancer = new ArrayList<>();
        List<String> brainCancer = new ArrayList<>();
        List<String> lungCancer = new ArrayList<>();
        List<String> ovarianCancer = new ArrayList<>();
        List<String> noCancer = new ArrayList<>();

        for (CSVRecord record : trainingData) {
            switch (record.get(5)) {
                case "Breast":
                    breastCancer.add(record.toString());
                    brainCancerCounter++;
                    break;
                case "Prostate":
                    prostateCancer.add(record.toString());
                    prostateCancerCounter++;
                    break;
                case "Colon":
                    colonCancer.add(record.toString());
                    colonCancerCounter++;
                    break;
                case "Brain":
                    brainCancer.add(record.toString());
                    brainCancerCounter++;
                    break;
                case "Lung":
                    lungCancer.add(record.toString());
                    lungCancerCounter++;
                    break;
                case "Ovarian":
                    ovarianCancer.add(record.toString());
                    ovarianCancerCounter++;
                    break;
                case "None":
                    noCancer.add(record.toString());
                    noCancerCounter++;
                    break;
            }
        }









    }
}
