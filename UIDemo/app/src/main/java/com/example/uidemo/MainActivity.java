package com.example.uidemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
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

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> listNV =new ArrayList<>();
    String[] listDv;
    String donVi;
    EmployeeAdapter employeeAdapter;
    private ImageView img;
    private Bitmap bit =null;
    int vitri=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.et_name);
        EditText ma = findViewById(R.id.et_ma);
        RadioGroup rgSex = findViewById(R.id.rg_sex);
        RadioButton rbNam = findViewById(R.id.rb_nam);
        RadioButton rbNu = findViewById(R.id.rb_nu);
        Button btnThem = findViewById(R.id.btn_them);
        Button btnSua = findViewById(R.id.btn_sua);
        Button btnTruyVan = findViewById(R.id.btn_truyvan);
        ListView lvNV = findViewById(R.id.listview_ui);
        Spinner spDonVi = findViewById(R.id.spinner_ui);
        Button btnImg = findViewById(R.id.btn_img);
         img = findViewById(R.id.imv_img);


        listDv = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listDv);

        spDonVi.setAdapter(adapter);
        spDonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = listDv[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(ma.getText().toString());
                String ten = name.getText().toString();
                String gioiTinh =((RadioButton)findViewById(rgSex.getCheckedRadioButtonId())).getText().toString();
                Bitmap im = bit;

                NhanVien nv = new NhanVien(id,ten,gioiTinh,donVi,im);

                listNV.add(nv);
              //  System.out.println(listNV.get(0));
                //Log.wtf("xx", String.valueOf(listNV.get(0)));
//                ArrayList<String> listItems = new ArrayList<>();
//                for(NhanVien nv1: listNV)
//                    listItems.add(nv1.toString());
                //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.custom_list_view,listItems);
                employeeAdapter = new EmployeeAdapter(MainActivity.this,R.layout.custom_list_view,listNV);
                lvNV.setAdapter(employeeAdapter);
            }
        });
        lvNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=i;
                NhanVien nv = listNV.get(i);
                ma.setText(nv.getMaNV()+"");
                name.setText(nv.getName());


                if(nv.getGioiTinh().equals("nam")){
                    rbNam.setChecked(true);
                }
                else{
                    rbNu.setChecked(true);
                }
                for(int j=0;j<listDv.length;j++){
                    if(listDv[j].equals(nv.getDonVi()))
                        spDonVi.setSelection(j);
                }
                img.setImageBitmap(nv.getImg());
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso= Integer.parseInt(ma.getText().toString());
                String hoten = name.getText().toString();
                String gioitinh =((RadioButton)findViewById(rgSex.getCheckedRadioButtonId())).getText().toString();
                Bitmap image=bit;
                NhanVien nv = new NhanVien(maso,hoten,gioitinh,donVi,image);
                listNV.set(vitri,nv);
                EmployeeAdapter adapterListNV = new EmployeeAdapter(MainActivity.this,R.layout.custom_list_view,listNV);
                lvNV.setAdapter(adapterListNV);
            }
        });
        btnTruyVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNV.remove(vitri);
                EmployeeAdapter adapterListNV = new EmployeeAdapter(MainActivity.this,R.layout.custom_list_view,listNV);
                lvNV.setAdapter(adapterListNV);
            }
        });



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


}