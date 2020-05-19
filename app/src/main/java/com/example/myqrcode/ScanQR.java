package com.example.myqrcode;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanQR extends AppCompatActivity {
    private IntentIntegrator qrScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); //default가 세로모드인데 휴대폰 방향에 따라 가로 , 세로로 자동변경
        qrScan.setPrompt("바코드를 사각형 안에 비춰주세요");
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "스캔실패", Toast.LENGTH_LONG).show();
                //todo
            } else {
                Toast.makeText(this, "스캔완료 :" + result.getContents() , Toast.LENGTH_LONG).show();
                //todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
