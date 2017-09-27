package com.cruz.menuaplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cruz.menuaplication.R;

/**
 * Created by FERNANDO on 27/09/2017.
 */

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String rol = this.getIntent().getExtras().getString("IngresarUsuario");

        if (rol.equals("Cliente")) {
            ItemCliente();
            informacioUser("Cliente");
        }else if(rol.equals("Supervisor")){
            ItemSupervisor();
            informacioUser("Supervisor");
        }else {
           ItemTecnico();
            informacioUser("Tecnico");
        }
        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()){
                    case R.id.nav_logout:
                        Toast.makeText(MenuActivity.this, "Logout...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MenuActivity.this, MainActivity.class));
                        finish();
                        break;
                }
                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Change navigation header information
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);
    }
    private void ItemCliente() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu men= navigationView.getMenu();

        men.findItem(R.id.nav_cons_todo_tick).setVisible(false);
        men.findItem(R.id.nav_asig_tick).setVisible(false);
        men.findItem(R.id.nav_rep_tick).setVisible(false);
        men.findItem(R.id.nav_cons_tick_asig).setVisible(false);
        men.findItem(R.id.nav_aten_tick_asig).setVisible(false);
        //Colocas todos los items que deseas esconder
    }

    private void ItemSupervisor() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu men= navigationView.getMenu();

        men.findItem(R.id.nav_reg_tick).setVisible(false);
        men.findItem(R.id.nav_cons_tick).setVisible(false);
        men.findItem(R.id.nav_cons_tick_asig).setVisible(false);
        men.findItem(R.id.nav_aten_tick_asig).setVisible(false);
        //Colocas todos los items que deseas esconder
    }

    private void ItemTecnico() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu men= navigationView.getMenu();

        men.findItem(R.id.nav_reg_tick).setVisible(false);
        men.findItem(R.id.nav_cons_tick).setVisible(false);
        men.findItem(R.id.nav_cons_todo_tick).setVisible(false);
        men.findItem(R.id.nav_asig_tick).setVisible(false);
        men.findItem(R.id.nav_rep_tick).setVisible(false);
        //Colocas todos los items que deseas esconder
    }

    private void informacioUser(String tipo){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(tipo);

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText(tipo+"@tecsup.edu.pe");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

