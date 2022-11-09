package com.example.practicapokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.practicapokemon.adapters.PokemonsAdapter;
import com.example.practicapokemon.model.Pokemon;
import com.example.practicapokemon.model.Type;
import com.example.practicapokemon.viewmodel.MainActivityViewModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView rcy_pokemons;
    RelativeLayout rlyDownload;
    List<Pokemon> allPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayImageOptions options =
                new DisplayImageOptions.Builder()
                        .showImageOnLoading(R.drawable.ic_launcher_foreground)
                        .showImageForEmptyUri(R.drawable.ic_launcher_foreground)
                        .showImageOnFail(R.drawable.ic_launcher_foreground)
                        .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);

        rcy_pokemons = findViewById(R.id.rcy_pokemons);
        //2.asignar layout al recycler (horizontal, vertical o graella)
        rcy_pokemons.setLayoutManager(new LinearLayoutManager(this));
        rcy_pokemons.hasFixedSize();
        //3.crear llista de clients
        /*List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(newPokemon());
        pokemons.add(newPokemon());
        pokemons.add(newPokemon());
        //4.crear adapter
        PokemonsAdapter adapter = new PokemonsAdapter(pokemons);
        //5.assignar adapter al recycler
        rcy_pokemons.setAdapter(adapter);*/

        rlyDownload = findViewById(R.id.pgrDownload);

        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        rlyDownload.setVisibility(View.VISIBLE);

        //File jsonFolder = new File(this.getFilesDir(), "jsons");
        //jsonFolder.mkdirs();

        //Agafar tipus
        viewModel.getTypesList();
        viewModel.typesList.observe(this, new Observer<List<Type>>() {
            @Override
            public void onChanged(List<Type> l) {
                Type.setList(l);
                Log.e("XXX", "Llista de tipus = " + l);
            }
        });

        /*
            File jsonFolder = new File (this.getFilesDir(), "jsons");
            viewModel.descarregaPokemons(jsonFolder);
         */

        //Agafar pokemons
        viewModel.getPokemonList();
        viewModel.pokemonList.observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> l) {
                allPokemon = l;
                PokemonsAdapter adapter = new PokemonsAdapter(getApplicationContext(), allPokemon);
                rcy_pokemons.setAdapter(adapter);
                rlyDownload.setVisibility(View.INVISIBLE);
            }
        });



    }
}