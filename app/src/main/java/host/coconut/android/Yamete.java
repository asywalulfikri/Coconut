package host.coconut.android;

import android.os.Bundle;
import android.util.Log;


import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.base.response.BaseResponse;
import host.coconut.android.model.api.request.Login2RequestModel;
import host.coconut.android.model.api.request.PhoneRequestModel;
import host.coconut.android.presenter.dao.ResourceDao;
import retrofit2.Response;

public class Yamete extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showApiProgressDialog(App.getAppComponent(), new ResourceDao(this) {
            @Override
            public void call() {
//                LoginRequestModel model = new LoginRequestModel(
//                        "08568742365",
//                        "123123",
//                        "xxxxxx",
//                        "yyyyyyy");

                Login2RequestModel model = new Login2RequestModel("https://indoalliz-test.apigee.net/", "POST",
                        new Login2RequestModel.DataRequestModel("08568742365", "123123", "xxxxxx", "yyyyyyy"));

                new ResourceDao(Yamete.this)
                        .onLogin(model, Yamete.this,
                                ResourceDao.getInstance(Yamete.this, 1).callback);

//                new ResourceDao(MainActivity.this)
//                        .onLogin(model, MainActivity.this,
//                                ResourceDao.getInstance(MainActivity.this, 1).callback);
            }
        });



    }

    private void x111(){
        showApiProgressDialog(App.getAppComponent(), new ResourceDao(this) {
            @Override
            public void call() {
                this.postPhoneNumber2(
                        new PhoneRequestModel("081212341212"), Yamete.this, BaseDao.getInstance(this, IConfig.KEY_CALLER_API_SOURCE).callback);
            }
        }, "Loading", false);
    }

    @Override
    protected void onApiResponseCallback(BaseResponse mr, int responseCode, Response response) {
        switch (responseCode) {
            case 1:
//                LoginResponseModel model = (LoginResponseModel) mr;
                Log.d("", "");
                break;

            default:
                // line default code
        }
    }




}

