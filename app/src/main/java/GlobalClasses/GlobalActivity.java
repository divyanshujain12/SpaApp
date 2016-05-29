package GlobalClasses;

import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.SpaApp.Utils.CallBackInterface;
import com.example.lenovo.SpaApp.Utils.SnackBarCallback;
import com.example.lenovo.SpaApp.Utils.UpdateUiCallback;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class GlobalActivity extends AppCompatActivity implements CallBackInterface,SnackBarCallback,UpdateUiCallback{
    @Override
    public void onJsonObjectSuccess(JSONObject object) {

    }

    @Override
    public void onJsonArrarSuccess(JSONArray array) {

    }

    @Override
    public void onFailure(String str) {

    }

    @Override
    public void doAction() {

    }

    @Override
    public void updateUi(String string) {

    }
}
