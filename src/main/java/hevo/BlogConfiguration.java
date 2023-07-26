package hevo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import jakarta.validation.constraints.NotEmpty;

public class BlogConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName;
    

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
