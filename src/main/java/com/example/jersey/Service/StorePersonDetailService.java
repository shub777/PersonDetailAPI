package com.example.jersey.Service;

import com.example.jersey.DatabaseClass.DatabaseClass;
import com.example.jersey.DatabaseClass.SecurityManager;
import com.example.jersey.Model.StorePersonDetailModel;

import java.util.*;

public class StorePersonDetailService {

    private Map<Long,StorePersonDetailModel> storePersonDetailModelMap = DatabaseClass.getDatas();

    public StorePersonDetailService(){
    }

    public List<StorePersonDetailModel> getPersonDetail() throws Exception {
        ArrayList<StorePersonDetailModel> personList = null;
        ArrayList<StorePersonDetailModel> personAllList = new ArrayList<StorePersonDetailModel>();
        SecurityManager securityManager = new SecurityManager();
        personList = securityManager.getAllPersonDetail();
        for (StorePersonDetailModel storePersonDetailModel : personList){
            personAllList.add(storePersonDetailModel);
        }
        return personAllList;
    }

    public StorePersonDetailModel addPersonDetail(StorePersonDetailModel storePersonDetailModel) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        securityManager.postAllPersonDetail(storePersonDetailModel);
        return storePersonDetailModel;
    }

    public void deletePersonDetailFromId(long id) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        securityManager.deletePersonDetailFromId(id);
    }

    public StorePersonDetailModel updatePersonDetailFromId(StorePersonDetailModel storePersonDetailModel, long id) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        return securityManager.updatePersonDetalFromId(storePersonDetailModel,id);
    }

    public StorePersonDetailModel getPersonDetailFromId(long id) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        return securityManager.getPersonDetailFromId(id);
    }
}
