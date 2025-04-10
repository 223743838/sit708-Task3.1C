package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.collection.BuildConfig;

public class MainActivity extends AppCompatActivity {


    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawerlayout);

    }

    public void C(View view) {

        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);


    }

    public void Cplus(View view) {

        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);
    }

    public void Python(View view) {
        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);
    }

    public void HTML(View view) {
        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);
    }

    public void Kotlin(View view) {
        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);
    }

    public void CSharp(View view) {
        Intent intent = new Intent(MainActivity.this, questionActivity.class);
        startActivity(intent);
    }
}