package com.okhttp.demo.okhttp.request;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * 计算请求体
 * Created by hongmingwei on 2017/2/28 11:21
 */
public class CountingRequestBody extends RequestBody {

    private RequestBody requestBody;
    private Listener listener;
    private MyForwardingSink forwardingSink;

    public CountingRequestBody(RequestBody requestBody, Listener listener){
        this.requestBody = requestBody;
        this.listener = listener;
    }

    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() {
        try {
            return requestBody.contentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        forwardingSink = new MyForwardingSink(sink);
        BufferedSink bufferedSink = Okio.buffer(forwardingSink);
        requestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    private final class MyForwardingSink extends ForwardingSink{
        private long byteWritten = 0;

        public MyForwardingSink(Sink sink){
            super(sink);
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            super.write(source, byteCount);
            byteWritten += byteCount;
            listener.onRequestProgress(byteWritten, contentLength());
        }
    }

    public interface Listener{
        void onRequestProgress(long bytesWritten, long contentLength);
    }
}
