package com.cruz.menuaplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cruz.menuaplication.Activities.Model.Usuario;
import com.cruz.menuaplication.Activities.Repositories.UsuarioRepositorio;
import com.cruz.menuaplication.R;

import java.util.List;

/**
 * Created by FERNANDO on 27/09/2017.
 */

public class MainActivity extends AppCompatActivity {

    private EditText txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = (EditText)findViewById(R.id.user);
        txtPass = (EditText)findViewById(R.id.password);

    }
    public void login(View view){
        String usu = txtUser.getText().toString();
        String pass = txtPass.getText().toString();

        if(usu.isEmpty()||pass.isEmpty()){
            Toast.makeText(this, "Rellene Ambos Campos", Toast.LENGTH_SHORT).show();
        }else{
            UsuarioRepositorio userRepo = UsuarioRepositorio.getInstance();
            List<Usuario> usuarios = userRepo.getUsuarios();

            boolean check = true;
            //Comparando
            for (Usuario usuario : usuarios){
                if (usu.equals(usuario.getUser()) && pass.equals(usuario.getPass())) {
                    check = true;
                    Intent intt = new Intent(MainActivity.this, MenuActivity.class);

                    //Envías el usuario hacia el menu
                    String rol=usuario.getRol();
                    intt.putExtra("IngresarUsuario", rol);
                    startActivity(intt);
                    break;
                }else{
                    check = false;
                }
            }
            if (!check) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

