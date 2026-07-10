import java.util.*;

class Student {
    int roll_no;
    String name;
    float cgpa;

    Student(int roll_no, String name, float cgpa) {
        this.roll_no = roll_no;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class Custom_Priority {
    public static void main(String[] args) {
        PriorityQueue<Student> que = new PriorityQueue<>(
            // (s1, s2) -> s1.roll_no - s2.roll_no
            // (s1, s2) -> s1.name.compareTo(s2.name)
            // (s1, s2) -> Float.compare(s1.cgpa, s2.cgpa)

            // Custom priority
            (a, b) -> {
                if (a.cgpa != b.cgpa)
                    return Float.compare(b.cgpa, a.cgpa); 

                if (!a.name.equals(b.name))
                    return a.name.compareTo(b.name);      
                return a.roll_no - b.roll_no;            
            }
        );
        que.offer(new Student(101, "AAAA", 5.67f));
        que.offer(new Student(102, "BBBB", 8.90f));
        que.offer(new Student(103, "CCCC", 7.45f));
        que.offer(new Student(104, "AAAA", 8.90f));

        while (!que.isEmpty()) {
            Student s = que.poll();

            System.out.println(
                s.roll_no + " " +
                s.name + " " +
                s.cgpa
            );
        }
    }
}