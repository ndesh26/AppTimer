package apptimer.ndesh.com.apptimer;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;

public class TimeStatService extends Service {
    String foregroundTaskPackageName;
    Context ctx=this;
    public TimeStatService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        store(ctx);
        stopSelf();
        return START_STICKY;

    }
    public void store(Context ctx){
        final Database dp=new Database(ctx);
        final ActivityManager am = (ActivityManager) ctx.getSystemService(ACTIVITY_SERVICE);
        if(Build.VERSION.SDK_INT > 20){
            foregroundTaskPackageName =am.getRunningAppProcesses().get(0).processName;
        }
        else{
            foregroundTaskPackageName =   am.getRunningTasks(1).get(0).topActivity.getPackageName();
        }
        PackageManager pm = ctx.getPackageManager();
        PackageInfo foregroundAppPackageInfo = null;
        try {
            foregroundAppPackageInfo = pm.getPackageInfo(foregroundTaskPackageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        dp.putInformation(dp, foregroundAppPackageInfo.applicationInfo.loadLabel(pm).toString());

    }

}
