package fr.lusseau.claude.infrastructure.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.utils
 * @date 18/08/2022
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonDatatypeJacksonProducer implements ContextResolver<ObjectMapper> {

    private final ObjectMapper json;

    public JacksonDatatypeJacksonProducer() {
        this.json = JsonMapper.builder()
                .findAndAddModules()
                .build();
    }

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
        return json;
    }
}

