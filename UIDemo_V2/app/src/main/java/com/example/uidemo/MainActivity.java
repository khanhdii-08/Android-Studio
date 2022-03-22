package com.example.uidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity {

    private String[] dv_list;
    private String donVi;
    private ImageView img;
    private Bitmap bit =null;
    private ListNhanVien ls_nv;
    private ListView lv_Nv;
    private int vitri = -1;
    public MainActivity(){
        ls_nv = new ListNhanVien();
    }
    private void requestPermissions(){
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openImagePicker();
                Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }
    private  void openImagePicker(){
        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
            @Override
            public void onImageSelected(Uri uri) {
                try {
                    bit = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    img.setImageBitmap(bit);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(MainActivity.this)
                .setOnImageSelectedListener(listener)
                .create();
        tedBottomPicker.show(getSupportFragmentManager());
    }

//    public void writeData(ArrayList<NhanVien> ls){
//        try{
//            String filename = "nhanvien.txt";
//            Gson gson = new Gson();
//            String json = gson.toJson(ls);
//            FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
//            fout.write(json.getBytes());
//            fout.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<NhanVien> readData(){
//        ArrayList<NhanVien> ls = new ArrayList<>();
//        try {
//            Gson gson = new Gson();
//            String filename = "nhanvien.txt";
//            String json = ""; int c;
//            FileInputStream fin = openFileInput(filename);
//
//            StringBuffer sbuffer = new StringBuffer();
//            int i;
//            while ((i = fin.read()) != -1)
//                sbuffer.append((char)i);
//            fin.close();
//            json = sbuffer.toString();
//            Type type = new TypeToken < List < NhanVien >> () {}.getType();
//            if(json.length() > 0){
//                ls = gson.fromJson(json, type);
//                Toast.makeText(MainActivity.this, "Đọc thành công", Toast.LENGTH_SHORT).show();
//            }else
//                Toast.makeText(MainActivity.this, "Đọc thất bại", Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return ls;
//    }

    public void writeData(ArrayList<NhanVien> ls){
        try{
            SharedPreferences myPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = myPrefs.edit();

            Gson gson = new Gson();
            String json = gson.toJson(ls);
            prefsEditor.putString("nhanvien", json);
            prefsEditor.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<NhanVien> readData(){
        ArrayList<NhanVien> ls = new ArrayList<>();
        try {
            SharedPreferences myPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
            Gson gson = new Gson();
            String json;
            json = myPrefs.getString("nhanvien", null);
            Type type = new TypeToken < List < NhanVien >> () {}.getType();
            if(json.length() > 0){
                ls = gson.fromJson(json, type);
                Toast.makeText(MainActivity.this, "Đọc thành công", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(MainActivity.this, "Đọc thất bại", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }

    public void upListView(ArrayList<NhanVien> ls){
        try {
            NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(MainActivity.this, R.layout.custom_list_view, ls);
            lv_Nv.setAdapter(nhanVienAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_ma = findViewById(R.id.id_ma);
        EditText ed_ten = findViewById(R.id.id_name);
        RadioGroup rg_GioiTinh = findViewById(R.id.radioGroup);
        RadioButton rb_nam = findViewById(R.id.rd_nam);
        RadioButton rb_nu = findViewById(R.id.rd_nu);
        img = findViewById(R.id.image_NV);

        Button btn_Them = findViewById(R.id.them_btn);
        Button btn_Sua = findViewById(R.id.sua_btn);
        Button btn_TruyVan = findViewById(R.id.truyvan_btn);

        Button btn_Chon = findViewById(R.id.btn_Chon);

        lv_Nv = findViewById(R.id.ls_view);

        Spinner sp_DonVi = findViewById(R.id.id_sp);
        dv_list = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dv_list);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dv_list[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_Chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions();
            }
        });

        btn_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int maso = Integer.parseInt(ed_ma.getText().toString().trim());
                    String ten = ed_ten.getText().toString();
                    String gioiTinh = ((RadioButton)findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                    if(bit == null )
                        Toast.makeText(MainActivity.this, "Vui lòng chọn hình ảnh nhân viên", Toast.LENGTH_SHORT).show();
                    else{
                        NhanVien nv = new NhanVien(maso, ten, gioiTinh, donVi, bit);
                        if(ls_nv.addNhanVien(nv)){
                            Toast.makeText(MainActivity.this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Thêm nhân viên thất bại", Toast.LENGTH_SHORT).show();

                        upListView(ls_nv.getAllNhanVien());

                        ed_ma.setText("");
                        ed_ten.setText("");
                        rb_nam.setChecked(false);
                        rb_nu.setChecked(false);
                        img.setImageResource(R.mipmap.ic_launcher);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Dữ liệu nhập vào sai định dạng", Toast.LENGTH_SHORT).show();

                }

            }
        });

        lv_Nv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(lv_Nv.getAdapter().getItem(i));
            }
        });
        btn_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso= Integer.parseInt(ed_ma.getText().toString());
                String hoten = ed_ten.getText().toString();
                String gioitinh =((RadioButton)findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                Bitmap image=bit;
                NhanVien nv = new NhanVien(maso,hoten,gioitinh,donVi,image);
                ls_nv.set(vitri,nv);
                EmployeeAdapter adapterListNV = new EmployeeAdapter(MainActivity.this,R.layout.custom_list_view,listNV);
                lvNV.setAdapter(adapterListNV);
            }
        });
        btn_TruyVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNV.remove(vitri);
                EmployeeAdapter adapterListNV = new EmployeeAdapter(MainActivity.this,R.layout.custom_list_view,listNV);
                lvNV.setAdapter(adapterListNV);
            }
        });

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
            case R.id.mn_ghi:{
                if(ls_nv.getAllNhanVien().size() > 0){
                    writeData(ls_nv.getAllNhanVien());
                    Toast.makeText(MainActivity.this, "Ghi thành công", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Ghi thất bại", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mn_doc:{
                try {
                    System.out.println(readData());
//                    upListView(readData());
                    ArrayList<String> listItems = new ArrayList<>();
                    for (NhanVien s : readData()){
                        listItems.add(s.toString());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
                    lv_Nv.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}