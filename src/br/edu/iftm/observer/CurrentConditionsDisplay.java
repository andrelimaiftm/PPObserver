package br.edu.iftm.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    Observable observable;
    private float temperatura;
    private float humidade;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Condições Correntes: "+ temperatura + "F graus e "+ humidade + "% humidade");
        
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperatura = weatherData.getTemperatura();
            this.humidade = weatherData.getHumidade();
            display();
        }
        
    }
    
}
