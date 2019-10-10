package _pet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.leonardo.dogvacina.R;

public class PetActivity extends AppCompatActivity {

    final int REQUEST_CAMERA = 100;
    final PetsDB pdb = new PetsDB(this,"db_dogvacina.db",1);
    ImageView imageViewFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 0);
        }

        imageViewFoto = (ImageView) findViewById(R.id.imgFoto);
        findViewById(R.id.btnFoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });
    }

    public  void tirarFoto(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap)extras.get("data");
            imageViewFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void camera(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_CAMERA);
    }

    // btn cadastro Pet -------
    public void cadastroPet (View v){

        AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());
        final View cadastro = LayoutInflater.from(this).inflate(R.layout.cadastro_pet,null);


        // ---- btnSalvar -----
        Button btnSalvar = (Button) cadastro.findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                //Log.i("LOG", " - Botão pressionado" );

                String nome = ((EditText) cadastro.findViewById(R.id.txtNomePet) ).getText().toString() ;
                String nascimento = ((EditText) cadastro.findViewById(R.id.txtNascimento)).getText().toString();
                Spinner spn = (Spinner) cadastro.findViewById(R.id.spinnerSexo);
                String raca = ((EditText) cadastro.findViewById(R.id.txtRaca)).getText().toString();

                //Log.i("LOG",  nome);

                String sexo = spn.getSelectedItem().toString();

                Pet pet = new Pet();
                pet.setNome(nome);
                pet.setNascimento(nascimento);
                pet.setSexo(sexo);
                pet.setRaca(raca);

                pdb.inserirPet(pet);

                Toast.makeText(v.getContext(),"informações salva com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
        // ---- fim do btnSalvar -----

        // ---- btnEditar -----
        Button btnEditar = (Button) cadastro.findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


            }

        });


        // ---- fim do btnEditar -----
        dialogo.setView(cadastro);

        dialogo.show();

    }

    //fim  btn cadastro Pet -------

}
