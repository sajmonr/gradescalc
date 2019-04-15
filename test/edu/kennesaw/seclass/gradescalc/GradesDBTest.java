package edu.kennesaw.seclass.gradescalc;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
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
        FileSystem fs = FileSystems.getDefault();
        Path dbfilegolden = fs.getPath(GRADES_DB_GOLDEN);
        Path dbfile = fs.getPath(GRADES_DB);
        //Files.copy(dbfilegolden, dbfile, REPLACE_EXISTING);
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
        Student s = db.getStudentByName("Cynthia Faast");
        assertNotNull(s);
        //assertTrue(students.contains(new Student("Cynthia Faast", "1234514", db)));
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

}
