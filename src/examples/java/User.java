

import java.util.Objects;

public class User {

    private final String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(age, user.age);
    }

    @Override
    public String toString() {
        return String.format("User(name='%s', age=%s)", name, age);
    }

    public static void main(String[] args) {
        User user = new User("Jose", 32);
        user.setAge(33);
        // user.setName() does not exist
    }
}
