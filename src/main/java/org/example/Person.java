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

    /**
     * Computes the average age of male and female persons in a list and returns the result as an array of two elements.
     * The first element is the mean age of males and the second one is the mean age of females.
     *
     * @param persons A list of persons to compute the average age for. It must not be null.
     * @return An array of two elements where the first element is the mean age of males and the second one is the mean age of females.
     * @throws IllegalArgumentException if the `persons` list is null.
     */

    public static double[] averageAgePerGender(List<Person> persons) {

        if (persons == null) {
            throw new IllegalArgumentException("Lista de personas nula");
        }

        double maleSum = 0, femaleSum = 0;
        int maleCount = 0, femaleCount = 0;

        for (Person person : persons) {
            if (person == null) {
                throw new IllegalArgumentException("Hay una persona nula en la lista");
            }
            if (person.gender().equals("Male")) {
                maleSum += person.age();
                maleCount++;
            } else if (person.gender().equals("Female")) {
                femaleSum += person.age();
                femaleCount++;
            }
        }
        if (maleCount == 0 && femaleCount == 0) {
            return new double[]{0, 0};
        }
        if (maleCount == 0) {
            return new double[]{0, femaleSum / femaleCount};
        }
        if (femaleCount == 0) {
            return new double[]{maleSum / maleCount, 0};
        }

        return new double[]{maleSum / maleCount, femaleSum / femaleCount};
    }

}
