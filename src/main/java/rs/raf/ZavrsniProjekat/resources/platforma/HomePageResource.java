package rs.raf.ZavrsniProjekat.resources.platforma;

import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.services.platformaService.HomePageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/homePage")
public class HomePageResource {

    @Inject
    private HomePageService homePageService;

    @GET
    @Path("/latestNews")
    @Produces(MediaType.APPLICATION_JSON)
    public Response latestNews(){
        return Response.ok(this.homePageService.latestNews()).build();
    }

    @GET
    @Path("/mostPopular")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostPopular(){ return Response.ok(this.homePageService.mostPopular()).build(); }

    @GET
    @Path("/{kategorija}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response kategoryNews(@PathParam("kategorija") Integer kategorija){ return Response.ok(this.homePageService.kategoryNews(kategorija)).build(); }

}
