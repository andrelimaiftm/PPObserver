package br.edu.iftm.observer;

import java.util.Observable;

public class WeatherData extends Observable{
    private float temperatura;
    private float humidade;
    private float pressao;

    public WeatherData(){}

    public void mudancaoMedicoes(){
        setChanged();
        notifyObservers();
    }

    public void setMedicoes(float temperatura, float humidade, float pressao){
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.pressao = pressao;
        this.mudancaoMedicoes();
    }

    public float getTemperatura() {
        return temperatura;
    }    

    public float getHumidade() {
        return humidade;
    }    

    public float getPressao() {
        return pressao;
    }  

    
}
