package com.syberkeep.simplus;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Section1 extends Fragment {

    private static final int REQUEST_CODE_PERMISSION = 1001;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b_star, b_hash, b_save, b_call, b_clear;
    String number = "";
    TextView number_text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_PERMISSION);
            } else{
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_PERMISSION);
            }
        }

        View view = inflater.inflate(R.layout.activity_section1, container, false);

        number_text = (TextView) view.findViewById(R.id.number_text);

        b1 = (Button) view.findViewById(R.id.btn1);
        b2 = (Button) view.findViewById(R.id.btn2);
        b3 = (Button) view.findViewById(R.id.btn3);
        b4 = (Button) view.findViewById(R.id.btn4);
        b5 = (Button) view.findViewById(R.id.btn5);
        b6 = (Button) view.findViewById(R.id.btn6);
        b7 = (Button) view.findViewById(R.id.btn7);
        b8 = (Button) view.findViewById(R.id.btn8);
        b9 = (Button) view.findViewById(R.id.btn9);
        b0 = (Button) view.findViewById(R.id.btn0);
        b_star = (Button) view.findViewById(R.id.btn_star);
        b_hash = (Button) view.findViewById(R.id.btn_hash);
        b_save = (Button) view.findViewById(R.id.btn_save);
        b_call = (Button) view.findViewById(R.id.btn_call);
        b_clear = (Button) view.findViewById(R.id.btn_clear);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "1";
                number_text.setText(number);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "2";
                number_text.setText(number);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "3";
                number_text.setText(number);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "4";
                number_text.setText(number);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "5";
                number_text.setText(number);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "6";
                number_text.setText(number);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "7";
                number_text.setText(number);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "8";
                number_text.setText(number);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "9";
                number_text.setText(number);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "0";
                number_text.setText(number);
            }
        });
        b_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "*";
                number_text.setText(number);
            }
        });
        b_hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number += "#";
                number_text.setText(number);
            }
        });
        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Write code for saving this number as a new contact!", Toast.LENGTH_LONG).show();
            }
        });
        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "";
                number_text.setText(number);
            }
        });
        b_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number.equals("")) {
                    Toast.makeText(getActivity(), "Please enter a number to call", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent call_intent = new Intent(Intent.ACTION_CALL);
                call_intent.setData(Uri.parse("tel:" + number));
                startActivity(call_intent);
            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_PERMISSION: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getActivity(), "Permission Granted!", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getActivity(), "No Permission Granted!", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
            }
        }
    }
}
