package apptimer.ndesh.com.apptimer;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;

public class TimeStatService extends Service
{
    String foregroundTaskPackageName;
    Context ctx=this;
    public TimeStatService () {}

    @Override
    public IBinder onBind (Intent intent)
    {
        return null;
    }
    public int onStartCommand (Intent intent, int flags, int startId)
    {
        KeyguardManager keyguardManager = (KeyguardManager) ctx.getSystemService (Context.KEYGUARD_SERVICE);
        if( keyguardManager.inKeyguardRestrictedInputMode ()) {
            store (ctx);
            //phone is locked
        } else {
            //phone is not locked
        }
        stopSelf ();
        return START_STICKY;
    }
    public void store (Context ctx)
    {
        final Database database = new Database (ctx);
        final ActivityManager activityManager = (ActivityManager) ctx.getSystemService(ACTIVITY_SERVICE);
        if(Build.VERSION.SDK_INT > 20){
            foregroundTaskPackageName = activityManager.getRunningAppProcesses().get(0).processName;
        }
        else{
            foregroundTaskPackageName = activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
        }
        database.putInformation (database, foregroundTaskPackageName.toString());

    }

}
