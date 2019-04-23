package edu.kennesaw.seclass.gradescalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesDBTest {

    GradesDB db = null;
    static final String GRADES_DB_GOLDEN = "DB" + File.separator
            + "GradesDatabase-goldenversion.xlsx";
    static final String GRADES_DB = "DB" + File.separator
            + "GradesDatabase.xlsx";

    @Before
    public void setUp() throws Exception {
        db = new GradesDB();
        db.loadSpreadsheet(GRADES_DB_GOLDEN);
    }

    @After
    public void tearDown() throws Exception {
        db = null;
    }

    @Test
    public void testGetNumStudents() {
        int numStudents = db.getNumStudents();
        assertEquals(14, numStudents);
    }

    @Test
    public void testGetNumAssignments() {
        int numAssignments = db.getNumAssignments();
        assertEquals(3, numAssignments);
    }

    @Test
    public void testGetNumProjects() {
        int numProjects;
        numProjects = db.getNumProjects();
        assertEquals(3, numProjects);
    }

    @Test
    public void testGetStudents1() {
        HashSet<Student> students = null;
        students = db.getStudents();
        assertEquals(14, students.size());
    }

    @Test
    public void testGetStudents2() {
        HashSet<Student> students = null;
        students = db.getStudents();
        assertTrue(students.contains(new Student("Cynthia Faast", "1234514", db)));
    }

    @Test
    public void testGetStudentsByName1() {
        Student student = null;
        student = db.getStudentByName("Rastus Kight");
        assertTrue(student.getId().compareTo("1234512") == 0);
    }

    @Test
    public void testGetStudentsByName2() {
        Student student = null;
        student = db.getStudentByName("Grier Nehling");
        assertEquals(96, student.getAttendance());
    }

    @Test
    public void testGetStudentsByID() {
        Student student = db.getStudentByID("1234504");
        assertTrue(student.getName().compareTo("Shevon Wise") == 0);
    }

    // Don't change above this point

    //Start custom test cases
    @Test
    public void testAddGrade(){
        String studentName = "Freddie Catlay";
        Assignment assignment = db.getAssignments().get(0);
        int score = 53;

        Grade newGrade = new Grade(studentName, assignment, score);

        db.addGrade(newGrade);

        assertEquals(score, db.getGradeFor(studentName, assignment.getTitle()).getScore());
    }

    @Test
    public void testAddAssignment(){
        Assignment assignment = new Assignment("Test assignment");

        db.addAssignment(assignment);

        assertEquals(assignment, db.getAssignmentByTitle(assignment.getTitle()));
    }

    @Test
    public void testAddContribution(){
        String studentName = "Freddie Catlay";
        String projectName = "PROJECT 2";
        int score = 44;

        ProjectContribution pc = new ProjectContribution(projectName, studentName, score);

        db.addContributions(pc);

        assertEquals(score, db.getContributionFor(studentName, projectName).getContribution());
    }

    //Begin functions that are not implemented
    //These methods will always fail as they are not implemented
    @ Test
    public  void testAddStudents () {
        Student student1 = new Student("Tom Grey", "1234502", db);
        db.addStudents(student1);
        assertEquals(16, db.getNumStudents());
    }
    @ Test
    public  void testAddProject () {
        Project project = new Project(" project 4");
        db.addProject(project);
        assertEquals(5, db.getNumProjects());
    }
    @ Test
    public  void testAddGrade1() {
        //Get the first assignment
        Assignment assignment = db.getAssignments().get(0);
        Grade grade1 = new Grade("Tom Grey",assignment, 87);
        db.addGrade(grade1);
        assertEquals(16, db.getNumGrades());
    }

    //End functions that are not implemented

    //End custom test cases
}

