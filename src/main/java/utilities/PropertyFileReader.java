package utilities;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.Properties;

public class PropertyFileReader {

  private static final String PROPERTY_FILE_PATH = "./default.properties";
  private static final Logger LOGGER = Logger.getLogger(PropertyFileReader.class);
  private static Properties properties;

  public Properties getProperties() {
    return properties;
  }

  public PropertyFileReader() {
    try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException ex) {
        LOGGER.error(ex);
      }
    } catch (FileNotFoundException ex) {
      LOGGER.error(ex);
      throw new RuntimeException("default.properties not found at " + PROPERTY_FILE_PATH);
    } catch (IOException e) {
      LOGGER.error(e);
    } catch (RuntimeException e) {
      LOGGER.error(e);
      throw new RuntimeException("Error in reading property file!");
    }
  }

  public static void writeToPropertyFile(String propertyName, String propertyValue) throws ConfigurationException {
    PropertiesConfiguration config = new PropertiesConfiguration(PROPERTY_FILE_PATH);
    config.setProperty(propertyName, propertyValue);
    config.save();
  }

  //This is to write on to a given property file
  public void writeToPropertyFile(String fileName, String propertyName, String propertyValue) throws ConfigurationException {
    PropertiesConfiguration config = new PropertiesConfiguration(fileName);
    config.setProperty(propertyName, propertyValue);
    config.save();
  }

  public static String readProperty(String propertyName) {
    String propertyValue = properties.getProperty(propertyName);
    if (propertyValue != null) {
      return propertyValue;
    } else {
      throw new RuntimeException("Given property name is not specified in the default.properties file");
    }
  }

  //This will read the data of the property file
  private Properties getData(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName + ".properties").getFile());
    FileInputStream fileInput = null;

    try {
      fileInput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      LOGGER.error(e);
    }
    Properties prop = new Properties();

    try {
      prop.load(fileInput);
    } catch (IOException e) {
      LOGGER.error(e);
    }
    return prop;
  }

  //This will return the value of the given files key assigned
  public String getProperty(String fileName, String key) {
    return getData(fileName).getProperty(key);
  }

  //This will read the language file as for the properties
  public String getProperty(String key){
    readPropertyFile();
    String languageProperty = PropertyFileReader.readProperty("testingLanguage");

    switch (languageProperty){
      case "English":
        return getProperty("eng",key);
      case "Nederlands":
        return getProperty("nl",key);
      default:
        return "Language file is NOT found.";
    }
  }
  public void readPropertyFile(){
    try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException ex) {
        LOGGER.error(ex);
      }
    } catch (FileNotFoundException ex) {
      LOGGER.error(ex);
      throw new RuntimeException("default.properties not found at " + PROPERTY_FILE_PATH);
    } catch (IOException e) {
      LOGGER.error(e);
    } catch (RuntimeException e) {
      LOGGER.error(e);
      throw new RuntimeException("Error in reading property file!");
    }
  }

}
