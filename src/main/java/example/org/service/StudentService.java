package example.org.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import example.org.database.DynamoDB;
import example.org.exception.DependencyException;
import example.org.model.Student;
import example.org.model.request.BasicStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentService extends BaseService<Student, Long, BasicStudent> {
    private static ProgramService programService = new ProgramService();
    private static CourseService courseService = new CourseService();

    public StudentService() {
        this.mainClass = Student.class;
        this.mapper = new DynamoDBMapper(DynamoDB.client);
    }

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

    @Override
    protected boolean checkDependency(BasicStudent obj) {
        if (programService.get(obj.getProgram()) == null)
            throw new DependencyException("Program " + obj.getProgram() + " not exists.");
        return true;
    }

    public Student drop(Long studentId, Long courseId) {
        this.removeCourseFromStudent(courseId, studentId);
        courseService.removeStudentFromCourse(studentId, courseId);
        return this.get(studentId);
    }
}
