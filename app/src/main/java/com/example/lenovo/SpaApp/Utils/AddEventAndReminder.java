package com.example.lenovo.SpaApp.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.EventLog;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by divyanshu.jain on 6/9/2016.
 */
public class AddEventAndReminder {
    private static AddEventAndReminder ourInstance = new AddEventAndReminder();
    private static final String TAG = "CalendarHelper";
    public static final int CALENDARHELPER_PERMISSION_REQUEST_CODE = 99;
    static Activity activity;

    public static AddEventAndReminder getInstance(Activity context) {
        activity = context;
        return ourInstance;
    }

    private AddEventAndReminder() {
    }

    public void addEventsToCalender(String title, String desription, String address, long startDate) {
        try {

            String eventString = "content://com.android.calendar/events";
            ContentValues eventValues = new ContentValues();
            eventValues.put("eventTimezone", TimeZone.getDefault().getID());
            eventValues.put("calendar_id", 1); // id, We need to choose from // our mobile for primary its 1
            eventValues.put("title", title);
            eventValues.put("description", desription);
            eventValues.put("eventLocation", address);
            //For next 10min
            long endDate = startDate + 1000 * 10 * 10;
            eventValues.put(CalendarContract.Events.DTSTART, startDate);
            eventValues.put(CalendarContract.Events.DTEND, endDate);
            // If it is bithday alarm or such // kind (which should remind me for whole day) 0 for false, 1 // for true
            eventValues.put(CalendarContract.Events.STATUS, 1);
            // You can control whether // an event consumes time // opaque (0) or transparent // (1).
            eventValues.put("hasAlarm", 1);
            // 0 for false, 1 for true
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (activity.checkSelfPermission(Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

                    requestCalendarReadWritePermission(activity);
                }
            }
            Uri eventUri = activity.getApplicationContext().getContentResolver().insert(Uri.parse(eventString), eventValues);
            long eventID = Long.parseLong(eventUri.getLastPathSegment());
            addReminder(eventID, activity);
        } catch (Exception ex) {
            Log.i("Error message", "Error in adding event on calendar" + ex.getMessage());
        }
    }


 /*   public void addEvent(Context context,long start) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .setType("vnd.android.cursor.item/event")
                .putExtra(CalendarContract.Events.TITLE, "Tuesdays")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Tuesday Specials")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Lixious Bench")
                //.putExtra(CalendarContract.Events.RRULE, "FREQ=WEEKLY;BYDAY=TU;UNTIL=20150428")

                        // to specify start time use "beginTime" instead of "dtstart"
                        //.putExtra(Events.DTSTART, calendar.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, start)
                *//*.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)*//*

                        // if you want to go from 6pm to 9pm, don't specify all day
                        //.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                .putExtra(CalendarContract.Events.HAS_ALARM, 1)
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);

        context.startActivity(intent);
    }*/

    private void addReminder(long eventID, Activity context) {
        /***************** Event: Reminder(with alert) Adding reminder to event *******************/
        Uri reminderUriString = CalendarContract.Reminders.CONTENT_URI;
        ContentValues reminderValues = new ContentValues();
        reminderValues.put("event_id", eventID);
        // Default value //set time in min which occur before event start
        reminderValues.put("minutes", 2);
        // Alert Methods: Default(0), // Alert(1), Email(2),SMS(3)
        reminderValues.put("method", 1);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // only for gingerbread and newer versions

            if (context.checkSelfPermission(Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                requestCalendarReadWritePermission(context);

            }
        }
        Uri reminderUri = context.getApplicationContext().getContentResolver().insert(reminderUriString, reminderValues);
    }

    public void requestCalendarReadWritePermission(Activity caller) {
        List<String> permissionList = new ArrayList<String>();

        if (ContextCompat.checkSelfPermission(caller, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_CALENDAR);

        }

        if (ContextCompat.checkSelfPermission(caller, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_CALENDAR);

        }

        if (permissionList.size() > 0) {
            String[] permissionArray = new String[permissionList.size()];

            for (int i = 0; i < permissionList.size(); i++) {
                permissionArray[i] = permissionList.get(i);
            }

            ActivityCompat.requestPermissions(caller,
                    permissionArray,
                    CALENDARHELPER_PERMISSION_REQUEST_CODE);
        }

    }

    public Hashtable listCalendarId(Context c) {

        if (haveCalendarReadWritePermissions((Activity) c)) {

            String projection[] = {"_id", "calendar_displayName"};
            Uri calendars;
            calendars = Uri.parse("content://com.android.calendar/calendars");

            ContentResolver contentResolver = c.getContentResolver();
            Cursor managedCursor = contentResolver.query(calendars, projection, null, null, null);

            if (managedCursor.moveToFirst()) {
                String calName;
                String calID;
                int cont = 0;
                int nameCol = managedCursor.getColumnIndex(projection[1]);
                int idCol = managedCursor.getColumnIndex(projection[0]);
                Hashtable<String, String> calendarIdTable = new Hashtable<>();

                do {
                    calName = managedCursor.getString(nameCol);
                    calID = managedCursor.getString(idCol);
                    Log.v(TAG, "CalendarName:" + calName + " ,id:" + calID);
                    calendarIdTable.put(calName, calID);
                    cont++;
                } while (managedCursor.moveToNext());
                managedCursor.close();

                return calendarIdTable;
            }

        }

        return null;

    }

    public boolean haveCalendarReadWritePermissions(Activity caller) {
        int permissionCheck = ContextCompat.checkSelfPermission(caller,
                Manifest.permission.READ_CALENDAR);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            permissionCheck = ContextCompat.checkSelfPermission(caller,
                    Manifest.permission.WRITE_CALENDAR);

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
        }

        return false;
    }

}


