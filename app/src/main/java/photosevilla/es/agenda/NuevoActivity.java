package photosevilla.es.agenda;

import androidx.appcompat.app.AppCompatActivity;
import photosevilla.es.agenda.db.DbContactos;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static photosevilla.es.agenda.R.id.txtTelefono;

public class NuevoActivity extends AppCompatActivity {
    EditText txtNombre, txtApellidos, txtAlias, txtTelefono, txtEmail;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtAlias = findViewById(R.id.txtAlias);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = (Button)findViewById(R.id.btn_Guardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertaContacto(txtNombre.getText().toString(), txtApellidos.getText().toString(), txtAlias.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtApellidos.setText("");
        txtAlias.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }
}