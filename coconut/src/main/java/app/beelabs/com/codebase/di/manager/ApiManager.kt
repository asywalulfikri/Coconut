package app.beelabs.com.codebase.di.manager

import app.beelabs.com.codebase.base.BaseManager
import app.beelabs.com.codebase.di.IApi
import app.beelabs.com.codebase.di.IApiService
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Created by arysuryawan on 8/21/17.
 */
class ApiManager : BaseManager(), IApi {
    private var api: Any? = null
    private var apiDomain = ""
    override fun initApiService(apiDomain: String, allowUntrusted: Boolean, clazz: Class<IApiService>, timeout: Int, enableLoggingHttp: Boolean, PedePublicKeyRSA: String): Any {
        if (api == null || this.apiDomain != apiDomain) {
            val retrofit = Retrofit.Builder()
                .baseUrl(apiDomain)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(getHttpClient(allowUntrusted, timeout, enableLoggingHttp, PedePublicKeyRSA))
                .build()
            api = retrofit.create(clazz)
            this.apiDomain = apiDomain
        }
        return api!!
    }

    override fun initApiService(
        apiDomain: String,
        allowUntrusted: Boolean,
        clazz: Class<IApiService>,
        timeout: Int,
        enableLoggingHttp: Boolean,
        PedePublicKeyRSA: String,
        interceptor: Interceptor
    ): Any {
        if (api == null || this.apiDomain != apiDomain) {
            val retrofit = Retrofit.Builder()
                .baseUrl(apiDomain)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(getHttpClient(allowUntrusted, timeout, enableLoggingHttp, PedePublicKeyRSA,interceptor))
                .build()
            api = retrofit.create(clazz)
            this.apiDomain = apiDomain
        }
        return api!!
    }

    override fun initApiService(
        apiDomain: String,
        allowUntrusted: Boolean,
        clazz: Class<IApiService>,
        timeout: Int,
        enableLoggingHttp: Boolean,
        PedePublicKeyRSA: String,
        appInterceptor: Array<Interceptor>,
        netInterceptor: Array<Interceptor>
    ): Any {
        if (api == null || this.apiDomain != apiDomain) {
            val retrofit = Retrofit.Builder()
                .baseUrl(apiDomain)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(getHttpClient(allowUntrusted, timeout, enableLoggingHttp,
                        PedePublicKeyRSA, appInterceptor, netInterceptor))
                .build()
            api = retrofit.create(clazz)
            this.apiDomain = apiDomain
        }
        return api!!
    }
}