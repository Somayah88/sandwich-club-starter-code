package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {


        try {

            JSONObject sandwichJsonObject = new JSONObject(json);
            JSONObject sandwichNameJsonObject = sandwichJsonObject.getJSONObject("name");
            String mainName = sandwichNameJsonObject.getString("mainName");
            JSONArray alsoKnownAsArray = sandwichNameJsonObject.getJSONArray("alsoKnownAs");
            List<String> nameList = new ArrayList<>(alsoKnownAsArray.length());

            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                nameList.add(alsoKnownAsArray.getString(i));
            }

            String placeOfOrigin = sandwichJsonObject.getString("placeOfOrigin");
            String description = sandwichJsonObject.getString("description");
            String image = sandwichJsonObject.getString("image");
            JSONArray ingredientsArray = sandwichJsonObject.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>(ingredientsArray.length());

            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.getString(i));
            }

            return new Sandwich(mainName, nameList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            throw new RuntimeException(e);

        }


    }
}
