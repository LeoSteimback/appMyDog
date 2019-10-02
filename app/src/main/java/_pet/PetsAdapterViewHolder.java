package _pet;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonardo.dogvacina.R;

public class PetsAdapterViewHolder extends RecyclerView.ViewHolder {

    final TextView nomePet;
    final TextView nascimentoPet;
    final Spinner sexoPet;
    final TextView racaPet;

    public PetsAdapterViewHolder(@NonNull View itemView) {
        super(itemView);

        nomePet = itemView.findViewById(R.id.txtNomePet);
        nascimentoPet = itemView.findViewById(R.id.txtNascimento);
        sexoPet = itemView.findViewById(R.id.spinnerSexo);
        racaPet = itemView.findViewById(R.id.txtRaca);

    }



}