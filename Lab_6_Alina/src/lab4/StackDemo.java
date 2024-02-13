package lab4;

public class StackDemo {
    public static void main(String[] args) {
        // Create a stack of String
        Stack<String> stringStack = new Stack<>();
        stringStack.push("programming paradigms");
        stringStack.push("love");
        stringStack.push("I");

        // Print the stack
        stringStack.print();

        // Remove all elements and print
        stringStack.pop();
        stringStack.pop();
        stringStack.pop();
        stringStack.print(); // Stack is empty

        // Create a stack of Person
        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Ionut", 25));
        personStack.push(new Person("Alexandra", 30));

        // Print the stack
        personStack.print();

        // Remove all elements and print
        personStack.pop();
        personStack.pop();
        personStack.print(); // Stack is empty
    }

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
