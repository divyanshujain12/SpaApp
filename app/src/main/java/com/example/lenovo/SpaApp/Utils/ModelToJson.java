package com.example.lenovo.SpaApp.Utils;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        Class subClass = valuesObject.getClass().getSuperclass();
        Field[] fields = subClass.getDeclaredFields();
        Method[] methods = subClass.getDeclaredMethods();
        subClass.cast(valuesObject);
        for (Method method : methods) {
            try {
                for (Field field:fields){
                    field.setAccessible(true);
                    String name  = field.getName();
                    Object object = field.get(valuesObject);

                }

                method.setAccessible(true);
                if (method.getName().contains("get")) {

                    Object object = method.invoke(valuesObject);
                    //   json.put(name, object);
                }

            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return json;
    }


}
