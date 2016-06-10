package io.realm;


import android.util.JsonReader;
import io.realm.exceptions.RealmException;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.Models.UserDetailModel;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final List<Class<? extends RealmObject>> MODEL_CLASSES;
    static {
        List<Class<? extends RealmObject>> modelClasses = new ArrayList<Class<? extends RealmObject>>();
        modelClasses.add(AppointmentBookingModel.class);
        modelClasses.add(UserDetailModel.class);
        MODEL_CLASSES = Collections.unmodifiableList(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return AppointmentBookingModelRealmProxy.initTable(transaction);
        } else if (clazz.equals(UserDetailModel.class)) {
            return UserDetailModelRealmProxy.initTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void validateTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            AppointmentBookingModelRealmProxy.validateTable(transaction);
        } else if (clazz.equals(UserDetailModel.class)) {
            UserDetailModelRealmProxy.validateTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return AppointmentBookingModelRealmProxy.getFieldNames();
        } else if (clazz.equals(UserDetailModel.class)) {
            return UserDetailModelRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return AppointmentBookingModelRealmProxy.getTableName();
        } else if (clazz.equals(UserDetailModel.class)) {
            return UserDetailModelRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E newInstance(Class<E> clazz) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return clazz.cast(new AppointmentBookingModelRealmProxy());
        } else if (clazz.equals(UserDetailModel.class)) {
            return clazz.cast(new UserDetailModelRealmProxy());
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<Class<? extends RealmObject>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public Map<String, Long> getColumnIndices(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return AppointmentBookingModelRealmProxy.getColumnIndices();
        } else if (clazz.equals(UserDetailModel.class)) {
            return UserDetailModelRealmProxy.getColumnIndices();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmObject, RealmObjectProxy> cache) {
        // This cast is correct because obj is either 
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(AppointmentBookingModel.class)) {
            return clazz.cast(AppointmentBookingModelRealmProxy.copyOrUpdate(realm, (AppointmentBookingModel) obj, update, cache));
        } else if (clazz.equals(UserDetailModel.class)) {
            return clazz.cast(UserDetailModelRealmProxy.copyOrUpdate(realm, (UserDetailModel) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return clazz.cast(AppointmentBookingModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(UserDetailModel.class)) {
            return clazz.cast(UserDetailModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(AppointmentBookingModel.class)) {
            return clazz.cast(AppointmentBookingModelRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(UserDetailModel.class)) {
            return clazz.cast(UserDetailModelRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}