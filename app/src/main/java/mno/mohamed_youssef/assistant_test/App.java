package mno.mohamed_youssef.assistant_test;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Mohamed Yossif on 01/05/2016.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
