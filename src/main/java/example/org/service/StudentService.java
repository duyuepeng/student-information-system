package example.org.service;

import example.org.database.InMemoryDatabase;
import example.org.model.Student;
import example.org.model.request.BasicStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService extends BaseService<Student, Long, BasicStudent> {
    private static ProgramService programService = new ProgramService();
    private static CourseService courseService = new CourseService();

    static HashMap<Long, Object> map = InMemoryDatabase.getDB(Student.class.getName());

    public void addCourseToStudent(Long courseId, Long studentId) {
        Student student = this.get(studentId);
        if (student == null)
            return;
        List<Long> list = student.getCoursesEnrolled();
        if (!list.contains(courseId))
            student.addCoursesEnrolledItem(courseId);
        this.putItem(studentId, student);
    }

    public void removeCourseFromStudent(Long courseId, Long studentId) {
        Student student = this.get(studentId);
        if (student == null)
            return;
        student.getCoursesEnrolled().remove(courseId);
        this.putItem(studentId, student);
    }

    @Override
    protected Student create(BasicStudent obj) {
        Student newStudent = new Student();
        return newStudent.coursesEnrolled(new ArrayList<>());
    }

    @Override
    protected Student setBasicInfo(BasicStudent basic, Student all) {
        all.setBasicStudent(basic);
        return all;
    }

//    public Student add(BasicStudent student) {
//        Long pk = this.generatePk();
//        Student newStudent = new Student();
//        newStudent.coursesEnrolled(new ArrayList<>()).pk(pk).setBasicStudent(student);
//        return this.putItem(newStudent.getStudentId(), newStudent);
//    }
//
//    public Student update(BasicStudent student, Long studentId) {
//        Student oldStudent = this.get(studentId);
//        if (oldStudent == null)
//            return null;
//
//        return this.putItem(oldStudent.getStudentId(), oldStudent);
//    }

    @Override
    protected Map<Long, Object> getMap() {
        return map;
    }

    @Override
    protected boolean checkDependency(BasicStudent obj) {
        if (programService.get(obj.getProgram()) == null)
            throw new RuntimeException("Program not exists.");
        return true;
    }

    public Student drop(Long studentId, Long courseId) {
        this.removeCourseFromStudent(courseId, studentId);
        courseService.removeStudentFromCourse(studentId, courseId);
        return this.get(studentId);
    }
}
