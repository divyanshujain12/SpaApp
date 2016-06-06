package com.example.lenovo.SpaApp.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by divyanshu.jain on 6/6/2016.
 */
public class ModelToJson {
    private static ModelToJson ourInstance = new ModelToJson();

    public static ModelToJson getInstance() {
        return ourInstance;
    }

    private ModelToJson() {
    }

    public JSONObject createJSONFromModelClass(Object valuesObject) {
        JSONObject json = new JSONObject();
        Class subClass = valuesObject.getClass();
        Field[] fields = subClass.getFields();
        for (Field field : fields) {
            try {
                String name = field.getName();
                Object object = field.get(name);
                json.put(name, object);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json;
    }


}
