package com.cruz.menuaplication.Activities.Repositories;

import com.cruz.menuaplication.Activities.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FERNANDO on 27/09/2017.
 */

public class UsuarioRepositorio {

    private static UsuarioRepositorio _INSTANCE = null;

    //Usando singleton
    public static UsuarioRepositorio getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new UsuarioRepositorio();
        return _INSTANCE;
    }

    private UsuarioRepositorio() {
        //(Usuario, Contraseña, Nombre, Rol)
        agregarUsuario(new Usuario("cliente","123","Luis","Cliente"));
        agregarUsuario(new Usuario("supervisor","123","Manuel","Supervisor"));
        agregarUsuario(new Usuario("tecnico","123","Raul","Tecnico"));
    }

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
}
