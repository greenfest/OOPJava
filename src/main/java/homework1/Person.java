package homework1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The Person class is a simple data structure that represents a person in a family tree.
 * It contains fields for the person's name and the age, and methods to get and set these fields.
 * The class also overrides the toString() method to return the name and the age of the person, so that it can be easily printed.
 *
 * @author  Oleg Razin
 */
class Person {
    private final String name;
    private Integer age = null;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("name: " + name);
            if (age != null) {
                writer.println("age: " + age);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age;
    }
}