package edu.kennesaw.seclass.gradescalc;

public class Grade {
    private String _studentName;
    private String _assignmentTitle;
    private int _score;

    //Begin getters
    public String getStudentName(){
        return _studentName;
    }
    public String getAssignmentTitle(){
        return _assignmentTitle;
    }
    public int getScore(){
        return _score;
    }
    //End getters

    public Grade(String studentName, String assignmentTitle, int score){
        _studentName = studentName;
        _assignmentTitle = assignmentTitle;
        _score = score;
    }

}
