package rs.raf.ZavrsniProjekat.resources;

import rs.raf.ZavrsniProjekat.entities.Category;
import rs.raf.ZavrsniProjekat.services.CategoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryResource {

    @Inject
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allCategory() { return Response.ok(this.categoryService.allCategory()).build(); }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Category addCategory(@Valid Category category) { return this.categoryService.addCategory(category); }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateCategory(@Valid Category category, @PathParam("id") Integer id) {
        this.categoryService.updateCategory(category, id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCategory(@PathParam("id") Integer id){
        this.categoryService.deleteCategory(id);
    }
}
