package app.beelabs.com.codebase.di;


import android.content.Context;

import okhttp3.Interceptor;

public interface IApi {
    Object initApiService(String apiDomain, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp, String PedePublicKeyRSA);

    Object initApiService(Context context,String apiDomain, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp, String PedePublicKeyRSA, Interceptor interceptor);

    Object initApiService(String apiDomain, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp, String PedePublicKeyRSA, Interceptor interceptor);

    Object initApiService(String apiDomain, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp, String PedePublicKeyRSA, Interceptor[] appInterceptor, Interceptor[] netInterceptor);

}
