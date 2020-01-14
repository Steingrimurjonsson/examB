/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dto.Item_dto;
import dto.Menu_dto;
import dto.Recipe_dto;
import dto.Storage_dto;
import entities.User;
import facades.ApiFacade;
import facades.RecipeFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 *
 * @author stein
 */
@Path("recipes")
public class RecipeResource {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    private static final RecipeFacade facade = RecipeFacade.getRecipeFacade(emf);
    @Context
    private UriInfo context;
    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("pop")
    public String popDB() {
        facade.popDB();
        return "{\"Message\":\"SUCCESS\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getstorage")
    //@RolesAllowed("admin")
    public List<Storage_dto> getStorage() {
        return facade.getStorage();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allmenues")
    //@RolesAllowed({"admin", "user"})
    public List<Menu_dto> allMenues() {
        return facade.getAllMenues();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addweek/")
   // @RolesAllowed({"admin", "user"})
    public Menu_dto addTheWeek(Menu_dto w) {
        return facade.addTheWeek(w);
    }

    @GET
    @Path("getrecipe")
    @Produces({MediaType.APPLICATION_JSON})
    //@RolesAllowed({"admin", "user"})
    public List<Recipe_dto> getAllRecipes() {
        return facade.getRecipes();
    }

    @POST
    @Path("additem/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    //@RolesAllowed("admin")
    public Item_dto addItem(Item_dto item) {
        return facade.addToItems(item);
    }

    @GET
    @Path("allitems")
    @Produces({MediaType.APPLICATION_JSON})
   // @RolesAllowed("admin")
    public List<Item_dto> getItems() {
        return facade.getItems();
    }

    @GET
    @Path("addstorage/{itemid}/{amount}")
    @Produces({MediaType.APPLICATION_JSON})
  //  @RolesAllowed("admin")
    public Storage_dto addStorage(@PathParam("itemid") Long itemid, @PathParam("amount") int amount) {
        return facade.updateStorage(itemid, amount);
    }
}
