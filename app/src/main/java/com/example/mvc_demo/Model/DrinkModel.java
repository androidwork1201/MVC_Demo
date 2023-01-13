package com.example.mvc_demo.Model;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.mvc_demo.Controller.MainController;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinkModel {
    String[] drinkList = {"Milk", "Coffee", "Orange juice", "Cola", "Red tea"};

    public MainController controller;

    public DrinkModel(MainController controller) {
        this.controller = controller;
    }

    public void suggestDrink() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final String[] drinkName = {""};

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                drinkName[0] = drinkList[new Random().nextInt(drinkList.length)];

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        controller.onDrinkSuggested(drinkName[0]);
                    }
                });
            }
        });
    }
}