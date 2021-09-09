package br.edu.iftm.observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
    private float pressaoCorente = 29.92f;
    private float ultimaPressao;

    public ForecastDisplay(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast:");
        if(this.pressaoCorente < this.ultimaPressao){
            System.out.println("O clima está melhorando!!");
        }else if(this.pressaoCorente == this.ultimaPressao){
            System.out.println("Continua do mesmo jeito");
        }else if(this.pressaoCorente < this.ultimaPressao){
            System.out.println("Cuidado o clima será mais frio e chuvoso!");
        }              
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.ultimaPressao = this.pressaoCorente;
            this.pressaoCorente = weatherData.getPressao();
            this.display();
        }
        
    }
    
}
