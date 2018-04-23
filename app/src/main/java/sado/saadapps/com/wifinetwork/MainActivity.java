package sado.saadapps.com.wifinetwork;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SimpleInterface {
    WifiManager mainWifiObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainWifiObj = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    @Override
    public void printMessage(String message) {
        Toast.makeText(this , message ,Toast.LENGTH_SHORT).show();
    }

    public void scanWifi(View view){
        Button button = (Button) view;
     /*   WifiInfo info = mainWifiObj.getConnectionInfo();
        int nID =  info.getNetworkId();
        String bid = info.getBSSID();
        int content = info.describeContents();
        String sid = info.getSSID();
        String mac = info.getMacAddress();
        int ip = info.getIpAddress();
        int rss = info.getRssi();
        mainWifiObj.startScan();
        List<ScanResult> wifiScanList = mainWifiObj.getScanResults();
        String data = wifiScanList.get(0).toString();
        ScanResult result = wifiScanList.get(1);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            String vN = (String) result.venueName;
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            String fN  = (String) result.operatorFriendlyName;
        }

       List<WifiConfiguration> configuration =  mainWifiObj.getConfiguredNetworks();
       String string = configuration.get(0).preSharedKey;*/

        Intent service = new Intent(MainActivity.this, ForeGroundService.class);
        if (!ForeGroundService.IS_SERVICE_RUNNING) {
            service.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
            ForeGroundService.IS_SERVICE_RUNNING = true;
            button.setText("Stop Service");
        } else {
            service.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
            ForeGroundService.IS_SERVICE_RUNNING = false;
            button.setText("Start Service");

        }
        startService(service);
    }

}
