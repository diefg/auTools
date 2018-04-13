package fredes.diego.tools;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private ToggleButton toggle;
    private WifiManager wifiManager;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiManager = (WifiManager)this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        toggle = (ToggleButton) findViewById(R.id.toggleWifi);
        toggle.setChecked(wifiManager.isWifiEnabled());
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean estadoBoton;
                estadoBoton = toggle.isChecked();
                wifiManager.setWifiEnabled(estadoBoton);
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        toggle.setChecked(wifiManager.isWifiEnabled());
    }

    public void cambiarTeclado(View view){
        InputMethodManager ime=(InputMethodManager)this.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(ime!=null) {
            ime.showInputMethodPicker();
        }
    }

    public void salir(View view) {
        finish();
    }

}
