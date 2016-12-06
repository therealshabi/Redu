package testing.example.com.r_edu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tripti on 12/6/2016.
 */

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "redu";
    public static final int VERSION = 1;
    private static final String COURSE_TABLE = "course_table";
    private static final String COURSE_NAME = "course_name";
    private static final String COURSE_INFO = "course_info";
    private static final String COURSE_CATEGORY = "course_category";

    private static final String CENTERS_TABLE = "centers_table";
    private static final String CENTERS_NAME = "centers_name";
    private static final String CENTERS_INFO = "centers_info";
    private static final String CENTERS_COURSE = "centers_course";
    private static final String CENTERS_COST = "centers_cost";
    private static final String CENTERS_NUMBER = "centers_number";
    private static final String CENTERS_RATING = "centers_rating";


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String courseTable = "CREATE TABLE " + COURSE_TABLE + " (" +
                COURSE_NAME + " VARCHAR PRIMARY KEY, " +
                COURSE_INFO + " VARCHAR ," +
                COURSE_CATEGORY + " VARCHAR " +
                ");";

        String centersTable = "CREATE TABLE " + CENTERS_TABLE + " (" +
                CENTERS_NAME + " VARCHAR, " +
                CENTERS_INFO + " VARCHAR, " +
                CENTERS_COURSE + " VARCHAR, " +
                CENTERS_COST + " INTEGER, " +
                CENTERS_NUMBER + " INTEGER, " +
                CENTERS_RATING + " FLOAT(2,1) " +
                ");";
        db.execSQL(courseTable);
        db.execSQL(centersTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void courseInsert(String name, String info , String category) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COURSE_NAME, name);
        cv.put(COURSE_INFO, info);
        cv.put(COURSE_CATEGORY,category);

        database.insert(COURSE_TABLE, null, cv);
    }

    public void centersInsert(String name, String info, String course, int cost, int number, double rating) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CENTERS_NAME, name);
        cv.put(CENTERS_INFO, info);
        cv.put(CENTERS_COURSE, course);
        cv.put(CENTERS_COST, cost);
        cv.put(CENTERS_NUMBER, number);
        cv.put(CENTERS_RATING, rating);
        database.insert(CENTERS_TABLE, null, cv);
    }


    public ArrayList<CourseModel> getCourseList(String extra_category) {

        SQLiteDatabase database = getReadableDatabase();

        //Create new EventsModel list
        ArrayList<CourseModel> courseList = new ArrayList<>();

        //Set up the query
        String sql = "SELECT * FROM " + COURSE_TABLE +" WHERE "+COURSE_CATEGORY+" = '"+extra_category+"';";

        //Run the query and obtain cursor
        Cursor cursor = database.rawQuery(sql, null);

        //Extract the values while looping over cursor
        while (cursor.moveToNext()) {
            CourseModel event = new CourseModel();


            event.setCourseName(cursor.getString(cursor.getColumnIndex(COURSE_NAME)));
            event.setCourseInfo(cursor.getString(cursor.getColumnIndex(COURSE_INFO)));
            event.setCourseCategory(extra_category);

            //Add event to list
            courseList.add(event);
        }
        //Close cursor after use
        cursor.close();

        return courseList;
    }

    public ArrayList<CenterModel> getCentresList(String course) {

        SQLiteDatabase database = getReadableDatabase();

        //Create new EventsModel list
        ArrayList<CenterModel> courseList = new ArrayList<>();

        //Set up the query
        String sql = "SELECT * FROM " + CENTERS_TABLE +" WHERE "+CENTERS_COURSE+" = '"+course+"';";

        //Run the query and obtain cursor
        Cursor cursor = database.rawQuery(sql, null);

        //Extract the values while looping over cursor
        while (cursor.moveToNext()) {
            CenterModel event = new CenterModel();


            event.setCenterName(cursor.getString(cursor.getColumnIndex(CENTERS_NAME)));
            event.setCenterInfo(cursor.getString(cursor.getColumnIndex(CENTERS_INFO)));
            event.setCenterCourse(course);
            event.setCenterPeopleNumber(cursor.getInt(cursor.getColumnIndex(CENTERS_NUMBER)));
            event.setCenterPrice(cursor.getInt(cursor.getColumnIndex(CENTERS_COST)));
            event.setCenterRating(cursor.getDouble(cursor.getColumnIndex(CENTERS_RATING)));

            //Add event to list
            courseList.add(event);
        }
        //Close cursor after use
        cursor.close();

        return courseList;
    }

    public CenterModel getCentre(String center, String course) {

        SQLiteDatabase database = getReadableDatabase();

        //Create new EventsModel list
        CenterModel event = new CenterModel();

        //Set up the query
        String sql = "SELECT * FROM " + CENTERS_TABLE +" WHERE "+CENTERS_NAME+" = '"+center+"';";

        //Run the query and obtain cursor
        Cursor cursor = database.rawQuery(sql, null);

        //Extract the values while looping over cursor
        while (cursor.moveToNext()) {


            event.setCenterName(cursor.getString(cursor.getColumnIndex(CENTERS_NAME)));
            event.setCenterInfo(cursor.getString(cursor.getColumnIndex(CENTERS_INFO)));
            event.setCenterCourse(course);
            event.setCenterPeopleNumber(cursor.getInt(cursor.getColumnIndex(CENTERS_NUMBER)));
            event.setCenterPrice(cursor.getInt(cursor.getColumnIndex(CENTERS_COST)));
            event.setCenterRating(cursor.getDouble(cursor.getColumnIndex(CENTERS_RATING)));
            break;
            //Add event to list
        }
        //Close cursor after use
        cursor.close();

        return event;
    }

    public CourseModel getCourse(String course) {
        SQLiteDatabase database = getReadableDatabase();

        //Create new EventsModel list
        CourseModel event = new CourseModel();

        //Set up the query
        String sql = "SELECT * FROM " + COURSE_TABLE +" WHERE "+COURSE_NAME+" = '"+course+"';";

        //Run the query and obtain cursor
        Cursor cursor = database.rawQuery(sql, null);

        //Extract the values while looping over cursor
        while (cursor.moveToNext()) {


            event.setCourseName(cursor.getString(cursor.getColumnIndex(COURSE_NAME)));
            event.setCourseInfo(cursor.getString(cursor.getColumnIndex(COURSE_INFO)));
            event.setCourseCategory(cursor.getString(cursor.getColumnIndex(COURSE_CATEGORY)));
            break;
            //Add event to list
        }
        //Close cursor after use
        cursor.close();

        return event;
    }
}
