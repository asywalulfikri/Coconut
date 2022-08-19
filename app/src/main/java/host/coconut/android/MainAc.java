package host.coconut.android;

import android.os.Bundle;
import android.util.Log;


import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.base.response.BaseResponse;
import host.coconut.android.model.api.request.PhoneRequestModel;
import host.coconut.android.presenter.dao.ResourceDao;
import retrofit2.Response;

class MainAc extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showApiProgressDialog(App.getAppComponent(), new ResourceDao(this) {
            @Override
            public void call() {
                this.postPhoneNumber2(
                        new PhoneRequestModel("081212341212"), MainAc.this, BaseDao.getInstance(this, IConfig.KEY_CALLER_API_SOURCE).callback);
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
