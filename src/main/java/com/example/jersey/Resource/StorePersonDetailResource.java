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
public class StorePersonDetailResource {

    StorePersonDetailService storePersonDetailService = new StorePersonDetailService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
}