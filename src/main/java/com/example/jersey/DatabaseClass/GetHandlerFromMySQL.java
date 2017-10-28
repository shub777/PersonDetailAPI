package com.example.jersey.DatabaseClass;

import com.example.jersey.Model.StorePersonDetailModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetHandlerFromMySQL {
    public ArrayList<StorePersonDetailModel> getAllDetails(Connection connection) throws Exception {

        ArrayList<StorePersonDetailModel> personList = new ArrayList<StorePersonDetailModel>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from personDetail");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            StorePersonDetailModel storePersonDetailModel = new StorePersonDetailModel();
            storePersonDetailModel.setId(resultSet.getLong(1));
            storePersonDetailModel.setFirstName(resultSet.getString(2));
            storePersonDetailModel.setLastName(resultSet.getString(3));
            storePersonDetailModel.setAddress(resultSet.getString(4));
            storePersonDetailModel.setContactNumber(resultSet.getString(5));
            storePersonDetailModel.setGender(resultSet.getString(6));
            storePersonDetailModel.setPincode(resultSet.getString(7));
            personList.add(storePersonDetailModel);
        }
        return personList;

    }

    public StorePersonDetailModel postAllDetails(Connection connection, StorePersonDetailModel storePersonDetailModel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into personDetail " +
                "(id,firstname,lastname,address,contactnumber,gender,pincode) " + "values (" + storePersonDetailModel.getId() + ",'" +
        storePersonDetailModel.getFirstName() + "','" + storePersonDetailModel.getLastName() + "','" + storePersonDetailModel.getAddress() + "','" +
        storePersonDetailModel.getContactNumber() + "','" + storePersonDetailModel.getGender() + "','" + storePersonDetailModel.getPincode() + "');");
        preparedStatement.executeUpdate();
        return storePersonDetailModel;
    }

    public void deletePersonDetailFromId(Connection connection,long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from personDetail where id = " + id);
        preparedStatement.executeUpdate();
    }

    public StorePersonDetailModel updatePersonDetailFromId(Connection connection, long id, StorePersonDetailModel storePersonDetailModel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE personDetail set id = " + id + ", firstname = '" +
                storePersonDetailModel.getFirstName() + "', lastname = '" + storePersonDetailModel.getLastName() + "', address = '" + storePersonDetailModel.getAddress() +
                "', contactnumber = '" + storePersonDetailModel.getContactNumber() + "', gender = '" + storePersonDetailModel.getGender() + "', pincode = '" +
                storePersonDetailModel.getPincode() + "' where id = " + id + ";");
        preparedStatement.executeUpdate();
        return getPersonDetailFromId(connection, id);
    }

    public StorePersonDetailModel getPersonDetailFromId(Connection connection,long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from personDetail where id = " + id);
        ResultSet resultSet = ps.executeQuery();
        StorePersonDetailModel model = new StorePersonDetailModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong(1));
            model.setFirstName(resultSet.getString(2));
            model.setLastName(resultSet.getString(3));
            model.setAddress(resultSet.getString(4));
            model.setContactNumber(resultSet.getString(5));
            model.setGender(resultSet.getString(6));
            model.setPincode(resultSet.getString(7));
        }
        return model;
    }
}
