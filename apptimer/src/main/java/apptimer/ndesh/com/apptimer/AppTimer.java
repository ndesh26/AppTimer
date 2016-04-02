package apptimer.ndesh.com.apptimer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayan on 24/12/15.
 */
public class AppTimer
{
    static AlarmManager alarm;
    static PendingIntent pintent;
    static Intent intent;

    public static void initialize (Context context)
    {
        intent = new Intent (context, TimeStatService.class);
        pintent = PendingIntent.getService (context, 0, intent, 0);
        alarm = (AlarmManager) context.getSystemService (context.ALARM_SERVICE);
        alarm.setRepeating (AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),1000, pintent);


    }

    public static List<TimeStat> getTimeStats (Context context)
    {
        List<TimeStat> timeStats =new ArrayList<TimeStat>();
        Database dop = new Database (context);
        Cursor CR = dop.getInformation (dop);
        CR.moveToFirst();
        while (CR.moveToNext()) {
            timeStats.add (new TimeStat(CR.getString(0), CR.getLong(1)));
        }
        CR.close ();
        return timeStats;
    }
}
