package datastructures.lc240330;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RecallPriorityQueueCustom {

    static class Person{
        Integer age;
        Integer xx;
        public Person(Integer age, Integer xx) {
            this.age = age;
            this.xx = xx;
        }
    }
    static class MyComp implements Comparator<Person>{
        @Override
        public int compare(Person p1, Person p2) {
            return p1.xx.compareTo(p2.xx); // 預設小到大排; -p1 則變為大到小排
        }
    }

    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person(33,9),
                new Person(31,5),
                new Person(28,88),
                new Person(43,3),
                new Person(93,7)
        };
        // 這行是重點
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(people.length,new MyComp());

        for (Person p : people){
            priorityQueue.add(p);
        }
        while (!priorityQueue.isEmpty()){
            Person poll = priorityQueue.poll();
            System.out.println(poll.age);
        }
    }

}
