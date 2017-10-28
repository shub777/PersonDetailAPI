package com.example.jersey.Resource;

import com.example.jersey.Model.StorePersonDetailModel;
import com.example.jersey.Service.StorePersonDetailService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/store")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StorePersonDetailResource {

    StorePersonDetailService storePersonDetailService = new StorePersonDetailService();

    @GET
    public List<StorePersonDetailModel> ShowPersonDetail() throws Exception {
        return storePersonDetailService.getPersonDetail();
    }

    @POST
    public Response addPersonDetail(StorePersonDetailModel storePersonDetailModel, @Context UriInfo uriInfo) throws Exception {
        StorePersonDetailModel newStorePersonDetailModel = storePersonDetailService.addPersonDetail(storePersonDetailModel);
        String newId = String.valueOf(storePersonDetailModel.getId());
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(newId)
                .build();
        return Response.created(uri).entity(newStorePersonDetailModel).build();
    }

    @DELETE
    @Path("/{id}")
    public void deletePersonDetailFromId(@PathParam("id")long id) throws Exception {
        storePersonDetailService.deletePersonDetailFromId(id);
    }

    @PUT
    @Path("/{id}")
    public StorePersonDetailModel updatePersonDetailFromId(StorePersonDetailModel storePersonDetailModel,@PathParam("id") long id) throws Exception{
        return storePersonDetailService.updatePersonDetailFromId(storePersonDetailModel,id);
    }

    @GET
    @Path("/{id}")
    public StorePersonDetailModel getPersonDetailFromId(@PathParam("id") long id) throws Exception{
        return storePersonDetailService.getPersonDetailFromId(id);
    }
}