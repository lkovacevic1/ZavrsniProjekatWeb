package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.services.AdminService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AdminResource {

    @Inject
    private AdminService adminService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allUsers(@CookieParam("myCookie") Cookie cookie){
        if(cookie == null)
            return Response.status(400).build();
        else if(cookie.getValue().equals("admin"))
            return Response.ok(this.adminService.allUsers()).build();
        else
            return Response.status(401).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid User user, @CookieParam("myCookie") Cookie cookie) {
        if (cookie == null)
            return Response.status(400).build();
        else if (cookie.getValue().equals("admin"))
            return Response.ok(this.adminService.addUser(user)).build();
        else
            return Response.status(401).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@Valid User user, @PathParam("id") Integer id, @CookieParam("myCookie") Cookie cookie){
        if (cookie == null)
            return Response.status(400).build();
        else if (cookie.getValue().equals("admin"))
            return Response.ok(this.adminService.updateUser(user, id)).build();
        else
            return Response.status(401).build();
    }
    @PUT
    @Path("/status/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeUserStatus(@Valid User user, @PathParam("id") Integer id, @CookieParam("myCookie") Cookie cookie){
        if (cookie == null)
            return Response.status(400).build();
        else if (cookie.getValue().equals("admin"))
            return Response.ok(this.adminService.changeUserStatus(user, id)).build();
        else
            return Response.status(401).build();
    }
}
