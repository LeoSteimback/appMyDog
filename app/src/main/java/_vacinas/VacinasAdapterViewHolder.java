package _vacinas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonardo.dogvacina.R;

public class VacinasAdapterViewHolder extends RecyclerView.ViewHolder {

    final TextView nomeVacina;

    public VacinasAdapterViewHolder(@NonNull View itemView) {
        super(itemView);

        nomeVacina = itemView.findViewById(R.id.txtNomeVacina);


    }



}