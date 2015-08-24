package movil.salt.services1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import movil.salt.services1.Services.ReproductorService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    TextView txt;
    Button btnPlay,btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPause = (Button) findViewById(R.id.btn_pause);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        intent = new Intent(this, ReproductorService.class);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_play:
                startService(intent);
                break;
            case R.id.btn_pause:
                stopService(intent);
                break;
        }
    }
}
