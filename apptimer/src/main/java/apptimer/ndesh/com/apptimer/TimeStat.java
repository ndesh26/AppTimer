package apptimer.ndesh.com.apptimer;

import android.graphics.drawable.Drawable;

/**
 * Created by nayan on 25/12/15.
 */
public class TimeStat {
    public String packageName;
    public long time;

    public void setName(String packageName) {
        this.packageName = packageName;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return packageName;
    }

    public TimeStat(String packageName, long time) {
        this.packageName = packageName;
        this.time=time;
    }
}
