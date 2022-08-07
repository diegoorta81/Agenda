package photosevilla.es.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper{
    Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaContacto(String AG_NOMBRE, String AG_APELLIDOS, String AG_ALIAS,
                                String AG_TELEFONO, String AG_EMAIL){
        long id = 0;
        try {
         DbHelper dbHelper = new DbHelper(context);
         SQLiteDatabase db = dbHelper.getWritableDatabase();

         ContentValues values = new ContentValues();
         values.put("AG_NOMBRE", AG_NOMBRE);
         values.put("AG_APELLIDOS", AG_APELLIDOS);
         values.put("AG_ALIAS", AG_ALIAS);
         values.put("AG_TELEFONO", AG_TELEFONO);
         values.put("AG_EMAIL", AG_EMAIL);

         id = db.insert(TABLE_CONTACTOS, null, values);
        }catch (Exception ex){
         ex.toString();
        }
        return id;
    }
}
