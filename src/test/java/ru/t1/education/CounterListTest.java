package ru.t1.education;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterListTest {

    @Test
    public void testAddCounting() {
        CounterList.reset();
        List<Integer> list = new CounterList<>(new ArrayList<>());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(5, CounterList.getAddCount());

        Main.test(list); // может вызвать add?

        // Допустим, test ничего не делает — тогда останется 5
        assertEquals(5, CounterList.getAddCount());
    }
}