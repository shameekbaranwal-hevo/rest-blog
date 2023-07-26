package hevo;

import hevo.health.TemplateHealthCheck;
import hevo.resources.HelloWorldResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class BlogApplication extends Application<BlogConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BlogApplication().run(args);
    }

    @Override
    public String getName() {
        return "Blog";
    }

    @Override
    public void initialize(final Bootstrap<BlogConfiguration> bootstrap) {

    }

    @Override
    public void run(final BlogConfiguration configuration,
                    final Environment environment) {
        HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
