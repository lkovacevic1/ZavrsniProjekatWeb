package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.services.NewsService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

@Path("/news")
public class NewsResource {

    @Inject
    private NewsService newsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allNews() { return Response.ok(this.newsService.allNews()).build(); }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNews(@Valid News news, @CookieParam("myCookie") Cookie cookie) {
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin"))
            return Response.ok(this.newsService.addNews(news)).build();
        else
            return Response.status(401).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNews(@PathParam("id") Integer id, @CookieParam("myCookie")Cookie cookie){
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin"))
            return Response.ok(this.newsService.deleteNews(id)).build();
        else
            return Response.status(401).build();
    }
}
