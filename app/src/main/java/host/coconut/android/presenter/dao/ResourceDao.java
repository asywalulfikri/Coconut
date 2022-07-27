package host.coconut.android.presenter.dao;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import host.coconut.android.model.api.Api;
import host.coconut.android.model.api.request.Login2RequestModel;
import host.coconut.android.model.api.request.PhoneRequestModel;
import retrofit2.Callback;

/**
 * Created by arysuryawan on 8/19/17.
 */

public class ResourceDao extends BaseDao {

    public ResourceDao(BaseActivity ac) {
        super(ac);
    }

    public void getSourcesDAO(BaseActivity ac, Callback callback) {
        Api.doApiSources(ac, callback);
    }

    public void getArticleDAO(BaseActivity ac, Callback callback) {
        Api.doApiArticles(ac, callback);
    }

    public void postPhoneNumber(String phone, BaseActivity ac, Callback callback){
        Api.doTestFin(phone, ac, callback);
    }

    public void postPhoneNumber2(PhoneRequestModel model, BaseActivity ac, Callback callback){
//        Api.doTestFin2(model, ac, callback);
        Api.checkAppVersion(ac, callback);
    }


    public void onLogin(Login2RequestModel model, BaseActivity ac, Callback callback) {
        Api.onApiLogin(model, ac, callback);
    }
}
