package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
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

public class AppointmentBookingModelRealmProxy extends AppointmentBookingModel
    implements RealmObjectProxy {

    private static long INDEX_CATEGORY_ID;
    private static long INDEX_PRODUCT_ID;
    private static long INDEX_CATEGORY_NAME;
    private static long INDEX_PRODUCT_NAME;
    private static long INDEX_NAME;
    private static long INDEX_NUMBER;
    private static long INDEX_EMAIL_ID;
    private static long INDEX_ADDRESS;
    private static long INDEX_DATE;
    private static long INDEX_TIME;
    private static long INDEX_ADDITIONAL_NOTES;
    private static long INDEX_DURATION;
    private static long INDEX_COST;
    private static long INDEX_CITY_ID;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("category_id");
        fieldNames.add("product_id");
        fieldNames.add("category_name");
        fieldNames.add("product_name");
        fieldNames.add("name");
        fieldNames.add("number");
        fieldNames.add("email_id");
        fieldNames.add("address");
        fieldNames.add("date");
        fieldNames.add("time");
        fieldNames.add("additional_notes");
        fieldNames.add("duration");
        fieldNames.add("cost");
        fieldNames.add("city_id");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public String getCategory_id() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CATEGORY_ID);
    }

    @Override
    public void setCategory_id(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_CATEGORY_ID);
            return;
        }
        row.setString(INDEX_CATEGORY_ID, (String) value);
    }

    @Override
    public String getProduct_id() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_PRODUCT_ID);
    }

    @Override
    public void setProduct_id(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_PRODUCT_ID);
            return;
        }
        row.setString(INDEX_PRODUCT_ID, (String) value);
    }

    @Override
    public String getCategory_name() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CATEGORY_NAME);
    }

    @Override
    public void setCategory_name(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_CATEGORY_NAME);
            return;
        }
        row.setString(INDEX_CATEGORY_NAME, (String) value);
    }

    @Override
    public String getProduct_name() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_PRODUCT_NAME);
    }

    @Override
    public void setProduct_name(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_PRODUCT_NAME);
            return;
        }
        row.setString(INDEX_PRODUCT_NAME, (String) value);
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
    public String getNumber() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_NUMBER);
    }

    @Override
    public void setNumber(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_NUMBER);
            return;
        }
        row.setString(INDEX_NUMBER, (String) value);
    }

    @Override
    public String getEmail_id() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_EMAIL_ID);
    }

    @Override
    public void setEmail_id(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_EMAIL_ID);
            return;
        }
        row.setString(INDEX_EMAIL_ID, (String) value);
    }

    @Override
    public String getAddress() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ADDRESS);
    }

    @Override
    public void setAddress(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_ADDRESS);
            return;
        }
        row.setString(INDEX_ADDRESS, (String) value);
    }

    @Override
    public String getDate() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DATE);
    }

    @Override
    public void setDate(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_DATE);
            return;
        }
        row.setString(INDEX_DATE, (String) value);
    }

    @Override
    public String getTime() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_TIME);
    }

    @Override
    public void setTime(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_TIME);
            return;
        }
        row.setString(INDEX_TIME, (String) value);
    }

    @Override
    public String getAdditional_notes() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ADDITIONAL_NOTES);
    }

    @Override
    public void setAdditional_notes(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_ADDITIONAL_NOTES);
            return;
        }
        row.setString(INDEX_ADDITIONAL_NOTES, (String) value);
    }

    @Override
    public String getDuration() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DURATION);
    }

    @Override
    public void setDuration(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_DURATION);
            return;
        }
        row.setString(INDEX_DURATION, (String) value);
    }

    @Override
    public String getCost() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_COST);
    }

    @Override
    public void setCost(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_COST);
            return;
        }
        row.setString(INDEX_COST, (String) value);
    }

    @Override
    public String getCity_id() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CITY_ID);
    }

    @Override
    public void setCity_id(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(INDEX_CITY_ID);
            return;
        }
        row.setString(INDEX_CITY_ID, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_AppointmentBookingModel")) {
            Table table = transaction.getTable("class_AppointmentBookingModel");
            table.addColumn(ColumnType.STRING, "category_id", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "product_id", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "category_name", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "product_name", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "name", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "number", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "email_id", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "address", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "date", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "time", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "additional_notes", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "duration", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "cost", Table.NULLABLE);
            table.addColumn(ColumnType.STRING, "city_id", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_AppointmentBookingModel");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_AppointmentBookingModel")) {
            Table table = transaction.getTable("class_AppointmentBookingModel");
            if (table.getColumnCount() != 14) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 14 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 14; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type AppointmentBookingModel");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_CATEGORY_ID = table.getColumnIndex("category_id");
            INDEX_PRODUCT_ID = table.getColumnIndex("product_id");
            INDEX_CATEGORY_NAME = table.getColumnIndex("category_name");
            INDEX_PRODUCT_NAME = table.getColumnIndex("product_name");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_NUMBER = table.getColumnIndex("number");
            INDEX_EMAIL_ID = table.getColumnIndex("email_id");
            INDEX_ADDRESS = table.getColumnIndex("address");
            INDEX_DATE = table.getColumnIndex("date");
            INDEX_TIME = table.getColumnIndex("time");
            INDEX_ADDITIONAL_NOTES = table.getColumnIndex("additional_notes");
            INDEX_DURATION = table.getColumnIndex("duration");
            INDEX_COST = table.getColumnIndex("cost");
            INDEX_CITY_ID = table.getColumnIndex("city_id");

            if (!columnTypes.containsKey("category_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'category_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("category_id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'category_id' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_CATEGORY_ID)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'category_id' is required. Either set @Required to field 'category_id' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("product_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'product_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("product_id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'product_id' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_PRODUCT_ID)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'product_id' is required. Either set @Required to field 'product_id' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("category_name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'category_name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("category_name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'category_name' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_CATEGORY_NAME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'category_name' is required. Either set @Required to field 'category_name' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("product_name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'product_name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("product_name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'product_name' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_PRODUCT_NAME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'product_name' is required. Either set @Required to field 'product_name' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_NAME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("number")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'number' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("number") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'number' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_NUMBER)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'number' is required. Either set @Required to field 'number' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("email_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'email_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email_id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'email_id' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_EMAIL_ID)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'email_id' is required. Either set @Required to field 'email_id' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("address")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'address' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("address") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'address' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_ADDRESS)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'address' is required. Either set @Required to field 'address' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("date")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'date' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("date") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'date' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_DATE)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'date' is required. Either set @Required to field 'date' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("time")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'time' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("time") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'time' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_TIME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'time' is required. Either set @Required to field 'time' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("additional_notes")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'additional_notes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("additional_notes") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'additional_notes' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_ADDITIONAL_NOTES)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'additional_notes' is required. Either set @Required to field 'additional_notes' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("duration")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'duration' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("duration") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'duration' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_DURATION)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'duration' is required. Either set @Required to field 'duration' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("cost")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'cost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cost") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'cost' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_COST)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'cost' is required. Either set @Required to field 'cost' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("city_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'city_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("city_id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'city_id' in existing Realm file.");
            }
            if (!table.isColumnNullable(INDEX_CITY_ID)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'city_id' is required. Either set @Required to field 'city_id' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The AppointmentBookingModel class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_AppointmentBookingModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static AppointmentBookingModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        AppointmentBookingModel obj = realm.createObject(AppointmentBookingModel.class);
        if (json.has("category_id")) {
            if (json.isNull("category_id")) {
                obj.setCategory_id(null);
            } else {
                obj.setCategory_id((String) json.getString("category_id"));
            }
        }
        if (json.has("product_id")) {
            if (json.isNull("product_id")) {
                obj.setProduct_id(null);
            } else {
                obj.setProduct_id((String) json.getString("product_id"));
            }
        }
        if (json.has("category_name")) {
            if (json.isNull("category_name")) {
                obj.setCategory_name(null);
            } else {
                obj.setCategory_name((String) json.getString("category_name"));
            }
        }
        if (json.has("product_name")) {
            if (json.isNull("product_name")) {
                obj.setProduct_name(null);
            } else {
                obj.setProduct_name((String) json.getString("product_name"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName(null);
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        if (json.has("number")) {
            if (json.isNull("number")) {
                obj.setNumber(null);
            } else {
                obj.setNumber((String) json.getString("number"));
            }
        }
        if (json.has("email_id")) {
            if (json.isNull("email_id")) {
                obj.setEmail_id(null);
            } else {
                obj.setEmail_id((String) json.getString("email_id"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                obj.setAddress(null);
            } else {
                obj.setAddress((String) json.getString("address"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                obj.setDate(null);
            } else {
                obj.setDate((String) json.getString("date"));
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                obj.setTime(null);
            } else {
                obj.setTime((String) json.getString("time"));
            }
        }
        if (json.has("additional_notes")) {
            if (json.isNull("additional_notes")) {
                obj.setAdditional_notes(null);
            } else {
                obj.setAdditional_notes((String) json.getString("additional_notes"));
            }
        }
        if (json.has("duration")) {
            if (json.isNull("duration")) {
                obj.setDuration(null);
            } else {
                obj.setDuration((String) json.getString("duration"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                obj.setCost(null);
            } else {
                obj.setCost((String) json.getString("cost"));
            }
        }
        if (json.has("city_id")) {
            if (json.isNull("city_id")) {
                obj.setCity_id(null);
            } else {
                obj.setCity_id((String) json.getString("city_id"));
            }
        }
        return obj;
    }

    public static AppointmentBookingModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        AppointmentBookingModel obj = realm.createObject(AppointmentBookingModel.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("category_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCategory_id(null);
                } else {
                    obj.setCategory_id((String) reader.nextString());
                }
            } else if (name.equals("product_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setProduct_id(null);
                } else {
                    obj.setProduct_id((String) reader.nextString());
                }
            } else if (name.equals("category_name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCategory_name(null);
                } else {
                    obj.setCategory_name((String) reader.nextString());
                }
            } else if (name.equals("product_name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setProduct_name(null);
                } else {
                    obj.setProduct_name((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setName(null);
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else if (name.equals("number")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setNumber(null);
                } else {
                    obj.setNumber((String) reader.nextString());
                }
            } else if (name.equals("email_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setEmail_id(null);
                } else {
                    obj.setEmail_id((String) reader.nextString());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setAddress(null);
                } else {
                    obj.setAddress((String) reader.nextString());
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setDate(null);
                } else {
                    obj.setDate((String) reader.nextString());
                }
            } else if (name.equals("time")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setTime(null);
                } else {
                    obj.setTime((String) reader.nextString());
                }
            } else if (name.equals("additional_notes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setAdditional_notes(null);
                } else {
                    obj.setAdditional_notes((String) reader.nextString());
                }
            } else if (name.equals("duration")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setDuration(null);
                } else {
                    obj.setDuration((String) reader.nextString());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCost(null);
                } else {
                    obj.setCost((String) reader.nextString());
                }
            } else if (name.equals("city_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCity_id(null);
                } else {
                    obj.setCity_id((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static AppointmentBookingModel copyOrUpdate(Realm realm, AppointmentBookingModel object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static AppointmentBookingModel copy(Realm realm, AppointmentBookingModel newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        AppointmentBookingModel realmObject = realm.createObject(AppointmentBookingModel.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setCategory_id(newObject.getCategory_id());
        realmObject.setProduct_id(newObject.getProduct_id());
        realmObject.setCategory_name(newObject.getCategory_name());
        realmObject.setProduct_name(newObject.getProduct_name());
        realmObject.setName(newObject.getName());
        realmObject.setNumber(newObject.getNumber());
        realmObject.setEmail_id(newObject.getEmail_id());
        realmObject.setAddress(newObject.getAddress());
        realmObject.setDate(newObject.getDate());
        realmObject.setTime(newObject.getTime());
        realmObject.setAdditional_notes(newObject.getAdditional_notes());
        realmObject.setDuration(newObject.getDuration());
        realmObject.setCost(newObject.getCost());
        realmObject.setCity_id(newObject.getCity_id());
        return realmObject;
    }

    static AppointmentBookingModel update(Realm realm, AppointmentBookingModel realmObject, AppointmentBookingModel newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setCategory_id(newObject.getCategory_id());
        realmObject.setProduct_id(newObject.getProduct_id());
        realmObject.setCategory_name(newObject.getCategory_name());
        realmObject.setProduct_name(newObject.getProduct_name());
        realmObject.setName(newObject.getName());
        realmObject.setNumber(newObject.getNumber());
        realmObject.setEmail_id(newObject.getEmail_id());
        realmObject.setAddress(newObject.getAddress());
        realmObject.setDate(newObject.getDate());
        realmObject.setTime(newObject.getTime());
        realmObject.setAdditional_notes(newObject.getAdditional_notes());
        realmObject.setDuration(newObject.getDuration());
        realmObject.setCost(newObject.getCost());
        realmObject.setCity_id(newObject.getCity_id());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("AppointmentBookingModel = [");
        stringBuilder.append("{category_id:");
        stringBuilder.append(getCategory_id() != null ? getCategory_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{product_id:");
        stringBuilder.append(getProduct_id() != null ? getProduct_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{category_name:");
        stringBuilder.append(getCategory_name() != null ? getCategory_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{product_name:");
        stringBuilder.append(getProduct_name() != null ? getProduct_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName() != null ? getName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{number:");
        stringBuilder.append(getNumber() != null ? getNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email_id:");
        stringBuilder.append(getEmail_id() != null ? getEmail_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(getAddress() != null ? getAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(getDate() != null ? getDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{time:");
        stringBuilder.append(getTime() != null ? getTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{additional_notes:");
        stringBuilder.append(getAdditional_notes() != null ? getAdditional_notes() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{duration:");
        stringBuilder.append(getDuration() != null ? getDuration() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cost:");
        stringBuilder.append(getCost() != null ? getCost() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{city_id:");
        stringBuilder.append(getCity_id() != null ? getCity_id() : "null");
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
        AppointmentBookingModelRealmProxy aAppointmentBookingModel = (AppointmentBookingModelRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aAppointmentBookingModel.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aAppointmentBookingModel.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aAppointmentBookingModel.row.getIndex()) return false;

        return true;
    }

}
