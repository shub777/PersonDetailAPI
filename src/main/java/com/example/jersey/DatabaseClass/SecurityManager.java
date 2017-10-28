package com.example.jersey.DatabaseClass;

import com.example.jersey.Model.StorePersonDetailModel;

import java.sql.Connection;
import java.util.ArrayList;

public class SecurityManager {

    public ArrayList<StorePersonDetailModel> getAllPersonDetail() throws Exception{
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        GetHandlerFromMySQL getHandlerFromMySQL = new GetHandlerFromMySQL();
        return getHandlerFromMySQL.getAllDetails(connection);
    }

    public StorePersonDetailModel postAllPersonDetail(StorePersonDetailModel storePersonDetailModel) throws Exception{
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        GetHandlerFromMySQL getHandlerFromMySQL = new GetHandlerFromMySQL();
        return getHandlerFromMySQL.postAllDetails(connection,storePersonDetailModel);
    }

    public void deletePersonDetailFromId(long id) throws Exception {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        GetHandlerFromMySQL getHandlerFromMySQL = new GetHandlerFromMySQL();
        getHandlerFromMySQL.deletePersonDetailFromId(connection,id);
    }

    public StorePersonDetailModel updatePersonDetalFromId(StorePersonDetailModel storePersonDetailModel, long id) throws Exception {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        GetHandlerFromMySQL getHandlerFromMySQL = new GetHandlerFromMySQL();
        return getHandlerFromMySQL.updatePersonDetailFromId(connection,id,storePersonDetailModel);
    }

    public StorePersonDetailModel getPersonDetailFromId(long id) throws Exception {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        GetHandlerFromMySQL getHandlerFromMySQL = new GetHandlerFromMySQL();
        return getHandlerFromMySQL.getPersonDetailFromId(connection,id);
    }
}
