package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){

        CustomList custlist = MockCityList();

        City city = new City("Edmonton", "Alberta");

        City city2 = new City("Edmonton", "Alberta");
        custlist.addCity(city);
        assertEquals(true, custlist.hasCity(city));
        assertEquals(false, custlist.hasCity(city2));
    }

    @Test
    void testDelete(){
        CustomList citylist = MockCityList();
        City city = new City("Edmonton", "Alberta");
        citylist.addCity(city);
        assertEquals(1, citylist.getCount());
        citylist.delete(city);
        assertEquals(0, citylist.getCount());
        assertThrows(IllegalArgumentException.class, () -> {
            citylist.delete(city);
        });
    }

    @Test
    void testCount(){
        CustomList citylist = MockCityList();
        City city = new City("Edmonton", "Alberta");
        citylist.addCity(city);
        assertEquals(1, citylist.count());
        citylist.delete(city);
        assertEquals(0, citylist.count());
        citylist.addCity(city);
        assertEquals(1, citylist.count());
    }
}
