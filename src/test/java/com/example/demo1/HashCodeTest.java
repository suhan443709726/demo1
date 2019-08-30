package com.example.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashCodeTest {

    @Test
    public void test() {
        Map<Person,Integer> map = new HashMap<>();
        map.put(new Person(1,"a"),1);
        map.put(new Person(1,"a"),1);
        System.out.println(map);
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person Person = (Person) o;
        return id == Person.id &&
                Objects.equals(name, Person.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}
