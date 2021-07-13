package ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public String display() {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            lastPressure = currentPressure;
            currentPressure = weatherData2.getPressure();
            display();
        }
    }
}
