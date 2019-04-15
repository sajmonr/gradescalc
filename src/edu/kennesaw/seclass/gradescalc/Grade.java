package edu.kennesaw.seclass.gradescalc;

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
    //End getters

    public Grade(String studentName, Assignment assignment, int score){
        _studentName = studentName;
        _assignment = assignment;
        _score = score;
    }
}
