package org.konzerra.springex6.config.yml;

import org.jetbrains.annotations.Nullable;
import org.konzerra.springex6.security.SecurityProperties;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class YamlConfigLoader {
    private static final String PROD_PATH = "/etc/myapp/local.env.yml";
    private static final String DEV_PATH = "local.env.yml";

    public static @Nullable SecurityProperties getSecurityProperties() {
        Yaml yaml = new Yaml();
        String filePath = determineConfigPath();

        try (InputStream inputStream = new FileInputStream(filePath)) {
            Map<String, Object> yamlProps = yaml.load(inputStream);

            if (yamlProps != null) {
                Map<String, Object> securityProps = (Map<String, Object>) yamlProps.get("security");

                if (securityProps != null) {
                    SecurityProperties securityProperties = new SecurityProperties();
                    // Extract the key value and set it in the SecurityProperties object
                    String key = (String) securityProps.get("key");
                    Object durationObj = securityProps.get("duration");
                    Long duration;

                    if (durationObj instanceof Integer) {
                        duration = ((Integer) durationObj).longValue(); // Convert Integer to Long
                    } else if (durationObj instanceof Long) {
                        duration = (Long) durationObj; // No conversion needed
                    } else {
                        throw new IllegalArgumentException("Invalid type for duration: " + durationObj.getClass().getName());
                    }

                    securityProperties.setDurationMillis(duration);
                    securityProperties.setKey(key);
                    securityProperties.setDurationMillis(duration);

                    return securityProperties; // Return the populated SecurityProperties object
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if unable to load or parse the YAML
    }

    private static String determineConfigPath() {
        // First, try to access the production path
        if (Files.exists(Paths.get(PROD_PATH))) {
            return PROD_PATH;
        } else { // Fallback to the development path
            return DEV_PATH;
        }
    }
}

