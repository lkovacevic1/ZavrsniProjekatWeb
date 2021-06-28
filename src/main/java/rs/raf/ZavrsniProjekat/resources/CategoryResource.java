package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.entities.Category;
import rs.raf.ZavrsniProjekat.services.CategoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryResource {

    @Inject
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allCategory(@CookieParam("myCookie") Cookie cookie) {
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin") || cookie.getValue().equals("user"))
            return Response.ok(this.categoryService.allCategory()).build();
        else
            return Response.status(401).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(@Valid Category category, @CookieParam("myCookie") Cookie cookie) {
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin") || cookie.getValue().equals("user"))
            return Response.ok(this.categoryService.addCategory(category)).build();
        else
            return Response.status(401).build();

    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(@Valid Category category, @PathParam("id") Integer id, @CookieParam("myCookie") Cookie cookie) {
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin") || cookie.getValue().equals("user"))
            return Response.ok(this.categoryService.updateCategory(category, id)).build();
        else
            return Response.status(401).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("id") Integer id, @CookieParam("myCookie") Cookie cookie){
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin") || cookie.getValue().equals("user"))
            return Response.ok(this.categoryService.deleteCategory(id)).build();
        else
            return Response.status(401).build();
    }
}
