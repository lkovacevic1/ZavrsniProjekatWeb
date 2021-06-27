package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.services.AdminService;

import javax.inject.Inject;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
