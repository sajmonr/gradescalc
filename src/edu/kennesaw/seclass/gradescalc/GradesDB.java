package edu.kennesaw.seclass.gradescalc;

import java.util.ArrayList;
import java.util.List;

public class GradesDB {

    private List<Grade> _grades;

    public List<Grade> getGrades(String studentName){
        List<Grade> grades = new ArrayList<>();

        for(Grade g : _grades){
            if(g.getStudentName() == studentName)
                grades.add(g);
        }

        return grades;
    }

    public GradesDB(String dbFilePath){
        _grades = new ArrayList<>();

        populateGradesList();

    }
    private void populateGradesList(){
        _grades.add(new Grade("Adam", "Project 1", 100));
        _grades.add(new Grade("Adam", "Project 2", 100));
        _grades.add(new Grade("Joe", "Project 1", 90));
        _grades.add(new Grade("Emma", "Project 1", 80));
    }
}
