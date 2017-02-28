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
//        HttpTaskManager.startStringRequest(
//                DataRequestUtils.getTline(TAG, "1", "20"), new UserCallBack() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//                    @Override
//                    public void onResponse(Object responst, int resultCode) {
//                        if (ServerErrorCode.STATUS_SUCCESS == resultCode) {
//                            UserModel model = (UserModel) responst;
//                            Log.e(TAG, model.getItem().getList().get(0).getContent() + "啦啦啦啦" + resultCode);
//                        }
//                    }
//                }, UserModel.class);

        HttpTaskManager.startStringRequest(DataRequestUtils.getPost(TAG), new UserCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "啦啦啦啦啦啦" + id);
            }

            @Override
            public void onResponse(Object responst, int resultCode) {
                UserModel model = (UserModel) responst;
                Log.e(TAG, model.getMultiResult().getResults().get(0).getPicUrl() + "哈哈哈哈哈哈哈哈哈" + resultCode);
            }
        }, UserModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.cancelTag(TAG);
    }
}
