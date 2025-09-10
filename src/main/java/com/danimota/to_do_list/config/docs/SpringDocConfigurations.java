package com.danimota.to_do_list.config.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do-List")
                        .description("API para gerenciar tarefas (CRUD)")
                        .contact(new Contact()
                                .name("Daniela Mota")
                                .email("danielamedeiromota@hotmail.com")
                                .url("https://github.com/Danimmota/to-do-list"))
                );
    }

}
