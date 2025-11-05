package BT8.Bai_4;
// Java Priority Queue
// https://www.hackerrank.com/challenges/java-priority-queue/problem


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */


class Student {
    private final int id;
    private final String name;
    private final double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID() { return id; }
    public String getName() { return name; }
    public double getCGPA() { return cgpa; }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        int compareByCGPA = Double.compare(b.getCGPA(), a.getCGPA());
        if (compareByCGPA != 0) {
            return compareByCGPA;
        }
        
        int compareByName = a.getName().compareTo(b.getName());
        if (compareByName != 0) {
            return compareByName;
        }
        
        return Integer.compare(a.getID(), b.getID());
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
        
        for (String line : events) {
            if (line.startsWith("ENTER")) {
                Scanner scanner = new Scanner(line);
                scanner.next(); // cmd
                String name = scanner.next();
                double cgpa = scanner.nextDouble();
                int id = scanner.nextInt();
                scanner.close();
                
                pq.add(new Student(id, name, cgpa));
            } else if (line.equals("SERVED")) {
                if (!pq.isEmpty()) pq.poll();
            }
        }
        
        List<Student> remaining = new ArrayList<>();
        while (!pq.isEmpty()) remaining.add(pq.poll());
        return remaining;
    }
}