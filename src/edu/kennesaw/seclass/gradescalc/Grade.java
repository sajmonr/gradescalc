package edu.kennesaw.seclass.gradescalc;

import java.util.Objects;

public class Grade {
    private String _studentName;
    private Assignment _assignment;
    private int _score;

    //Begin getters
    public String getStudentName(){
        return _studentName;
    }
    public Assignment getAssignment(){
        return _assignment;
    }
    public int getScore(){
        return _score;
    }
    public void setScore(int score){
        _score = score;
    }
    //End getters

    public Grade(String studentName, Assignment assignment, int score){
        _studentName = studentName;
        _assignment = assignment;
        _score = score;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Grade){
            Grade g = (Grade)o;

            return _studentName.equals(g.getStudentName()) && _score == g.getScore() && _assignment.equals(g.getAssignment());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(_studentName, _assignment, _score);
    }
}
