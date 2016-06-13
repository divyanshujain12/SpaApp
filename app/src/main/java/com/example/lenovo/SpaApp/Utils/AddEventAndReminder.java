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
import android.widget.Toast;

import com.example.lenovo.SpaApp.MainActivity;

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
            eventValues.put("calendar_id", 1);
            eventValues.put("title", title);
            eventValues.put("description", desription);
            eventValues.put("eventLocation", address);
            long endDate = startDate + 1000 * 10 * 10;
            eventValues.put(CalendarContract.Events.DTSTART, startDate);
            eventValues.put(CalendarContract.Events.DTEND, endDate);
            eventValues.put(CalendarContract.Events.STATUS, 1);
            eventValues.put("hasAlarm", 1);
            Uri eventUri = activity.getApplicationContext().getContentResolver().insert(Uri.parse(eventString), eventValues);
            long eventID = Long.parseLong(eventUri.getLastPathSegment());
            addReminder(eventID, activity);
        } catch (Exception ex) {
            Log.i("Error message", "Error in adding event on calendar" + ex.getMessage());
        }
    }


    private void addReminder(long eventID, Activity context) {

        Uri reminderUriString = CalendarContract.Reminders.CONTENT_URI;
        ContentValues reminderValues = new ContentValues();
        reminderValues.put("event_id", eventID);
        reminderValues.put("minutes", 2);
        reminderValues.put("method", 1);
        activity.getApplicationContext().getContentResolver().insert(reminderUriString, reminderValues);
    }

}


