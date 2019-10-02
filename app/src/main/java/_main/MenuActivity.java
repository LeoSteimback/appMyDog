package _main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.leonardo.dogvacina.R;

import _pet.PetActivity;
import _vacinas.VacinasActivity;
import _veterinario.VeterinarioActivity;

public class MenuActivity extends AppCompatActivity {

    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void vacinas(View v){
        Intent i = new Intent();
        i.setClass(MenuActivity.this, VacinasActivity.class);
        startActivity(i);
    }

    public void pet(View v){
        Intent i = new Intent();
        i.setClass(MenuActivity.this, PetActivity.class);
        startActivity(i);
    }


    public void veterinario(View v){
        Intent i = new Intent();
        i.setClass(MenuActivity.this, VeterinarioActivity.class);
        startActivity(i);
    }
}
