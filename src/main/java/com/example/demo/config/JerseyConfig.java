package com.example.demo.config;

import com.example.demo.resources.PersonResource;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 * Created by chai on 17/8/1.
 */

//@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {

       // register(JacksonFeature.class);

       register(PersonResource.class);


    }
}

