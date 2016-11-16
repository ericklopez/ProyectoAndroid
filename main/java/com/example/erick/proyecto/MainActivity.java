package com.example.erick.proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.erick.proyecto.data.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button btn_registro, btn_login, btn_limpiar, btn_accion;
    private EditText et_rfc, et_nombre, et_apellido, et_telefono, et_password;
    private FrameLayout frameLayout;
    private LayoutInflater li;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comprobarSesion();
        li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        btn_registro = (Button) findViewById(R.id.btn_registro);
        btn_login = (Button) findViewById(R.id.btn_login);
        frameLayout = (FrameLayout) findViewById(R.id.f1_formulario);

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setActivated(true);
                btn_registro.setActivated(false);
                View fromRegistro = li.inflate(R.layout.form_registro, null);
                enlazaFormRegistro(formRegistro);
                frameLayout.removeAllViews();
                frameLayout.addView(formRegistro);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setActivated(false);
                btn_registro.setActivated(true);
                View formLogin = li.inflate(R.layout.form_login, null);
                enlazaFormLogin(formLogin);
                frameLayout.removeAllViews();
                frameLayout.addView(formLogin);
            }
        });
    }

    private void enlazaFormRegistro(View v){
        et_rfc = (EditText)v.findViewById(R.id.et_rfc);
        et_nombre = (EditText)v.findViewById(R.id.et_nombre);
        et_apellido = (EditText)v.findViewById(R.id.et_apellido);
        et_password = (EditText)v.findViewById(R.id.et_password);
        et_telefono = (EditText)v.findViewById(R.id.et_telefono);

        btn_limpiar = (Button)v.findViewById(R.id.btn_limpiar);
        btn_accion = (Button)v.findViewById(R.id.btn_registro);

        btn_limpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                et_rfc.setText(null);
                et_nombre.setText(null);
                et_apellido.setText(null);
                et_telefono.setText(null);
                et_password.setText(null);
            }
        });

        btn_accion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean registro = true;
                if(et_rfc.getText().length() != 10){
                    registro = false;
                    et_rfc.setError("RFC Incorrecto");
                }else{
                    et_rfc.setError(null);
                }

                if(et_nombre.getText().length() < 1){
                    registro = false;
                    et_nombre.setError("Ingresa un nombre");
                }else{
                    et_nombre.setError(null);
                }

                if(et_apellido.getText().length() < 1){
                    registro = false;
                    et_apellido.setError("Ingresa tu apellido");
                }else{
                    et_apellido.setError(null);
                }

                if(et_password.getText().length() < 4){
                    registro = false;
                    et_password.setError("Ingresa una contraseña mayor a 4 caracteres");
                }else{
                    et_password.setError(null);
                }

                if(et_telefono.getText().length() < 1){
                    registro = false;
                    et_telefono.setError("Ingresa un teléfono");
                }else{
                    et_telefono.setError(null);
                }

                if(registro){
                    new RegistraUsuario().execute(
                            new Usuario(
                                    et_rfc.getText().toString(),
                                    et_nombre.getText().toString(),
                                    et_apellido.getText().toString(),
                                    et_password.getText().toString(),
                                    et_telefono.getText().toString()
                            )
                    );
                }
            }
        });
    }

    private void comprobarSesion(){
        sharedPreferences = getSharedPreferences(
                "WebService",
                Context.MODE_PRIVATE
        );

        String us = SharedPreferences.getString("usuario","");
        if(!us.equals("")){
            Log.i("Panadería Chida","Sesión iniciada");
            startActivity(new Intent(getApplicationContext(),PanaderiaActivity.class));
        }else{
            Log.i("Panadería Chida","No se pudo iniciar la sesión");
        }
    }

    private void guardarSesion(String usuario){
        sharedPreferences = getSharedPreferences(
                "WebService",
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usuario",usuario);
        editor.commit();
    }

}
