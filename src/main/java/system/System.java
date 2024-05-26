package system;

import board.Board;
import board.BoardFactory;
import rule.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class System {

    private String path = "src/main/resources/default.txt";
    private String configProperties = "configDefault.properties";

    public void setPath (String path) {
        this.path = path;
    }

    public void setConfigProperties (String configProperties) {
        this.configProperties = configProperties;
    }

    public ArrayList<Rule> buildRules() {
        Properties prop = getPropertieFile();
        String stringNumBirth = prop.getProperty("rule.numBirth");
        String stringNumSurvive = prop.getProperty("rule.numSurvive");

        int numBirth = Integer.parseInt(stringNumBirth);
        int numASurvive = 0;
        int numBSurvive = 0;

        Character character;
        int index = 0;
        int stringLenght = stringNumSurvive.length();
        boolean firstNumRead = false;
        while (index < stringLenght) {
            character = stringNumSurvive.charAt(index);
            if (Character.isDigit(character) & !firstNumRead){
                numASurvive = numASurvive * 10 + (character - '0');
            } else if ((Character.isDigit(character) & firstNumRead)) {
                numBSurvive = numBSurvive * 10 + (character - '0');
            } else {
                firstNumRead = true;
            }
            index++;
        }

        ArrayList<Rule> rules = buildRuleArrayList(numBirth, numASurvive, numBSurvive);
        return rules;
    }

    public Board buildBoard (List<Rule> rules) {
        Properties prop = getPropertieFile();
        String typeBoard = prop.getProperty("board.typeBoard");
        String rowsString = prop.getProperty("board.rows");
        String colsString = prop.getProperty("board.cols");

        ArrayList<Integer> paramsSize = new ArrayList<>();
        int rows = Integer.parseInt(rowsString);
        int cols = Integer.parseInt(colsString);
        paramsSize.add(0,rows);
        paramsSize.add(1,cols);
        String initialConfig = getInitialConfigTxt();

        BoardFactory boardFactory = new BoardFactory();
        Board board = boardFactory.createBoard(typeBoard, paramsSize, initialConfig, rules);
        return board;
    }

    private Properties getPropertieFile() {
        try {
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream(this.configProperties);
            prop.load(input);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file:" + e.getMessage());
        }
    }

    private static ArrayList<Rule> buildRuleArrayList (int numBirth, int numASurvive, int numBSurvive) {
        RuleFactory ruleBirthFactory = new BirthRuleFactory();
        RuleFactory ruleSurviveFactory = new SurviveRuleFactory();
        RuleFactory ruleDeathFactory = new DeathRuleFactory();

        ArrayList<Integer> params = new ArrayList<>();
        params.add(0,numBirth);
        BirthRule birthRule = (BirthRule) ruleBirthFactory.createRule(params);
        params.clear();
        params.add(0, numASurvive);
        params.add(1, numBSurvive);
        SurviveRule surviveRule = (SurviveRule) ruleSurviveFactory.createRule(params);
        params.clear();
        DeathRule deathRule = (DeathRule) ruleDeathFactory.createRule(params);

        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(0,birthRule);
        rules.add(1,surviveRule);
        rules.add(2,deathRule);
        return rules;
    }

    private String getInitialConfigTxt () {
        try {
            Path path = Paths.get(this.path);
          return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Error reading initial config file:" + e.getMessage());
        }
    }

}
