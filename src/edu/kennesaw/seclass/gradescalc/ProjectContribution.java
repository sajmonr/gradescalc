package edu.kennesaw.seclass.gradescalc;

public class ProjectContribution {
    private String _projectName;
    private String _studentName;
    private int _contribution;

    public String getProjectName(){
        return _projectName;
    }
    public String getStudentName(){
        return _studentName;
    }

    public int getContribution(){
        return _contribution;
    }
    public void setContribution(int contribution){
        _contribution = contribution;
    }
    public ProjectContribution(String projectName, String studentName, int contribution){
        _projectName = projectName;
        _studentName = studentName;
        _contribution = contribution;
    }

}
