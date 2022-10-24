package com.example.practicapokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.practicapokemon.api.PokemonApi;
import com.example.practicapokemon.model.Pokemon;
import com.example.practicapokemon.utils.NetworkUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.fromCallable(() -> {
            String nom = PokemonApi.getPokemon(35);
            return nom;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((nom) -> {
                    //això es crida quan acaba el fil
                    //i s'executa en el fil d'interfície gràfica
                EditText edtJson = findViewById(R.id.edtJson);
                edtJson.setText(nom);
            });
    }
}