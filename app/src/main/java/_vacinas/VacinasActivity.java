package _vacinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leonardo.dogvacina.R;

import java.util.ArrayList;

public class VacinasActivity extends AppCompatActivity {

    private VacinasAdapter vacinasAdapter;
    private ArrayList<Vacina> vacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);
    }
}
