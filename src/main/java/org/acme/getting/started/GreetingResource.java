package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {
    private static final Logger logger = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    GreetingService service;

    @Inject
    Config config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        logger.error("greeting");
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.error("execute hello");
        logger.error(config.param1());
        return "hello";
    }
}