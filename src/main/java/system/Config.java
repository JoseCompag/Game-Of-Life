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

    public String gamemode;
    public int rows;
    public int cols;
    public String initialConfig;

    private String path = "src/main/resources/";
    private String nameConfigProperties;

    public Config(String nameConfigProperties) {
        this.nameConfigProperties = nameConfigProperties;
    }

    public void loadConfig(){
        parseConfig();
    }

    private void parseConfig (){
        Properties prop = getPropertieFile();
        String stringTypeBoard = prop.getProperty("board.typeBoard");
        String stringRows = prop.getProperty("board.rows");
        String stringCols = prop.getProperty("board.cols");
        String stringNameInitialConfig = prop.getProperty("board.nameInitialConfig");

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
