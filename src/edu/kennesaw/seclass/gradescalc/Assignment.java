package edu.kennesaw.seclass.gradescalc;

public class Assignment {
    private String _title;

    public String getTitle(){
        return _title;
    }

    public Assignment(String title){
        _title = title;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Assignment && ((Assignment)o).getTitle() == _title;
    }
    @Override
    public int hashCode(){
        return _title.hashCode();
    }
}
