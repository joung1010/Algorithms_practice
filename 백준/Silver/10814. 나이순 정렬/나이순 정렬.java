import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Person {
        private Integer age;
        private String name;
        private Integer sequence;

        public Person(Integer age, String name, Integer sequence) {
            this.age = age;
            this.name = name;
            this.sequence = sequence;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public Integer getSequence() {
            return sequence;
        }

        @Override
        public String toString() {
            return String.format("%s %s",age,name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

       List<Person> persons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] information = br.readLine().split(" ");
            persons.add(new Person(Integer.parseInt(information[0]), information[1], i));
        }

        Collections.sort(persons
                , (o1, o2) -> {
                  if(o1.getAge() == o2.getAge()) {
                      return o1.getSequence().compareTo(o2.getSequence());
                  }
                    return o1.getAge().compareTo(o2.getAge());
                });

        persons.forEach(System.out::println);
    }
}