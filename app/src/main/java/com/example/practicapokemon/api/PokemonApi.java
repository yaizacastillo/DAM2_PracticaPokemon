package com.example.practicapokemon.api;

import android.util.Log;
import android.widget.EditText;

import com.example.practicapokemon.utils.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class PokemonApi {

    public static String getPokemon(int id){
        String nom = null;
        String json = NetworkUtils.getJSon("https://pokeapi.co/api/v2/pokemon/ditto");

        try{
            JSONObject pokemonObj = new JSONObject(json);
            nom = pokemonObj.getString("name");
        } catch (JSONException e) {
            Log.e("XXX", "He petat com un cabr...");
        }

        return nom;
    }

}
