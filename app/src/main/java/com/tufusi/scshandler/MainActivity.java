package com.tufusi.scshandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tvSHowMsg);
        findViewById(R.id.btnSendMsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.what = 99;
                message.obj = "七夕快乐哟小妹";
                mHandler.sendMessage(message);
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 99:
                    mTextView.setText(String.valueOf("接收消息：" + msg.obj));
                    break;
                default:
                    break;
            }
        }
    };
}