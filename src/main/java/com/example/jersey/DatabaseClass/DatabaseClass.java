package com.example.jersey.DatabaseClass;

import com.example.jersey.Model.StorePersonDetailModel;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long,StorePersonDetailModel> datas = new HashMap<Long, StorePersonDetailModel>();

    public static Map<Long, StorePersonDetailModel> getDatas() {
        return datas;
    }
}
