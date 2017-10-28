package com.example.jersey.Resource;

import com.example.jersey.Model.StorePersonDetailModel;
import com.example.jersey.Service.StorePersonDetailService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    public void deletePersonDetailFromId(@PathParam("id") long id) throws Exception {
        storePersonDetailService.deletePersonDetailFromId(id);
    }

    @PUT
    @Path("/{id}")
    public StorePersonDetailModel updatePersonDetailFromId(StorePersonDetailModel storePersonDetailModel, @PathParam("id") long id) throws Exception {
        return storePersonDetailService.updatePersonDetailFromId(storePersonDetailModel, id);
    }

    @GET
    @Path("/{id}")
    public StorePersonDetailModel getPersonDetailFromId(@PathParam("id") long id) throws Exception {
        return storePersonDetailService.getPersonDetailFromId(id);
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void StorePersonDocumentUpload() {
//        String FOLDER_PATH = "C:\\ Users\\sbinf\\IdeaProjects\\FormAPI\\Document\\";
//        String fileLocation = FOLDER_PATH + formDataContentDisposition.getFileName();
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileLocation));
//            int read = 0;
//            byte[] bytes = new byte[1024];
//            while ((read = inputStream.read(bytes)) != -1) {
//                fileOutputStream.write(bytes, 0, read);
//            }
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        } finally {
//            String output = "File uploaded successfully to file location : " + fileLocation;
//            return Response.status(200).entity(output).build();
//        }
    }
}