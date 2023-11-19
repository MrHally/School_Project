package com.example.quanlytaphoaver1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    private ListView lv_MH;
    int requestCode;
    private ImageButton bt_new;
    private ImageButton bt_scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setAdapter();
        bt_new.setOnClickListener(v -> {
            Intent newIntent = new Intent(this, MainActivity_ChiTiet.class);
            startActivityForResult(newIntent, requestCode);
        });
        bt_scan.setOnClickListener(v -> scanCode());
        lv_MH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MatHang mh = (MatHang) lv_MH.getItemAtPosition(position);
                Intent CheckMH = new Intent(getApplicationContext(), MainActivity_ChiTiet.class);
                CheckMH.putExtra(MatHang.MH_Edit, mh.getID());
                startActivityForResult(CheckMH, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), MatHang.ArrayList_MH);
            adapter.clear();
            setAdapter();
        }
    }
    private void setAdapter()
    {
        DBManager dbManager = new DBManager(this);
        dbManager.getMHfromDB();
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), MatHang.ArrayList_MH);
        adapter.notifyDataSetChanged();
        lv_MH.setAdapter(adapter);
    }

    private void initWidget()
    {
        lv_MH = findViewById(R.id.lv_MH);
        bt_new = findViewById(R.id.bt_plus);
        bt_scan = findViewById(R.id.bt_scan);
    }
    public void scanCode(){
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volumn up to enabled flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if(result.getContents() != null) {
            MatHang mh = MatHang.getMHID(Integer.parseInt(result.getContents()));
            if (mh != null && mh.getID() == Integer.parseInt(result.getContents())) {
                Intent CheckMH = new Intent(getApplicationContext(), MainActivity_ChiTiet.class);
                CheckMH.putExtra(MatHang.MH_Edit, mh.getID());
                startActivityForResult(CheckMH, requestCode);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("System");
                builder.setMessage("Tìm mã không thành công, Bạn có muôn tạo đơn hàng mới không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBManager db = new DBManager(MainActivity.this);
                        int id = Integer.parseInt(result.getContents());
                        MatHang mh = new MatHang(id, "", "", 0);
                        MatHang.ArrayList_MH.add(mh);
                        db.addMHtoDB(mh);
                        Intent CheckMH = new Intent(MainActivity.this, MainActivity_ChiTiet.class);
                        CheckMH.putExtra(MatHang.MH_Edit, Integer.parseInt(result.getContents()));
                        startActivityForResult(CheckMH, requestCode);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        }
    });
}