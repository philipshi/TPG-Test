/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgtestphilip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Philip Shi 05/09/2017
 */
public class Student {
    
    //Creating object Student
    
    private int ID;
    private String name;
    private double GPA;

    public Student() {
    }

    
    public Student(int ID, String name, double GPA) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    //Creating comparator method to sort students
    class StudentComparatorByAll implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int result = 0;
        //Sorts GPA in descending order.
        if (o1.getGPA() > o2.getGPA()) result = -1;
        if (o1.getGPA() < o2.getGPA()) result = 1;
        if (result == 0){
            //same gpa, compare name
            result = o1.getName().compareTo(o2.getName());
                if( result == 0){
                    //same name, compare ID
                    if (o1.getID() > o2.getID()) result = -1;
                    if (o1.getID() < o2.getID()) result = 1;
                }
            
        }
        return result;
    }
    }
    
    public void sortStudents () throws IOException {
    
        //Adding data to arraylist from csv file.
        List<Student> students = new ArrayList<Student>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File("resources/studentinfo.csv")));
            String line;
            //Want to ignore the first line as it contains information not useful... (id, name)
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                Student tempstu = new Student(Integer.parseInt(entries[0]), entries[1], Double.parseDouble(entries[2]));
                //All the data now added to an Array List to be sorted.
                students.add(tempstu);
            }
            
            //Add all the data into a priority queue to be sorted, using the comparator we made earlier
            PriorityQueue<Student> pq = new PriorityQueue<Student>(10, new StudentComparatorByAll());
            pq.addAll(students);
            Student stu = null;
            //While the queue is not empty, after its sorted, print out the names.
            while ((stu = pq.poll()) != null)
                System.out.println(stu.name);                    
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find student info file");
            ex.printStackTrace();
        }    
    }
}
