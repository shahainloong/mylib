package com.ac.mylib.java.java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double calclatePrice(String product){
        delay();
        return new Random().nextDouble()*product.charAt(0)+product.charAt(1);
    }

    public double getPrice(String product){
        return calclatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calclatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncBySupplyAsync(String product){
        return CompletableFuture.supplyAsync(()->calclatePrice(product));
    }

}
