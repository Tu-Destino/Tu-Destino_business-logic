package com.riwi.Tu_Destino.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para manejar lugares y publicaciones de una pagina de turismo", version = "1.0", description = "Documentación api de reservacion de citas"))
public class OpenApiConfig  {
}
