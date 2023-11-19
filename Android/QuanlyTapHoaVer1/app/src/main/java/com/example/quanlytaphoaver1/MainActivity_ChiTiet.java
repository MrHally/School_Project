package com.example.quanlytaphoaver1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity_ChiTiet extends AppCompatActivity {

    private EditText et_tenHang, et_theLoai, et_giaTien;
    private ImageButton bt_save, bt_delete, bt_back;
    private String tenhang, theloai;
    private int giatien;
    private MatHang selectMH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_tiet);
        initWidget();
        kiemtralichsu();
        bt_save.setOnClickListener(v -> {
            tenhang = String.valueOf(et_tenHang.getText());
            theloai = String.valueOf(et_theLoai.getText());
            giatien = Integer.parseInt(et_giaTien.getText().toString());
            DBManager db = new DBManager(this);
            if(selectMH == null) {
                int id = generateRandomID(6);
                MatHang mh = new MatHang(id, tenhang, theloai, giatien);
                MatHang.ArrayList_MH.add(mh);
                db.addMHtoDB(mh);
            }else{
                selectMH.setTenHang(tenhang);
                selectMH.setTheLoai(theloai);
                selectMH.setGiaTien(giatien);
                db.updateMH(selectMH);
            }

            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent);
            finish();
        });
        bt_delete.setOnClickListener(v -> {
            DBManager db = new DBManager(this);
            selectMH.setTenHang(et_tenHang.getText().toString());
            db.deleteMH(selectMH);
            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent);
            finish();
        });
        bt_back.setOnClickListener(v ->{
            finish();
        });

    }

    private void kiemtralichsu() {
        Intent check = getIntent();
        int kiemtraid = check.getIntExtra(MatHang.MH_Edit, -1);
        selectMH = MatHang.getMHID(kiemtraid);
        if(selectMH != null){
            et_tenHang.setText(selectMH.getTenHang());
            et_theLoai.setText(selectMH.getTheLoai());
            et_giaTien.setText(selectMH.getGiaTien() + "");
        }else{
            bt_delete.setVisibility(View.INVISIBLE);
        }
    }

    public static int generateRandomID(int length) {
        String Number = "0123456789";
        Random random = new Random();
        StringBuilder randomID = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(Number.length());
            randomID.append(Number.charAt(index));
        }

        return Integer.parseInt(randomID.toString());
    }

    private void initWidget() {
        et_tenHang = findViewById(R.id.et_th);
        et_theLoai = findViewById(R.id.et_tt);
        et_giaTien = findViewById(R.id.et_gt);
        bt_save = findViewById(R.id.bt_save);
        bt_delete = findViewById(R.id.bt_delete);
        bt_back = findViewById(R.id.bt_back);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}