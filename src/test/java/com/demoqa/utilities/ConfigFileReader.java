package com.demoqa.utilities;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigFileReader {
    private  Properties properties;
    private final String propertyFiePath = System.getProperty("user.dir")+"/Configs/config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFiePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser()
    {
        String browser = properties.getProperty("browser");
        return browser.toLowerCase();
    }

    public String getDriverPath()
    {

        switch (getBrowser())
        {

            case "firefox":
            {
                String firefoxDriverPath = properties.getProperty("firefoxDriverPath");
                return firefoxDriverPath;
            }
            default: {
                String chromeDriverPath = properties.getProperty("chromeDriverPath");
                return chromeDriverPath;
            }

        }
    }
    public String getApplicationUrl()
    {
     return properties.getProperty("url");

    }
    public String getUserName()
    {
        return properties.getProperty("username");

    }
    public String getPassword()
    {
        return properties.getProperty("password");
    }


}

