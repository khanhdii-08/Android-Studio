package com.example.uidemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
    private List<NhanVien> nv_list = new ArrayList<NhanVien>();
    private String[] dv_list;
    private String donVi;
    private ImageView img;
    private Bitmap bit =null;


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

    private void ghiNhanVien(){

    }

    private void docNhanVien(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Exit = findViewById(R.id.btn_Exits);
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

        ListView lv_Nv = findViewById(R.id.ls_view);

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
                        if(!nv_list.contains(nv)){
                            nv_list.add(nv);
                            Toast.makeText(MainActivity.this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Thêm nhân viên thất bại", Toast.LENGTH_SHORT).show();

                        }

                        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(MainActivity.this, R.layout.custom_list_view, nv_list);
                        lv_Nv.setAdapter(nhanVienAdapter);

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

            }
        });

    }


}