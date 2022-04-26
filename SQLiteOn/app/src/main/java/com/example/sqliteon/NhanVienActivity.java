package com.example.sqliteon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {

    EditText id;
    EditText ten;
    EditText ngaySinh;
    Spinner id_Pb;
    DBHepler dbHepler;
    String id_Pb_NV;
    GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        id_Pb = findViewById(R.id.id_PB2);
        dbHepler = new DBHepler(this);

        id = findViewById(R.id.id_NV2);
        ten = findViewById(R.id.id_tenNV);
        ngaySinh = findViewById(R.id.ngaySinh);
        gv = findViewById(R.id.GridViewNV);

        List<String> ids = new ArrayList<String>();
        List<PhongBan> ls = new ArrayList<PhongBan>();
        ls = dbHepler.getAllPhongBan();
        for (PhongBan p : ls){
            ids.add(String.valueOf(p.getId_PB()));
        }



        ArrayAdapter adapter = new ArrayAdapter(getApplication(), android.R.layout.simple_spinner_item, ids);
        id_Pb.setAdapter(adapter);

        id_Pb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_Pb_NV = (String)adapterView.getAdapter().getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btn_Save =  findViewById(R.id.id_saveNV);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = new NhanVien(Integer.parseInt(id.getText().toString()), ten.getText().toString(), ngaySinh.getText().toString(), Integer.parseInt(id_Pb_NV));
                if(dbHepler.insertNV(nhanVien))
                    Toast.makeText(getApplicationContext(), "Save Thanh Cong ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Save Thanh Cong ", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_Tim = findViewById(R.id.id_TK);
        btn_Tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idT =  Integer.parseInt(id.getText().toString());
                NhanVien nv = dbHepler.getNhanVien(idT);
                List<String> ls = new ArrayList<String>();
                if (nv != null){
                    ls.add(String.valueOf(nv.getId()));
                    ls.add(nv.getTen());
                    ls.add(nv.getNgaySinh());
                    ls.add(String.valueOf(nv.getId_PB()));
                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, ls);
                    gv.setAdapter(adapter);
                }else
                    Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();

            }
        });

    }

}