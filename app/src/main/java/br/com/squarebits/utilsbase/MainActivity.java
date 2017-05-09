package br.com.squarebits.utilsbase;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.rrsystems.utilsplus.android.UtilsPlus;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast();
        copy();
        simplyNotification();
        sharedPref();
        showDebugDBAddressLogToast(this);
    }

    public void showToast(){
         UtilsPlus.getInstance().toast("Teste de Toast!",5);
    }

    public void copy(){
        UtilsPlus.getInstance().copyToClipboard("text to be copied");
    }

    public void UtilsEdittext(){
        UtilsPlus.getInstance().checkEmailIsValid("rakshithsj30@gmail.com");
        // second parameter is country code
        UtilsPlus.getInstance().validatePhoneNumber("9480523270","91");
    }

    public void simplyNotification(){
         /*
     * Utility method which will help you to show notification in the status bar.
     * @param title title of the push notification
     * @param body content to be displayed in the notification
     * @param small_icon small icon which will be showed in the notification. should be of following format:R.drawable.imageName
     * @param large_icon Large icon which will be showed in the notification. should be of following format:R.drawable.imageName
     * @param class_name The  activity which will open on clicking notification. Parameter format: activity_name.class
     * @param autoCancel true or false. if set to true, notification will be disappeared after clicking it otherwise it will remain in the status bar
     */


        UtilsPlus.getInstance().displaySimplePushNotification("New Mesage","new message received",R.mipmap.ic_launcher,R.mipmap.ic_launcher,MainActivity.class,true);

    }

    public void getDeviceId(){
        String id = UtilsPlus.getInstance().getDeviceID();
        Log.e("",id);
    }

    public void checkService(){
//        UtilsPlus.getInstance().checkServiceIsRunning(service1.class);
    }

    public void sharedPref(){
        UtilsPlus.getInstance().put("teste", "some value");
        //UtilsPlus.getInstance().getString("key", "default");
       // UtilsPlus.getInstance().removeKey("key");
       // UtilsPlus.getInstance().clear();

    }

    public static void showDebugDBAddressLogToast(Context context) {
        if (BuildConfig.DEBUG) {
            try {
                Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
                Method getAddressLog = debugDB.getMethod("getAddressLog");
                Object value = getAddressLog.invoke(null);
                UtilsPlus.getInstance().toast((String) value,10);
            } catch (Exception ignore) {

            }
        }
    }
}
