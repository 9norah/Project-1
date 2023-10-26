package educationalinstitutionsystem.screens;

import educationalinstitutionsystem.model.Course;
import educationalinstitutionsystem.model.Instructor;
import educationalinstitutionsystem.model.Mark;
import educationalinstitutionsystem.model.Student;
import java.util.ArrayList;

public class MYSystem {

    public static final int KEY_ADMIN = 1;
    public static final int KEY_STUDENT = 2;
    public static final int KEY_COURSE = 3;
    public static final int KEY_INSTRUCTOR = 4;
    public static final int KEY_CREATE = 5;
    public static final int KEY_UPDATE = 6;

    private static ArrayList<Student> students;
    private static ArrayList<Course> courses;
    private static ArrayList<Instructor> instructors;
    private static ArrayList<Mark> marks;

    MYSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        instructors = new ArrayList<>();
        marks = new ArrayList<>();
    }

    public static void main(String[] args) {
        new MYSystem();
        new SystemLoginFrame();
    }

    /// -------------------------------------------- Student Methods ------------------------ ///
    public static void createStudent(Student student) {
        students.add(student);
    }

    public static Student getStudentById(String id) {
        Student student = null;
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                student = s;
                break;
            }
        }
        return student;
    }

    public static int getIndexStudentById(String id) {
        int studentIndex = -1;
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                studentIndex = students.indexOf(s);
                break;
            }
        }
        return studentIndex;
    }

    public static void updateStudent(Student student) {
        int index = getIndexStudentById(student.getStudentId());
        students.set(index, student);
    }

    public static void viewStudents() {
        String[] columnNames = {"ID", "Name", "Email", "Password"};
        String[][] data = new String[students.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = students.get(i).getStudentId();
            data[i][1] = students.get(i).getStudentName();
            data[i][2] = students.get(i).getStudentEmail();
            data[i][3] = students.get(i).getStudentPassword();
        }
        new DisplayTableFrame("Students", columnNames, data);
    }

    public static Student deleteStudent(String id) {
        if (getIndexStudentById(id) == -1) {
            return null;
        }
        return students.remove(getIndexStudentById(id));
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static int registerForACourse(String studentId, String courseId) {
        Course course = getCourseById(courseId);
        Student student = getStudentById(studentId);
        if (course != null) {
            if (course.getInstructor() != null) {
                student.setCourses(course);
                updateStudent(student);
                return 2;
            } else {
                return 1;
            }

        }
        return 0;
    }

    public static boolean viewMyCourses(String studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
            ArrayList<Course> MyCourses = getStudentById(studentId).getCourses();
            String[] columnNames = {"ID", "Name", "Instructor"};
            String[][] data = new String[MyCourses.size()][columnNames.length];
            for (int i = 0; i < data.length; i++) {
                String InstructorName = "";
                if (MyCourses.get(i).getInstructor() != null) {
                    InstructorName = MyCourses.get(i).getInstructor().getInstructorName();
                }
                data[i][0] = MyCourses.get(i).getCourseId();
                data[i][1] = MyCourses.get(i).getCourseName();
                data[i][2] = InstructorName;
            }
            new DisplayTableFrame("My Courses", columnNames, data);
            return true;
        }
        return false;
    }

    public static ArrayList<Mark> getMyMarksStudent(String studentId) {
        ArrayList<Mark> ms = new ArrayList<>();
        Student student = getStudentById(studentId);
        if (student != null) {
            for (Mark mark : marks) {
                if (mark.getStudent().getStudentId().equals(studentId)) {
                    ms.add(mark);
                }
            }
        }

        return ms;
    }

    public static boolean viewAllMyMarksStudent(String studentId) {
        ArrayList<Mark> ms = getMyMarksStudent(studentId);
        if (ms.size() != 0) {
            String[] columnNames = {"Student name", "Course Name", "Mark"};
            String[][] data = new String[ms.size()][columnNames.length];
            for (int i = 0; i < data.length; i++) {
                data[i][0] = ms.get(i).getStudent().getStudentName();
                data[i][1] = ms.get(i).getCourse().getCourseName();
                data[i][2] = String.valueOf(ms.get(i).getMark());
            }
            new DisplayTableFrame("Marks", columnNames, data);
            return true;
        }
        return false;
    }

    public static boolean studentIsLogedin(String username, String password) {
        for (Student student : students) {
            if (student.getStudentId().equals(username)
                    && student.getStudentPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /// -------------------------------------------- Instructor Methods ------------------------ ///
    public static void createInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public static Instructor getInstructorById(String id) {
        Instructor instructor = null;
        for (Instructor i : instructors) {
            if (i.getInstructorId().equals(id)) {
                instructor = i;
                break;
            }
        }
        return instructor;
    }

    public static int getIndexInstructorById(String id) {
        int instructorIndex = -1;
        for (Instructor i : instructors) {
            if (i.getInstructorId().equals(id)) {
                instructorIndex = instructors.indexOf(i);
                break;
            }
        }
        return instructorIndex;
    }

    public static void updateInstructor(Instructor instructor) {
        int index = getIndexInstructorById(instructor.getInstructorId());
        instructors.set(index, instructor);
    }

    public static void viewInstructors() {
        String[] columnNames = {"ID", "Name", "Email", "Password"};
        String[][] data = new String[instructors.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = instructors.get(i).getInstructorId();
            data[i][1] = instructors.get(i).getInstructorName();
            data[i][2] = instructors.get(i).getInstructorEmail();
            data[i][3] = instructors.get(i).getInstructorPassword();
        }
        new DisplayTableFrame("Instructors", columnNames, data);
    }

    public static Instructor deleteInstructor(String id) {
        if (getIndexInstructorById(id) == -1) {
            return null;
        }
        return instructors.remove(getIndexInstructorById(id));
    }

    public static ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public static int recordMarkStudent(String instructorID, String studentID, String courseID, double mark) {
        Instructor instructor = getInstructorById(instructorID);
        Student student = getStudentById(studentID);
        Course course = getCourseById(courseID);
        if (instructor == null || student == null || course == null) {
            return 0;
        } else {
            if (isHaveCourse(instructorID, courseID)) {
                for (Mark m : marks) {
                    if (m.getStudent().getStudentId().equals(studentID)
                            && m.getCourse().getCourseId().equals(courseID)) {
                        Mark m1 = new Mark(m.getIdMark(), mark, course, student, instructor);
                        marks.set(m.getIdMark(), m1);
                        return 1;
                    }
                }
                if (studentIsHaveCourse(studentID, courseID)) {
                    Mark m = new Mark(marks.size(), mark, course, student, instructor);
                    marks.add(m);
                    return 2;
                } else {
                    return 4;
                }

            } else {
                return 3;
            }

        }

    }

    public static ArrayList<Mark> getAllInstructorMyMark(String instructorID, String coursID) {
        ArrayList<Mark> ms = new ArrayList<>();
        if (isHaveCourse(instructorID, coursID)) {
            for (Mark mark : marks) {
                if (mark.getInstructor().getInstructorId().equals(instructorID)) {
                    ms.add(mark);
                }
            }
        }

        return ms;
    }

    public static boolean viewAllInstructorMyMark(String instructorID, String coursID) {
        ArrayList<Mark> ms = getAllInstructorMyMark(instructorID, coursID);
        if (ms.size() != 0) {
            String[] columnNames = {"Student name", "Course Name", "Mark"};
            String[][] data = new String[ms.size()][columnNames.length];
            for (int i = 0; i < data.length; i++) {
                data[i][0] = ms.get(i).getStudent().getStudentName();
                data[i][1] = ms.get(i).getCourse().getCourseName();
                data[i][2] = String.valueOf(ms.get(i).getMark());
            }
            new DisplayTableFrame("Marks", columnNames, data);
            return true;
        }
        return false;
    }

    public static boolean studentIsHaveCourse(String studentId, String courseId) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);
        for (Student s : students) {
            for (Course c : s.getCourses()) {
                if (c.getCourseId().equals(courseId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isHaveCourse(String instructorID, String courseId) {
        Course c = getCourseById(courseId);
        if (c.getInstructor() != null) {
            for (Course course : getCourses()) {
                if (course.getCourseId().equals(courseId)
                        && course.getInstructor().getInstructorId().equals(instructorID)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean instructorIsLogedin(String username, String password) {
        for (Instructor instructor : instructors) {
            if (instructor.getInstructorId().equals(username)
                    && instructor.getInstructorPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /// -------------------------------------------- Course Methods ------------------------ ///
    public static boolean createCourse(Course course) {
        if (getCourseById(course.getCourseId()) == null) {
            courses.add(course);
            return true;
        }
        return false;
    }

    public static Course getCourseById(String id) {
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) {
                course = c;
                break;
            }
        }
        return course;
    }

    public static int getIndexCourseById(String id) {
        int courseIndex = -1;
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) {
                courseIndex = courses.indexOf(c);
                break;
            }
        }
        return courseIndex;
    }

    public static void updateCourse(Course course) {
        int index = getIndexCourseById(course.getCourseId());
        courses.set(index, course);
    }

    public static void viewCourses() {
        String[] columnNames = {"ID", "Name", "Instructor"};
        String[][] data = new String[courses.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            String InstructorName = "";
            if (courses.get(i).getInstructor() != null) {
                InstructorName = courses.get(i).getInstructor().getInstructorName();
            }
            data[i][0] = courses.get(i).getCourseId();
            data[i][1] = courses.get(i).getCourseName();
            data[i][2] = InstructorName;
        }
        new DisplayTableFrame("Courses", columnNames, data);
    }

    public static Course deleteCourse(String id) {
        if (getIndexCourseById(id) == -1) {
            return null;
        }
        return courses.remove(getIndexCourseById(id));
    }

    public static boolean addInstructorToCourse(String id, Instructor instructor) {
        Course course = getCourseById(id);
        int index = getIndexCourseById(course.getCourseId());
        course.setInstructor(instructor);
        Course c = courses.set(index, course);
        if (c.getInstructor() != null) {
            return true;
        }
        return false;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }
}
