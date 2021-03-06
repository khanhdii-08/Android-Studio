package com.example.sqliteon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_PB:{
                Intent intent = new Intent(MainActivity.this, PhongBanActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.id_NV:
                Intent intent = new Intent(MainActivity.this, NhanVienActivity.class);
                startActivity(intent);
                break;
            case R.id.id_Thoat:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}