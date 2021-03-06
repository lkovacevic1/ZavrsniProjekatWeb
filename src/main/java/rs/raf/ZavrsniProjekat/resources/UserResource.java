package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allUserTipes() { return Response.ok(this.userService.allUserTipes()).build(); }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(User findUser){
        User user = this.userService.findUser(findUser);
        NewCookie cookie;
        if(user.getIdTipKorisnika() == 1)
            cookie = new NewCookie("myCookie", "admin", "/api", "localhost", "", -1, false);
        else
            cookie = new NewCookie("myCookie", "user", "/api", "localhost", "", -1, false);

        return Response.ok(cookie).build();
    }
}
