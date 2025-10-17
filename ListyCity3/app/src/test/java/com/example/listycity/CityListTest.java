package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }


    @Test
    void testHasCity() {
        CityList list = mockCityList();
        City prince_albert = new City("Prince ALbert", "Saskatchewan");
        City Toronto = mockCity();

        assertFalse(list.hasCity(prince_albert));
        assertTrue(list.hasCity(Toronto));
    }

    @Test
    void testHasCity_deleteCity() {
        CityList list = mockCityList();
        City Toronto = mockCity();
        list.delete(Toronto);

        assertFalse(list.hasCity(Toronto));
    }

    @Test
    void testDelete_missingCity() {
        CityList cityList = mockCityList();
        City emptycity = new City("Surrey", "British Columbia");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cityList.delete(emptycity));

    }

}


