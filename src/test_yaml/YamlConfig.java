package test_yaml;

import java.util.Map;

public class YamlConfig {

    Map<String, ServiceConfig> applications;

    public Map<String, ServiceConfig> getApplications() {
        return applications;
    }

    public void setApplications(Map<String, ServiceConfig> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "applications=" + applications +
                '}';
    }
}