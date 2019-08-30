package com.example.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompareTest {

    @Test
    public void test() {
        List<Person1> list1 = new ArrayList<>();
        list1.add(new Person1(3));
        list1.add(new Person1(2));
        list1.add(new Person1(1));
        Collections.sort(list1);
        System.out.println(list1);
        List<Person2> list2 = new ArrayList<>();
        list2.add(new Person2(3));
        list2.add(new Person2(2));
        list2.add(new Person2(1));
        Collections.sort(list2,new Person2Comparator());
        System.out.println(list2);
        Map<Person1,Integer> map1 = new TreeMap<>();
        map1.put(new Person1(3),1);
        map1.put(new Person1(2),1);
        map1.put(new Person1(1),1);
        System.out.println(map1);
        Map<Person2,Integer> map2 = new TreeMap<>(new Person2Comparator());
        map2.put(new Person2(3),1);
        map2.put(new Person2(2),1);
        map2.put(new Person2(1),1);
        System.out.println(map2);
    }
}

class Person1 implements Comparable<Person1> {

    private int id;

    public Person1(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person1 p) {
        return this.id-p.id;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                '}';
    }
}

class Person2 {

    private int id;

    public Person2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                '}';
    }
}

class Person2Comparator implements Comparator<Person2> {

    @Override
    public int compare(Person2 p1, Person2 p2) {
        return p1.getId()-p2.getId();
    }
}

