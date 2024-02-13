package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private ConfigReader(){
        // Singleton
    }

    static {
        try{
            String path = "src/main/resources/application.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }
    public static String getValue(String key){
        return properties.getProperty(key).trim();

    }
    public static void main(String[] args) {
        System.out.println(getValue("browser"));
    }
}