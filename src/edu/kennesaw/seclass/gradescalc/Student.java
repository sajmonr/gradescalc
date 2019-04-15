package edu.kennesaw.seclass.gradescalc;

public class Student {
    private String _name;
    private String _id;
    private String _email;
    private int _c;
    private int _cpp;
    private int _java;
    private String _csJob;
    private int _attendance;

    //Begin getters
    public String getName(){
        return _name;
    }
    public String getId(){
        return _id;
    }
    public String getEmail(){
        return _email;
    }
    public int getC(){
        return _c;
    }
    public int getCpp(){
        return _cpp;
    }
    public int getJava(){
        return _java;
    }
    public String getCsJob(){
        return _csJob;
    }
    //End getters

    public Student(String name, String id, String email, int c, int cpp, int java, String csJob, int attendance){
        _name = name;
        _id = id;
        _email = email;
        _c = c;
        _cpp = cpp;
        _java = java;
        _csJob = csJob;
        _attendance = attendance;
    }
/*
    public Student(String name, String id, GradesDB db){
        _name = name;
        _id = id;
    }
*/
    public int getAttendance(){
        return _attendance;
    }
}
