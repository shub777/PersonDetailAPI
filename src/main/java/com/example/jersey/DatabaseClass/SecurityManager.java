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
}
