package apptimer.ndesh.com.apptimer;

import android.graphics.drawable.Drawable;

/**
 * Created by nayan on 25/12/15.
 */
public class TimeStat {
    public String name;
    public long time;

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public TimeStat(String name, long time) {
        this.name = name;
        this.time=time;
    }
}
