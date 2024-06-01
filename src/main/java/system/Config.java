package system;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Config {

    public String typeBoard;
    public int rows;
    public int cols;
    public String initialConfig;
    public List<Integer> numOfLiveCellsToBirth;
    public List<Integer> numOfLiveCellsToSurvive;

    private String path = "src/main/resources/";
    private String nameConfigProperties;

    public Config(String nameConfigProperties) {
        this.nameConfigProperties = nameConfigProperties;
    }

    public void loadConfig(){
        parseRuleConfig();
        parseBoardConfig();
    }

    private void parseRuleConfig() {
        Properties prop = getPropertieFile();
        String stringNumBirth = prop.getProperty("rule.numBirth");
        String stringNumSurvive = prop.getProperty("rule.numSurvive");

        this.numOfLiveCellsToBirth = stringToIntegerArray(stringNumBirth);
        this.numOfLiveCellsToSurvive = stringToIntegerArray(stringNumSurvive);
    }

    private void parseBoardConfig (){
        Properties prop = getPropertieFile();
        String stringTypeBoard = prop.getProperty("board.typeBoard");
        String stringRows = prop.getProperty("board.rows");
        String stringCols = prop.getProperty("board.cols");
        String stringNameInitialConfig = prop.getProperty("board.nameInitialConfig");

        this.typeBoard = stringTypeBoard;
        this.rows = Integer.parseInt(stringRows);
        this.cols = Integer.parseInt(stringCols);
        this.initialConfig = getInitialConfig(stringNameInitialConfig);
    }

    private Properties getPropertieFile() {
        try {
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream(this.nameConfigProperties);
            prop.load(input);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file:" + e.getMessage());
        }
    }

    private static List<Integer> stringToIntegerArray (String string) {
        List<Integer> res = new ArrayList<>();
        int numbersAddedCount = 0;
        List<String> scannedNumberArrayList = new ArrayList<>();
        boolean scanANumber = false;

        for (int i = 0; i < string.length() ; i++) {
            Character stringAtIndexI = string.charAt(i);
            if (Character.isDigit(stringAtIndexI)) {
                scannedNumberArrayList.add(String.valueOf(stringAtIndexI));
                scanANumber = true;
            } else {
                if (scanANumber) {
                    res.add(numbersAddedCount, newNumberFromArrayList(scannedNumberArrayList));
                    scannedNumberArrayList.clear();
                    numbersAddedCount++;
                    scanANumber = false;
                }
            }
        }
        res.add(numbersAddedCount, newNumberFromArrayList(scannedNumberArrayList));
        return res;
    }

    private static int newNumberFromArrayList (List<String> scannedNumberArrayList) {
        int newNumberInt;
        String newNumberString = "";
        for (String scannedString : scannedNumberArrayList) {
            newNumberString += scannedString;
        }
        newNumberInt = Integer.parseInt(newNumberString);
        return newNumberInt;
    }

    private String getInitialConfig (String nameInitialConfigTxt) {
        try {
            this.path += nameInitialConfigTxt;
            Path path = Paths.get(this.path);
            String string = Files.readString(path);
            return string;
        } catch (IOException e) {
            throw new RuntimeException("Error reading initial config file:" + e.getMessage());
        }
    }

}
