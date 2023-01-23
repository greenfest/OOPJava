package homework2;

/**
 * Пример неизменяемого класса.
 * В этом примере класс ImmutablePerson имеет два поля: имя и возраст.
 * Эти поля помечены как final, что означает, что их значения не могут быть изменены после создания объекта.
 * В классе также есть два метода получения, getName() и getAge(), которые позволяют другим объектам получать
 * доступ к значениям полей, но не изменять их. Класс также помечен как final, что означает, что он не
 * сможет иметь подклассов.
 * @author: Oleg Razin
 */
public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

