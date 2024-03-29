package com.samuel_fox.calendar.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.samuel_fox.calendar.CalendarViewWithNotesActivitySDK21;
import com.samuel_fox.calendar.CreateEventActivity;
import com.samuel_fox.calendar.R;


/*
Autor: Juan Francisco Sánchez González
Fecha: 07/02/2023
Clase: Actividad que contiene la barra de menú lateral (NavigationDrawer). Para cargar el contenido de la activity
se utiliza un ViewFlipper.
*/

//public class UserActivity extends AppCompatActivity {

//    private final static int CONT_ACTIVIDAD = 0;
//    private DrawerLayout drawerLayout;
//    private NavigationView nav;
//    private ViewFlipper vf;
//    Toolbar toolbar;
//
//
//    private TextView nomeUsuario, emailUsuario;
//
//    private Button bt_deslogar;
//
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
//    String usuarioID;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        toolbar();
//
//
//        IniciarComponentes();
//
//        bt_deslogar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(UserActivity.this, " Desconectando ", Toast.LENGTH_SHORT).show();
//
//                FirebaseAuth.getInstance().signOut();
//
//                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
//                startActivity(intent);
//
//                finish();
//            }
//        });
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
//
//        DocumentReference documentReference = db.collection("Usuario").document(usuarioID);
//
//        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                if (documentSnapshot != null){
//                    nomeUsuario.setText(documentSnapshot.getString("nome"));
//                    emailUsuario.setText(email);
//
//                }
//            }
//        });
//    }
//    private void IniciarComponentes() {
//
//        nomeUsuario = findViewById(R.id.edit_userName);
//        emailUsuario = findViewById(R.id.edit_userEmail);
//        bt_deslogar = findViewById(R.id.bt_desconectar);
//    }
//
//    private void toolbar() {
//        toolbar = findViewById(R.id.toolbarUser);
//
//        // Componente ViewFlipper
//        vf = (ViewFlipper)findViewById(R.id.vf);
//        vf.setDisplayedChild(CONT_ACTIVIDAD);
//
//        // Componente NavigationDrawer
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        nav = (NavigationView) findViewById(R.id.nav_view);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
//
//
//        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Intent sendIntent;
//                if (item.getItemId() == R.id.nav_item_one) {
//                    // Se inicia Actividad 1
//                    sendIntent = new Intent(UserActivity.this, UserActivity.class);
//                    startActivity(sendIntent);
//                } else if (item.getItemId() == R.id.nav_item_two) {
//                    // Se inicia Actividad 2
//                    sendIntent = new Intent(UserActivity.this, CalendarViewWithNotesActivitySDK21.class);
//                    startActivity(sendIntent);
//                }
//
//                // Close the navigation drawer when an item is selected
//                drawerLayout.closeDrawers();
//                return true;
//            }
//        });
//    }
//}