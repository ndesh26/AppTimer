package apptimer.ndesh.com.apptimer;

import android.provider.BaseColumns;

/**
 * Created by nayan on 24/12/15.
 */
public class Table {
    public Table () {}
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String APPDATA="data";
        public static final String TIME="time";
        public static final String DATABASE_NAME="number";
        public static final String TABLE_NAME="reg_info";
    }
}
