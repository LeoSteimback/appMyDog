package _pet;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.leonardo.dogvacina.R;

import java.util.ArrayList;

public class PetsAdapter extends RecyclerView.Adapter {

    private ArrayList<Pet> pets;
    private Context context;

    public PetsAdapter(ArrayList<Pet> pets, Context context) {
        this.pets = pets;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.pets = pets;
        this.context = context;

        // MOSTRA O PET.XML NA LINA DA LISTA
        View view = LayoutInflater.from(context).inflate(R.layout. pet, parent, false);
        final PetsAdapterViewHolder holder = new PetsAdapterViewHolder(view);

        holder.nomePet.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Loongo click",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        /*holder.nomeVacina.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                switch ( event.getAction() ){

                    case  DragEvent.ACTION_DRAG_STARTED:

                    Toast.makeText(v.getContext(),"Inicio do arrasto...", Toast.LENGTH_LONG).show();

                    break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Toast.makeText(v.getContext(),"Fim do arrasto...", Toast.LENGTH_LONG).show();
                    break;
                }

                return false;
            }
        });*/


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final PetsAdapterViewHolder holder =  (PetsAdapterViewHolder) viewHolder;
        final Pet pet = pets.get(position) ;


        //holder.nomeVacina.setText(String.valueOf( vacina.getId() ));
        holder.nomePet.setText(pet.getNome().toUpperCase());
        holder.nascimentoPet.setText(pet.getNome().toUpperCase());
        holder.sexoPet.setAdapter(((PetsAdapterViewHolder) viewHolder).sexoPet.getAdapter());
        holder.racaPet.setText(pet.getRaca().toUpperCase());

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    /**
     * Obtém a lista de vacinas
     * @return
     */
    public ArrayList<Pet> getPets(){
        return this.pets;
    }


}

