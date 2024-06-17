package game;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public String gamemode;
    public int rows;
    public int cols;
    public String initialConfig;
    public String advanceMode;

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
        String gamemode = prop.getProperty("gamemode");
        String stringRows = prop.getProperty("rows");
        String stringCols = prop.getProperty("cols");
        String stringNameInitialConfig = prop.getProperty("nameInitialConfig");
        String stringAdvanceMode = prop.getProperty("advanceMode");

        this.gamemode = gamemode;
        this.rows = Integer.parseInt(stringRows);
        this.cols = Integer.parseInt(stringCols);
        this.initialConfig = getInitialConfig(stringNameInitialConfig);
        this.advanceMode = stringAdvanceMode;
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
