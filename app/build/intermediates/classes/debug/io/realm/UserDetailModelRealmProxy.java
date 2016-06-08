package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.lenovo.SpaApp.Models.UserDetailModel;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailModelRealmProxy extends UserDetailModel
    implements RealmObjectProxy {

    private static long INDEX_NAME;
    private static long INDEX_EMAIL;
    private static long INDEX_PHONENUMBER;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("email");
        fieldNames.add("phonenumber");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_NAME);
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_NAME);
            return;
        }
        row.setString(INDEX_NAME, (String) value);
    }

    @Override
    public String getEmail() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_EMAIL);
    }

    @Override
    public void setEmail(String value) {
        realm.checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field email to null.");
        }
        row.setString(INDEX_EMAIL, (String) value);
    }

    @Override
    public String getPhonenumber() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_PHONENUMBER);
    }

    @Override
    public void setPhonenumber(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_PHONENUMBER);
            return;
        }
        row.setString(INDEX_PHONENUMBER, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_UserDetailModel")) {
            Table table = transaction.getTable("class_UserDetailModel");
            table.addColumn(ColumnType.STRING, "name", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "email", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.STRING, "phonenumber", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("email"));
            table.setPrimaryKey("email");
            return table;
        }
        return transaction.getTable("class_UserDetailModel");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_UserDetailModel")) {
            Table table = transaction.getTable("class_UserDetailModel");
            if (table.getColumnCount() != 3) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 3 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type UserDetailModel");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_EMAIL = table.getColumnIndex("email");
            INDEX_PHONENUMBER = table.getColumnIndex("phonenumber");

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_NAME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (table.isColumnNullable(INDEX_EMAIL)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'email' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'email' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("email")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'email' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("email"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'email' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("phonenumber")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'phonenumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("phonenumber") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'phonenumber' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_PHONENUMBER)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'phonenumber' is required. Either set @Required to field 'phonenumber' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The UserDetailModel class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_UserDetailModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static UserDetailModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        UserDetailModel obj = null;
        if (update) {
            Table table = realm.getTable(UserDetailModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("email")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("email"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new UserDetailModelRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getUncheckedRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(UserDetailModel.class);
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName(null);
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                obj.setEmail(null);
            } else {
                obj.setEmail((String) json.getString("email"));
            }
        }
        if (json.has("phonenumber")) {
            if (json.isNull("phonenumber")) {
                obj.setPhonenumber(null);
            } else {
                obj.setPhonenumber((String) json.getString("phonenumber"));
            }
        }
        return obj;
    }

    public static UserDetailModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        UserDetailModel obj = realm.createObject(UserDetailModel.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setName(null);
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setEmail(null);
                } else {
                    obj.setEmail((String) reader.nextString());
                }
            } else if (name.equals("phonenumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setPhonenumber(null);
                } else {
                    obj.setPhonenumber((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static UserDetailModel copyOrUpdate(Realm realm, UserDetailModel object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        UserDetailModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(UserDetailModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (object.getEmail() == null) {
                throw new IllegalArgumentException("Primary key value must not be null.");
            }
            long rowIndex = table.findFirstString(pkColumnIndex, object.getEmail());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new UserDetailModelRealmProxy();
                realmObject.realm = realm;
                realmObject.row = table.getUncheckedRow(rowIndex);
                cache.put(object, (RealmObjectProxy) realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static UserDetailModel copy(Realm realm, UserDetailModel newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        UserDetailModel realmObject = realm.createObject(UserDetailModel.class, newObject.getEmail());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setName(newObject.getName());
        realmObject.setEmail(newObject.getEmail());
        realmObject.setPhonenumber(newObject.getPhonenumber());
        return realmObject;
    }

    static UserDetailModel update(Realm realm, UserDetailModel realmObject, UserDetailModel newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setName(newObject.getName());
        realmObject.setPhonenumber(newObject.getPhonenumber());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserDetailModel = [");
        stringBuilder.append("{name:");
        stringBuilder.append(getName() != null ? getName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(getEmail());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phonenumber:");
        stringBuilder.append(getPhonenumber() != null ? getPhonenumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailModelRealmProxy aUserDetailModel = (UserDetailModelRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aUserDetailModel.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aUserDetailModel.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aUserDetailModel.row.getIndex()) return false;

        return true;
    }

}
