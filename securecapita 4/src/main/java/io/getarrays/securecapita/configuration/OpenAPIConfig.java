package io.getarrays.securecapita.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
/**
 * @author Kumar.Kunal
 * @project securecapita7
 */
@Configuration
public class OpenAPIConfig {
    @Value("${kunal.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server swaggerDevServer = new Server();
        swaggerDevServer.setUrl(devUrl);
        swaggerDevServer.setDescription("Invoices and Customers Server URL In Development Environment");

        Contact swaggerDevContact = new Contact();
        swaggerDevContact.setEmail("kkunal2005@gmail.com");
        swaggerDevContact.setName("Kumar Kunal");
        swaggerDevContact.setUrl("https://www.kunal.com");

        License license = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info swaggerDevInfo = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(swaggerDevContact)
                .description("Application To Manage Invoices and Customers APIs.").termsOfService("https://www.kunal.com/terms")
                .license(license);

        return new OpenAPI().info(swaggerDevInfo).servers(List.of(swaggerDevServer));
    }
}
