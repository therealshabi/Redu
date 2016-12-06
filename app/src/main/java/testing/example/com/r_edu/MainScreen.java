package testing.example.com.r_edu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MainScreen extends AppCompatActivity {

    RadioButton cs;
    RadioButton cp;
    RadioButton ece;
    RadioButton com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redu_main_screen);

        cs = (RadioButton) findViewById(R.id.activity_redu_main_screen_cs);
        cp = (RadioButton) findViewById(R.id.activity_redu_main_screen_cp);
        ece = (RadioButton) findViewById(R.id.activity_redu_main_screen_ece);
        com = (RadioButton) findViewById(R.id.activity_redu_main_screen_com);

        RadioListeners();

    }

    private void RadioListeners() {

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cp.setChecked(false);
                ece.setChecked(false);
                com.setChecked(false);
                Intent intent = new Intent(MainScreen.this, StreamActivity.class);
                intent.putExtra("EXTRA_CATEGORY", "cs");
                startActivity(intent);
            }
        });

        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cs.setChecked(false);
                ece.setChecked(false);
                com.setChecked(false);
                Intent intent = new Intent(MainScreen.this, StreamActivity.class);
                intent.putExtra("EXTRA_CATEGORY", "cp");
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cp.setChecked(false);
                cs.setChecked(false);
                com.setChecked(false);
                Intent intent = new Intent(MainScreen.this, StreamActivity.class);
                intent.putExtra("EXTRA_CATEGORY", "ece");
                startActivity(intent);
            }
        });

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cp.setChecked(false);
                cs.setChecked(false);
                ece.setChecked(false);
                Intent intent = new Intent(MainScreen.this, StreamActivity.class);
                intent.putExtra("EXTRA_CATEGORY","com");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cp.setChecked(false);
        cs.setChecked(false);
        com.setChecked(false);
        ece.setChecked(false);
    }
}
