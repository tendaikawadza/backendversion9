/**
 * kunal
 * parametrejdbc
 * com.org.kunal.parametrejdbc.config
 */
package io.getarrays.securecapita.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * kunal
 * parametrejdbc
 * 2023
 */
@Configuration
public class MapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
