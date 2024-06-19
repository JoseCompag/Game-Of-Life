package game;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    public String gamemode;
    public int rows;
    public int cols;
    public String initialConfig;
    public String advanceMode;
    public String output;

    private String nameConfigProperties;
    private String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    public Config(String nameConfigProperties) {
        this.nameConfigProperties = nameConfigProperties;
    }

    public void loadConfig(){
        parseConfig();
    }

    private void parseConfig() {
        Properties prop = getPropertieFile();
        String gamemode = prop.getProperty("gamemode");
        String stringRows = prop.getProperty("rows");
        String stringCols = prop.getProperty("cols");
        String stringNameInitialConfig = prop.getProperty("nameInitialConfig");
        String stringAdvanceMode = prop.getProperty("advanceMode");
        String stringOutput = prop.getProperty("output");

        this.gamemode = gamemode;
        this.rows = Integer.parseInt(stringRows);
        this.cols = Integer.parseInt(stringCols);
        this.initialConfig = getInitialConfig(stringNameInitialConfig);
        this.advanceMode = stringAdvanceMode;
        this.output = stringOutput;
    }

    private Properties getPropertieFile() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(nameConfigProperties)) {
            if (input == null) {
                throw new IOException("File not found: " + nameConfigProperties);
            }

            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file:" + e.getMessage());
        }
    }

    private String getInitialConfig(String nameInitialConfigTxt) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(nameInitialConfigTxt)) {
            if (input == null) {
                throw new IOException("File not found: " + nameInitialConfigTxt);
            }
            return new String(input.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error reading initial config file: " + e.getMessage());
        }
    }
}
