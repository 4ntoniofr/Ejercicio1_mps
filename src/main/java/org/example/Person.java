package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * Class representing a person with a name, age and gender
 *
 * @author Antonio Fernández Rodríguez
 * */


public class Person {

    private final String name;
    private final int age;
    private final String gender;

    /*
     * Construct a person with a name, age and gender.
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     *
     * */

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name() {
        return this.name;
    }

    public int age() {
        return this.age;
    }

    public String gender() {
        return this.gender;
    }

    /*
     * Computes the average age of male and female persons in a list and returns the result in as array of two elements
     * (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return
     * */

    public double[] averageAgePerGender(@NotNull List<Person> persons) {
        double maleAgeSum = 0, femaleAgeSum = 0;
        int maleCount = 0, femaleCount = 0;

        for (Person person : persons) {
            if (person.gender().equals("Male")) {
                maleAgeSum += person.age();
                maleCount++;
            } else if (person.gender().equals("Female")) {
                femaleAgeSum += person.age();
                femaleCount++;
            }
        }

        return new double[]{maleAgeSum / maleCount, femaleAgeSum / femaleCount};
    }

}
