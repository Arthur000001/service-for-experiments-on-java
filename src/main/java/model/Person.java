package model;

import java.util.Objects;

public class Person {
    Long id;
    String name;
    String surname;
    Short age;

    public Person(final Long id, final String name, final String surname, final Short age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age + '}';
    }



    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return Objects.equals(id, p.id) &&
                Objects.equals(name, p.name) &&
                Objects.equals(surname, p.surname) &&
                Objects.equals(age, p.age);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}
