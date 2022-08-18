package host.coconut.android

import android.os.Bundle
import app.beelabs.com.codebase.base.BaseActivity
import host.coconut.android.model.api.request.PhoneRequestModel
import host.coconut.android.presenter.dao.ResourceDao

class Main : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(App.getAppComponent()!=null){
            setToast("tidak null")
            showApiProgressDialog(App.getAppComponent(), object : ResourceDao(this) {
                override fun call() {
                    postPhoneNumber2(
                        PhoneRequestModel("081212341212"),
                        this@Main,
                        getInstance(this, IConfig.KEY_CALLER_API_SOURCE).callback
                    )
                }
            }, "Loading", false)
        }else{
            setToast("null ges")
        }



    }

}