package apptimer.ndesh.com.apptimer;
/**
 * Created by nayan on 25/12/15.
 */
public class TimeStat {
    public String packageName;
    public long time;

    public void setName (String packageName)
    {
        this.packageName = packageName;
    }

    public String getName ()
    {
        return packageName;
    }

    public TimeStat (String packageName, long time)
    {
        this.packageName = packageName;
        this.time=time;
    }
}
