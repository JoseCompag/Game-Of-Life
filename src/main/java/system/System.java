package system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class System {

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("config.properties");
            prop.load(input);
            String typeBoard = prop.getProperty("board.typeBoard");
            String rows = prop.getProperty("board.rows");
            String cols = prop.getProperty("board.cols");
            String initialLayout = prop.getProperty("board.initialLayout");
            String ruleType = prop.getProperty("rule.ruleType");
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file:" + e.getMessage());
        }


    }
}
