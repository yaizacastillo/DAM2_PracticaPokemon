package com.example.practicapokemon.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicapokemon.api.PokemonApi;
import com.example.practicapokemon.model.Pokemon;
import com.example.practicapokemon.model.Type;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    /*public MutableLiveData<Pokemon> pokemon;
    private int idPokemonActual = -1;

    public MainActivityViewModel() {
        pokemon = new MutableLiveData<Pokemon>();
    }

    public void getPokemon(int id){
        if(id!=idPokemonActual){
            Observable.fromCallable(() -> {
                Pokemon p = PokemonApi.getPokemon();
                pokemon.postValue(p);
                idPokemonActual = id;
                return 1; //s'ha de tornar valor sí o sí
            }).subscribeOn(Schedulers.io()).subscribe();
        }
    }*/

    public MutableLiveData<List<Pokemon>> pokemonList;
    public MutableLiveData<List<Type>> typesList;

    public MainActivityViewModel(){
        pokemonList = null;
        typesList = null;
    }

    public void getPokemonList(){
        if(pokemonList == null) {
            pokemonList = new MutableLiveData<List<Pokemon>>();
            Observable.fromCallable(() -> {
                List<Pokemon> list = PokemonApi.getPokemonList();
                pokemonList.postValue(list);
                return 1; //s'ha de tornar valor sí o sí
            }).subscribeOn(Schedulers.io()).subscribe();
        }
    }

    public void getTypesList(){
        if(typesList == null) {
            typesList = new MutableLiveData<List<Type>>();
            Observable.fromCallable(() -> {
                List<Type> list = PokemonApi.getTypeList();
                typesList.postValue(list);
                return 1; //s'ha de tornar valor sí o sí
            }).subscribeOn(Schedulers.io()).subscribe();
        }
    }

}
