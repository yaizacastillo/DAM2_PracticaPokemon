package com.example.practicapokemon.api;

import android.util.Log;

import com.example.practicapokemon.model.Pokemon;
import com.example.practicapokemon.model.Type;
import com.example.practicapokemon.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PokemonApi {

    /*public static String getPokemon(int id){
        String nom = null;
        String json = NetworkUtils.getJSon("https://pokeapi.co/api/v2/pokemon/ditto");

        try{
            JSONObject pokemonObj = new JSONObject(json);
            nom = pokemonObj.getString("name");
        } catch (JSONException e) {
            Log.e("XXX", "He petat com un cabr...");
        }

        return nom;
    }*/

    public static List<Pokemon> getPokemonList(){
        List<Pokemon> list = null;

        String jsonParent = NetworkUtils.getJSon("https://pokeapi.co/api/v2/pokemon?limit=100&offset=0");

        try{
            list = new ArrayList<Pokemon>();
            JSONObject parent = new JSONObject(jsonParent);
            JSONArray results = parent.getJSONArray("results");

            for(int i = 0; i < results.length(); i++){
                JSONObject child = results.getJSONObject(i);
                String namePokemon =  child.getString("name");
                String jsonPokemon = NetworkUtils.getJSon("https://pokeapi.co/api/v2/pokemon/" + namePokemon);

                JSONObject pokemonObj = new JSONObject(jsonPokemon);
                int id = pokemonObj.getInt("id");
                String nom = pokemonObj.getString("name");
                JSONObject pokemonSprites = pokemonObj.getJSONObject("sprites");
                String url = pokemonSprites.getString("front_default");
                JSONArray types = pokemonObj.getJSONArray("types");
                List<Type> pokemonTypes = new ArrayList<Type>();
                for (int j = 0; j < types.length(); j++) {
                    JSONObject typeParent = types.getJSONObject(j);
                    JSONObject type = typeParent.getJSONObject("type");
                    String typeUrl = type.getString("url");
                    int typeId = Integer.parseInt(typeUrl.substring(31,typeUrl.length()-1));
                    pokemonTypes.add(Type.getType(typeId));
                }
                Pokemon p = new Pokemon(id, nom, pokemonTypes, false, "", 0f, 0f, null, null, url, null);
                list.add(p);
                Log.e("XXX", "Cargat pokemon: " + p);
            }
        } catch (JSONException e) {
            Log.e("XXX", "He petat com un cabr...");
        }

        return list;
    }

    public static List<Type> getTypeList(){
        List<Type> list = null;

        String jsonParent = NetworkUtils.getJSon("https://pokeapi.co/api/v2/type?limit=18");

        try{
            list = new ArrayList<Type>();
            JSONObject parent = new JSONObject(jsonParent);
            JSONArray results = parent.getJSONArray("results");

            for(int i = 0; i < results.length(); i++){
                JSONObject child = results.getJSONObject(i);

                Type t = new Type(i+1, child.getString("name"));
                list.add(t);
                Log.e("XXX", "Cargat tipus " + t.getName());
            }
        } catch (JSONException e) {
            Log.e("XXX", "He petat com un cabr...");
        }

        return list;
    }

}
