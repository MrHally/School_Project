package com.example.quanlytaphoaver1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<MatHang> {

    public CustomAdapter(Context context, List<MatHang> MHs) {
        super(context, 0, MHs);
    }

    private String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MatHang mh = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_mathang, parent, false);
        }

        TextView idhang = convertView.findViewById(R.id.ID);
        TextView tenhang = convertView.findViewById(R.id.nameID);
        TextView theloai = convertView.findViewById(R.id.NoiDung);
        TextView giatien = convertView.findViewById(R.id.GiaTien);

        idhang.setText(mh.getID() + "");
        tenhang.setText(mh.getTenHang());
        theloai.setText(mh.getTheLoai());
        giatien.setText(formatNumber(mh.getGiaTien()) + "đ");

        return convertView;
    }
}
