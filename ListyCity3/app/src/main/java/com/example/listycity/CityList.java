package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Check if a city is present in the list
     * @param city the city to check
     * @return true if there is city else false
     * @throws NullPointerException {@code city} is null
     */
    public boolean hasCity(City city) {
        Objects.requireNonNull(city, "city");
        return cities.contains(city);
    }

    /**
     * Delete a city from the list
     * @param city the city to delete
     * @throws IllegalArgumentException if there is no city to delete
     */
    public void delete(City city) {
        Objects.requireNonNull(city, "city");
        boolean removed = cities.remove(city);

        if (!removed) {
            throw new IllegalArgumentException("No City to delete");
        }
    }

    /**
     * Count the number of cities in the list
     * @return number of cities in the list
     */
    public int count() {
        return cities.size();
    }

}
