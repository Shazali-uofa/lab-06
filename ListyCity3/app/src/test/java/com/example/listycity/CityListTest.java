package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    public void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    public void testHasCity() {
        CityList list = mockCityList();
        City prince_albert = new City("Prince ALbert", "Saskatchewan");
        City Toronto = mockCity();

        assertFalse(list.hasCity(prince_albert));
        assertTrue(list.hasCity(Toronto));
    }

    @Test
    public void testHasCity_deleteCity() {
        CityList list = mockCityList();
        City Toronto = mockCity();
        list.delete(Toronto);

        assertFalse(list.hasCity(Toronto));
    }

    @Test
    public void testDelete_missingCity() {
        CityList cityList = mockCityList();
        City emptycity = new City("Surrey", "British Columbia");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cityList.delete(emptycity));

    }
    @Test
    public void testCountCity() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.count()); // No cities yet

        City city1 = new City("Vancouver", "British Columbia");
        City city2 = new City("Red Deer", "Alberta");
        City city3 = new City("Prince Albert", "Saskatchewan");

        cityList.add(city1);
        assertEquals(1, cityList.count());

        cityList.add(city2);
        cityList.add(city3);
        assertEquals(3, cityList.count());
    }




}


