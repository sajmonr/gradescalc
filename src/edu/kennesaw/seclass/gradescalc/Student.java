package edu.kennesaw.seclass.gradescalc;

public class Student {

    private String _name;
    private int _id;
    private String _email;
    private int _c;
    private int _cpp;
    private int _java;
    private boolean _csJob;

    //Begin getters
    public String getName(){
        return _name;
    }
    public int getId(){
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
    public boolean getCsJob(){
        return _csJob;
    }
    //End getters

    public Student(String name, int id, String email, int c, int cpp, int java, boolean csJob){
        _name = name;
        _id = id;
        _email = email;
        _c = c;
        _cpp = cpp;
        _java = java;
        _csJob = csJob;
    }

}
