package com.example.erick.proyecto;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.erick.proyecto.data.Usuario;

/**
 * Created by erick on 16/11/16.
 */

public class PanaderiaActivity extends AppCompatActivity {
    Usuario usuario;
    private ListView listaPanes;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panes);
        comprobarSesion();
        new ListarPanes().execute("PanaderiaProteco", usuario.getRfc());
    }
}
