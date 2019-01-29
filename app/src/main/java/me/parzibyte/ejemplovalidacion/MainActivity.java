package me.parzibyte.ejemplovalidacion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener variables de las vistas
        etNumero = findViewById(R.id.etNumero);
        Button btnOk = findViewById(R.id.btnOk);

        // Agregar listener al botón
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quitamos los errores
                etNumero.setError(null);
                String posibleNumero = etNumero.getText().toString();
                // Vemos si está vacío...
                // Notación yoda: https://parzibyte.me/blog/2018/09/24/notacion-yoda-en-programacion/
                if ("".equals(posibleNumero)) {
                    // Primer error
                    etNumero.setError("Introduce un número");
                    // Le damos focus
                    etNumero.requestFocus();
                    // Y terminamos la ejecución
                    return;
                }
                // En caso de que hayan puesto algo, convertimos a entero
                int numero = Integer.parseInt(posibleNumero);
                // Comparar si está en el rango
                if (numero >= 5 && numero <= 60) {
                    // La validación termina y hacemos lo que vayamos a hacer
                    Toast.makeText(MainActivity.this, "Todo correcto", Toast.LENGTH_SHORT).show();
                } else {
                    // Si no, entonces indicamos el error y damos focus
                    etNumero.setError("Número fuera de rango");
                    etNumero.requestFocus();
                }
            }
        });

        TextView tvAutor = findViewById(R.id.tvAutor);
        tvAutor.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentNavegador = new Intent(Intent.ACTION_VIEW, Uri.parse("https://parzibyte.me"));
                startActivity(intentNavegador);
            }
        });
    }
}
