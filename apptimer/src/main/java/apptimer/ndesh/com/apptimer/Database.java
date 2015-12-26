package apptimer.ndesh.com.apptimer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by nayan on 24/12/15.
 */
public class Database extends SQLiteOpenHelper{
    public static final int database_version=1;
    public String CREATE_QUERY="create table "+Table.TableInfo.TABLE_NAME+" ("+ Table.TableInfo.APPDATA+" TEXT," +Table.TableInfo.TIME+" LONG)";
    public Database(Context context) {
        super(context, Table.TableInfo.DATABASE_NAME, null, database_version);
    }
    long time;
    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("database operations", "table created");
    }
    public void putInformation(Database dop,String value){
        int count=0;
        SQLiteDatabase SQ =dop.getWritableDatabase();
        Cursor CR=getInformation(dop);
        CR.moveToFirst();
        while(CR.moveToNext()){
            if(CR.getString(0).equals(value)){
                time=CR.getLong(1);
                time++;
                update(dop,CR.getString(0),time);
                count++;
            }

        }
        CR.close();

        if(count==0){
            ContentValues cv=new ContentValues();
            cv.put(Table.TableInfo.APPDATA,value);
            cv.put(Table.TableInfo.TIME,0);
            SQ.insert(Table.TableInfo.TABLE_NAME,null,cv);
            count=0;

        }
        SQ.close();



    }
    public Cursor getInformation(Database dop){
        SQLiteDatabase sq=dop.getReadableDatabase();
        String coloumns[]={Table.TableInfo.APPDATA, Table.TableInfo.TIME};
        Cursor CR = sq.query(Table.TableInfo.TABLE_NAME,coloumns,null,null,null,null,null);
        return CR;}
    public void update(Database dop,String appname,long time){
        SQLiteDatabase SQ=dop.getWritableDatabase();
        String selection= Table.TableInfo.APPDATA+" LIKE ?";
        String args[]={appname};
        ContentValues cv=new ContentValues();
        cv.put(Table.TableInfo.TIME,time);
        SQ.update(Table.TableInfo.TABLE_NAME,cv,selection,args);
        SQ.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
