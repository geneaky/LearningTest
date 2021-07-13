package ObserverPattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherStationTest {

    @Test
    @DisplayName("옵저버 패턴: 옵저버 update")
    public void weatherInfoGet() throws Exception {
        //given
        WeatherData weatherData = spy(WeatherData.class);
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        //when
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        //then
        verify(weatherData,times(1)).registerObserver(any());
        verify(weatherData,times(3)).notifyObservers();
    }

    @Test
    @DisplayName("옵저버 패턴: 구독취소한 옵저버는 최신 데이터를 받을 수 없습니다.")
    public void unsubscribeThenCanNotGetWeatherInfo() throws Exception
    {
        //given
        WeatherData weatherData = spy(WeatherData.class);
        CurrentConditionsDisplay currentDisplay1 = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay currentDisplay2 = new CurrentConditionsDisplay(weatherData);

        //when
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.removeObserver(currentDisplay2);
        weatherData.setMeasurements(78, 90, 29.2f);
        //then
        verify(weatherData,times(2)).registerObserver(any());
        verify(weatherData,times(3)).notifyObservers();
        assertThat(currentDisplay2.display()).isEqualTo("70.0 82.0");
    }
}