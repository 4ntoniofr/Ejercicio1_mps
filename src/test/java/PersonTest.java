import org.example.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void averageAgePerGender_nullList_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(null));
    }

    @Test
    void averageAgePerGender_emptyList_returnsZeroArray() {
        assertArrayEquals(new double[]{0, 0}, Person.averageAgePerGender(Collections.emptyList()));
    }

    @Test
    void averageAgePerGender_allMales_returnsMaleAverage() {
        List<Person> persons = Arrays.asList(
                new Person("John", 20, "Male"),
                new Person("Jim", 25, "Male"),
                new Person("Jack", 30, "Male")
        );
        assertArrayEquals(new double[]{25, 0}, Person.averageAgePerGender(persons));
    }

    @Test
    void averageAgePerGender_allFemales_returnsFemaleAverage() {
        List<Person> persons = Arrays.asList(
                new Person("Jane", 20, "Female"),
                new Person("Jill", 25, "Female"),
                new Person("Janet", 30, "Female")
        );
        assertArrayEquals(new double[]{0, 25}, Person.averageAgePerGender(persons));
    }

    @Test
    void averageAgePerGender_mixedGenders_returnsBothAverages() {
        List<Person> persons = Arrays.asList(
                new Person("John", 20, "Male"),
                new Person("Jane", 25, "Female"),
                new Person("Jim", 30, "Male"),
                new Person("Janet", 35, "Female")
        );

        assertArrayEquals(new double[]{25, 30}, Person.averageAgePerGender(persons));
    }

    @Test
    void averageAgePerGender_nullPersonInTheList_throwsException() {
        List<Person> persons = Arrays.asList(
                new Person("John", 20, "Male"),
                null,
                new Person("Jim", 30, "Male"),
                new Person("Janet", 35, "Female")
        );
        assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(persons));
    }
}
