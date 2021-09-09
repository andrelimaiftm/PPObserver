package br.edu.iftm.observer;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement  {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numLeitura = 0;

    public StatisticsDisplay(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            float temp = weatherData.getTemperatura();
            tempSum += temp;
            numLeitura++;

            if(temp > maxTemp){
                maxTemp = temp;
            }

            if(temp < minTemp){
                minTemp = temp;
            }
            this.display();
        }
        
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperaturas =" + (tempSum / numLeitura)
        + "/" + maxTemp + "/" + minTemp);
        
    }
}

    
