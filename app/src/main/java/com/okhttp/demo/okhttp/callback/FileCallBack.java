package com.okhttp.demo.okhttp.callback;

import com.okhttp.demo.okhttp.utils.OkHttpUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 文件下载
 * Created by 64860 on 2017/8/14.
 */

public abstract class FileCallBack extends Callback<File> {
    /**
     * 目标文件存储的文件夹路径
     */
    private String destFileDir;
    /**
     * 目标文件存储的文件名
     */
    private String destFileName;

    /**
     * 构造函数
     * @param destFileDir
     * @param destFileName
     */
    public FileCallBack(String destFileDir, String destFileName){
        this.destFileDir = destFileDir;
        this.destFileName = destFileName;
    }

    @Override
    public File parseNetworkResponse(Response response, int id, Class<File> cls) throws Exception {
        return saveFile(response, id);
    }

    public File saveFile(Response response, final int id) throws IOException{
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            final long total = response.body().contentLength();
            long sum = 0;
            File dir = new File(destFileDir);
            if (!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(dir, destFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read()) != -1){
                sum += len;
                fos.write(buf, 0, len);
                final long finalSum = sum;
                OkHttpUtils.getInstance().getDelivery().execute(new Runnable() {
                    @Override
                    public void run() {
                        inProgress(finalSum * 1.0f / total, total, id);
                    }
                });
            }
            fos.flush();
            return file;
        } finally {
            try {
                response.body().close();
                if (is != null){
                    is.close();
                }
            } catch (IOException e){

            }
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e){

            }
        }

    }

}
