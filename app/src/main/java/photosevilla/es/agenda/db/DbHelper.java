package photosevilla.es.agenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "agenda_db";
    public static final String TABLE_CONTACTOS = "t_contactos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                "AG_ID integer PRIMARY KEY AUTOINCREMENT," +
                "AG_NOMBRE TEXT," +
                "AG_APELLIDOS TEXT," +
                "AG_ALIAS TEXT NOT NULL UNIQUE," +
                "AG_TELEFONO TEXT," +
                "AG_EMAIL TEXT," +
                "AG_PW)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
            onCreate(sqLiteDatabase);
    }
}
