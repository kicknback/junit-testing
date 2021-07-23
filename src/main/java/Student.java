import java.util.ArrayList;
import java.util.Collections;

public class Student {

    private long id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(long id, String name){
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return this.grades;
    }

    public double getGradeAverage() {
        double sum = 0;
        for (int grade : this.grades) {
            sum += grade;
        }
        return sum / getGrades().size();
    }

    // TODO: updateGrade(int newGrade){} --> Find lowest grade and update to newGrade
    // TODO: deleteGrade() --> Find lowest grade and drop from the grades list


    public void updateGrade(int replaceWith) {
        grades.remove(Collections.min(grades));
        grades.add(replaceWith);
    }

    public void deleteGrade() {
        grades.remove(Collections.min(grades));
    }



}
