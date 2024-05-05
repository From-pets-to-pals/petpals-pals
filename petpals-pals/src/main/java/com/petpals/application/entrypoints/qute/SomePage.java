package com.petpals.application.entrypoints.qute;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/some-page")
public class SomePage {
    
    Template page;
    
    public SomePage(Template page) {
        this.page = page;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get(@QueryParam("name") String name) {
        return page.data("name", name);
    }
}
