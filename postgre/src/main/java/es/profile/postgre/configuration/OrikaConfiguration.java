package es.profile.postgre.configuration;

import es.profile.postgre.mapper.ObjectMapper;
import es.profile.postgre.mapper.OrikaObjectMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Configuration
public class OrikaConfiguration {

    @Bean("orikaMapper")
    @Primary
    public ObjectMapper orikaObjectMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return new OrikaObjectMapper(Optional.of(mapperFactory));
    }
}
