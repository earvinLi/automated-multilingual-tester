package configreader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropReader {
  private Properties properties;
  private FileInputStream fileInputStream;

  public Properties initLanguageProperties(String language) {
    properties = new Properties();

    try {
      switch (language.toLowerCase()){
        case "english" -> fileInputStream = new FileInputStream("./src/main/resources/lang.english.properties");
        case "french" -> fileInputStream = new FileInputStream("./src/main/resources/lang.french.properties");
        case "russian" -> fileInputStream = new FileInputStream("./src/main/resources/lang.russian.properties");
        default -> System.out.println("language not found : " + language);
      }
      properties.load(fileInputStream);
    } catch(Exception exception) {
      System.out.println(language + " : properties file not found");
    }


    return properties;
  }
}
