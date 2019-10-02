package _main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;

import com.leonardo.dogvacina.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar2);

        CountDownTimer cd = new CountDownTimer(4000,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setProgress( Integer.parseInt(String.valueOf(millisUntilFinished )));
            }

            @Override
            public void onFinish() {

                irParaTarefas(null);
            }
        }.start();
    }

    public void irParaTarefas(View v){

        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }

}
