package br.edu.iftm.observer;

public class EstacaoMeteorologica {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay =  new HeatIndexDisplay(weatherData);

        weatherData.setMedicoes(80, 65, 30.4f);
        System.out.println();
        weatherData.setMedicoes(82, 70, 29.2f);
        System.out.println();
        weatherData.deleteObserver(heatIndexDisplay);
        weatherData.setMedicoes(78, 90, 29.2f);        
    }
}
