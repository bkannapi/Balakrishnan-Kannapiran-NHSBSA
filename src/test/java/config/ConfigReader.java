package config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigReader {

    private static JSONObject envConfig;

    static {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/environment.json");
            if (input == null) {
                throw new RuntimeException("environment.json not found in config folder under resources.");
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(input));

            String environment = (String) jsonObject.get("env"); // e.g., "qa"
            envConfig = (JSONObject) jsonObject.get(environment); // get the qa block

            if (envConfig == null) {
                throw new RuntimeException("Environment block '" + environment + "' not found in JSON.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load environment.json config.", e);
        }
    }

    public static String get(String key) {
        return (String) envConfig.get(key);
    }
}
