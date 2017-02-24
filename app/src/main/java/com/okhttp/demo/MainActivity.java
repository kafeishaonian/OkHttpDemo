package com.okhttp.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.okhttp.demo.model.UserModel;
import com.okhttp.demo.okhttp.HttpTaskManager;
import com.okhttp.demo.okhttp.ServerErrorCode;
import com.okhttp.demo.okhttp.callback.UserCallBack;
import com.okhttp.demo.okhttp.utils.DataRequestUtils;
import com.okhttp.demo.okhttp.utils.OkHttpUtils;

import okhttp3.Call;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initData(){
        HttpTaskManager.startStringRequest(
                DataRequestUtils.getTline(TAG, "catch"), new UserCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }
                    @Override
                    public void onResponse(Object responst, int resultCode) {
                        if (ServerErrorCode.STATUS_SUCCESS == resultCode) {
                            UserModel model = (UserModel) responst;
                            Log.e(TAG, model.getItem().getProfitShowList().get(1).getProfit()  +"" + resultCode);
                        }
                    }
                }, UserModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.cancelTag(TAG);
    }
}
