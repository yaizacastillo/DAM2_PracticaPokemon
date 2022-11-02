package com.example.practicapokemon.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicapokemon.R;
import com.example.practicapokemon.model.Pokemon;
import com.example.practicapokemon.model.Type;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.ViewHolder>{

    private Context mContext;
    private List<Pokemon> mPokemons;
    ImageLoader mImageLoader;

    public PokemonsAdapter (Context context, List <Pokemon> mPokemons){
        this.mContext = context;
        this.mPokemons = mPokemons;
        mImageLoader = ImageLoader.getInstance();
    }

    @NonNull
    @Override
    public PokemonsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewFila = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_pokemon, parent, false);

        return new PokemonsAdapter.ViewHolder(viewFila);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon actual = mPokemons.get(position);

        List<Type> actualTypes = actual.getTipus();

        //fons fila
        switch (actualTypes.get(0).getId()){
            case 1:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_normal));
                break;
            case 2:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_fighting));
                break;
            case 3:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_flying));
                break;
            case 4:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_poison));
                break;
            case 5:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_ground));
                break;
            case 6:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_rock));
                break;
            case 7:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_bug));
                break;
            case 8:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_ghost));
                break;
            case 9:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_steel));
                break;
            case 10:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_fire));
                break;
            case 11:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_water));
                break;
            case 12:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_grass));
                break;
            case 13:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_electric));
                break;
            case 14:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_psychic));
                break;
            case 15:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_ice));
                break;
            case 16:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_dragon));
                break;
            case 17:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_dark));
                break;
            case 18:
                holder.grdl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.type_fairy));
                break;
        }

        //id i nom
        holder.pkm_id.setText("#" + String.format("%03d", actual.getId()));
        String nom = actual.getNom();
        holder.pkm_nom.setText(nom.substring(0, 1).toUpperCase() + nom.substring(1));

        //tipus
        holder.pkm_type1.setText(actualTypes.get(0).getName().toUpperCase());

        if(actualTypes.size()>1) {
            holder.pkm_type2.setVisibility(View.VISIBLE);
            holder.pkm_type2.setText(actualTypes.get(1).getName().toUpperCase());
        }
        else
            holder.pkm_type2.setVisibility(View.GONE);

        //icon
        mImageLoader.displayImage(actual.getImageURL(), holder.pkm_icon);

        //fav
        if(actual.isFav()){
            holder.pkm_fav.setImageResource(R.drawable.fav_icon);
        }
        else{
            holder.pkm_fav.setImageResource(R.drawable.unfav_icon);
        }

        holder.pkm_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual!=null)
                    if (actual.isFav()) {
                        holder.pkm_fav.setImageResource(R.drawable.unfav_icon);
                        actual.setFav(false);
                    } else {
                        holder.pkm_fav.setImageResource(R.drawable.fav_icon);
                        actual.setFav(true);
                    }
            }
        });



    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        GridLayout grdl;
        TextView pkm_id;
        TextView pkm_nom;
        ImageView pkm_icon;
        LinearLayout pkm_types;
        TextView pkm_type1;
        TextView pkm_type2;
        ImageButton pkm_fav;

        public ViewHolder(@NonNull View filaView) {
            super(filaView);

            grdl = filaView.findViewById(R.id.grdl);
            pkm_id = filaView.findViewById(R.id.pkm_id);
            pkm_nom = filaView.findViewById(R.id.pkm_nom);
            pkm_icon = filaView.findViewById(R.id.pkm_icon);
            pkm_types = filaView.findViewById(R.id.pkm_types);
            pkm_type1 = filaView.findViewById(R.id.pkm_type1);
            pkm_type2 = filaView.findViewById(R.id.pkm_type2);
            pkm_fav = filaView.findViewById(R.id.pkm_fav);

        }
    }
}
