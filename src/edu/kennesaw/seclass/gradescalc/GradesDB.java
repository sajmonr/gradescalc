package edu.kennesaw.seclass.gradescalc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class GradesDB {

    private List<Assignment> _assignments;
    private List<Project> _projects;
    private List<Grade> _grades;
    private HashSet<Student> _students;


    public GradesDB(String dbFilePath){

        Workbook workbook;
        try{
            FileInputStream fis = new FileInputStream(dbFilePath);
            workbook = new XSSFWorkbook(fis);
        }catch(Exception e){
            System.out.println(String.format("Failed to open workbook '%s'.", dbFilePath));
            return;
        }

        try{
            _assignments = readAssignmentsDb(workbook);
            _projects = readProjectsDb(workbook);
            _grades = readGradesDb(workbook);
            _students = readStudentsDb(workbook);
        }catch(Exception e){
            System.out.println(String.format("Failed to read data from workbook '%s'.", dbFilePath));
            return;
        }

    }

    public int getNumStudents(){
        return _students.size();
    }
    public int getNumAssignments(){
        return _assignments.size();
    }
    public int getNumProjects(){
        return _projects.size();
    }

    public void addAssignment(String assignmentName){
        //!!!!!!!!THIS NEEDS TO BE IMPLEMENTED!!!!!!!!!!!
    }
    public void addGrade(){
        //!!!!!!!!THIS NEEDS TO BE IMPLEMENTED!!!!!!!!!!!
    }

    public HashSet<Student> getStudents(){
        return _students;
    }
    public Student getStudentByName(String name){
        for(Student s : _students){
            if(s.getName().equals(name))
                return s;
        }

        return null;
    }
    public Student getStudentByID(String id){
        for(Student s : _students){
            if(s.getId().equals(id))
                return s;
        }
        return null;
    }

    private List<Grade> readGradesDb(Workbook db){
        List<Grade> grades = new ArrayList<>();

        Sheet gradesSheet = db.getSheet("IndividualGrades");
        Iterator<Row> rowIterator = gradesSheet.iterator();

        HashMap<String, Integer> assignmentIndexes = getAssignmentIndexes(rowIterator.next());

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            String name = row.getCell(0).getStringCellValue();

            for(Assignment assignment : _assignments){
                if(assignmentIndexes.containsKey(assignment.getTitle())) {
                    int cellIndex = assignmentIndexes.get(assignment.getTitle());
                    int score = (int) row.getCell(cellIndex).getNumericCellValue();
                    grades.add(new Grade(name, assignment, score));
                }
            }
        }

        return grades;
    }

    private HashMap<String, Integer> getAssignmentIndexes(Row row){
        HashMap<String, Integer> indexes = new HashMap<>();

        String assignmentName;
        int currentCellIndex = 0;
        Cell currentCell = row.getCell(currentCellIndex);

        while(currentCell != null){
            assignmentName = currentCell.getStringCellValue();
            if(!indexes.containsKey(assignmentName))
                indexes.put(currentCell.getStringCellValue(), currentCellIndex);
            currentCell = row.getCell(++currentCellIndex);
        }

        return indexes;
    }

    private List<Assignment> readAssignmentsDb(Workbook db){
        List<Assignment> assignments = new ArrayList<>();

        Sheet gradesSheet = db.getSheet("IndividualGrades");

        int currentCell = 1;
        Row row = gradesSheet.iterator().next();
        Cell cell = row.getCell(currentCell++);

        while(cell != null){
            assignments.add(new Assignment(cell.getStringCellValue()));

            cell = row.getCell(currentCell++);
        }

        return assignments;
    }
    private List<Project> readProjectsDb(Workbook db){
        List<Project> projects = new ArrayList<>();

        Sheet gradesSheet = db.getSheet("TeamGrades");

        int currentCell = 1;
        Row row = gradesSheet.iterator().next();
        Cell cell = row.getCell(currentCell++);

        while(cell != null){
            projects.add(new Project(cell.getStringCellValue()));

            cell = row.getCell(currentCell++);
        }

        return projects;
    }
    private HashSet<Student> readStudentsDb(Workbook db){
        HashSet<Student> students = new HashSet<>();

        Sheet studentsSheet = db.getSheet("StudentsInfo");
        Iterator<Row> rowIterator = studentsSheet.iterator();

        //Skip one row for headers
        rowIterator.next();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();

            String name = row.getCell(0).getStringCellValue();
            String id = Integer.toString((int)row.getCell(1).getNumericCellValue());
            String email = row.getCell(2).getStringCellValue();
            int c = (int)row.getCell(3).getNumericCellValue();
            int cpp = (int)row.getCell(4).getNumericCellValue();
            int java = (int)row.getCell(5).getNumericCellValue();
            String csJob = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "";

            students.add(new Student(name, id, email, c, cpp, java, csJob, readStudentAttendance(db, name)));

        }

        return students;
    }

    private int readStudentAttendance(Workbook db, String studentName){
        Sheet attendanceSheet = db.getSheet("Attendance");
        Iterator<Row> rowIterator = attendanceSheet.iterator();

        rowIterator.next();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();

            if(row.getCell(0).getStringCellValue().equals(studentName))
                return (int)row.getCell(1).getNumericCellValue();
        }
        return 0;
    }

}
