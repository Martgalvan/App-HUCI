package com.example.navigationdrawerfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import com.example.navigationdrawerfinal.Entities.Information;
import com.example.navigationdrawerfinal.Fragments.DetalleInfo;
import com.example.navigationdrawerfinal.Fragments.Fragment_info;
import com.example.navigationdrawerfinal.Fragments.Main_fragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, iComunicateFragment{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //variables para cargar el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    //variable del fragment info
    DetalleInfo detalleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Inicio");
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.Drawer);
        navigationView = findViewById(R.id.NavigationView);

        //establecer evento onclick al navigation view
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle= new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        //cargar fragment principal

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new Main_fragment());
        fragmentTransaction.commit();
        navigationView.getMenu().findItem(R.id.home).setChecked(true);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);

        //borrar todas las casillas marcadas previamente
        navigationView.getMenu().findItem(R.id.home).setChecked(false);
        navigationView.getMenu().findItem(R.id.people).setChecked(false);
        navigationView.getMenu().findItem(R.id.info).setChecked(false);
        navigationView.getMenu().findItem(R.id.login).setChecked(false);

        // marcar casilla en el menu navigation
        menuItem.setChecked(true);

        if(menuItem.getItemId()== R.id.home){
            toolbar.setTitle("Inicio");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new Main_fragment());
            fragmentTransaction.commit();


        }

        if(menuItem.getItemId()== R.id.people){
            if(SaveSharedPreference.getUserName().length() == 0)
            {
                Intent intent = new Intent(this, PeopleActivity.class);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(this, RootPeopleActivity.class);
                startActivity(intent);
            }


        }
        if(menuItem.getItemId()== R.id.info){
            toolbar.setTitle("Información");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new Fragment_info());
            fragmentTransaction.commit();


        }

        if(menuItem.getItemId()== R.id.login){
            if(SaveSharedPreference.getUserName().length() == 0)
            {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
            else
            {
                String email = SaveSharedPreference.PREF_USER_NAME;
                String password = SaveSharedPreference.PREF_PASS;

                // Stay at the current activity.
                Intent myintent = new Intent(this, CorrectLogin.class);
                myintent.putExtra("email", email);
                myintent.putExtra("pass", password);
                startActivity(myintent);
            }




        }
        return false;
    }

    @Override
    public void sendPeople(Information information) {
        //logica para mandar envio
        detalleInfo = new DetalleInfo();
        //objeto bundle para transportar info
        Bundle bundleEnvio = new Bundle();
        //enviar el objeto que llega con serializable
        bundleEnvio.putSerializable("objeto",information);
        detalleInfo.setArguments(bundleEnvio);

        //abrir el fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, detalleInfo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}


class SaveSharedPreference
{
    static String PREF_USER_NAME = "";
    static String PREF_PASS = "";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName, String password)
    {
        SaveSharedPreference.PREF_USER_NAME = userName;
        SaveSharedPreference.PREF_PASS = password;
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.putString(PREF_PASS, password);
        editor.commit();
    }

    public static String getUserName()
    {
        return SaveSharedPreference.PREF_USER_NAME;
    }

}

