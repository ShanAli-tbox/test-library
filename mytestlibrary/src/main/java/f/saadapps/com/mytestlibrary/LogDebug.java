package f.saadapps.com.mytestlibrary;

import android.util.Log;

/**
 * Created by FocusTeck on 4/23/2018.
 */

public class LogDebug {

    private static final String DEBUG = "DebugLogs";

    public static void printLog(String string){
        Log.d(DEBUG , string);
    }

}
