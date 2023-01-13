package com.example.mvc_demo.Controller;

import android.view.View;

import com.example.mvc_demo.MainActivity;
import com.example.mvc_demo.Model.DrinkModel;

public class MainController {
    private MainActivity mainActivity;
    private DrinkModel model;

    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        model = new DrinkModel(this);
    }

    public void suggestDrink(){
        this.mainActivity.progressBar.setVisibility(View.VISIBLE);
        this.mainActivity.txtResult.setVisibility(View.INVISIBLE);
        model.suggestDrink();
    }
    public void onDrinkSuggested(String drinkName){
        this.mainActivity.txtResult.setVisibility(View.VISIBLE);
        this.mainActivity.txtResult.setText(drinkName);
        this.mainActivity.progressBar.setVisibility(View.INVISIBLE);
    }
}
