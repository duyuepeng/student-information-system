package example.org.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import example.org.database.DynamoDB;
import example.org.exception.DependencyException;
import example.org.model.Course;
import example.org.model.request.BasicCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseService extends BaseService<Course, Long, BasicCourse> {

    private static StudentService studentService = new StudentService();
    private static ProgramService programService = new ProgramService();
    private static ProfessorService professorService = new ProfessorService();

    public CourseService() {
        this.mainClass = Course.class;
        this.mapper = new DynamoDBMapper(DynamoDB.client);
    }

    public void addStudentToCourse(Long studentId, Long courseId) {
        Course course = this.get(courseId);
        if (course == null)
            return;
        List<Long> list = course.getRoster();
        if (!list.contains(studentId))
            course.addRosterItem(studentId);
        this.putItem(courseId, course);
    }

    public void removeStudentFromCourse(Long studentId, Long courseId) {
        Course course = this.get(courseId);
        if (course == null)
            return;
        course.getRoster().remove(studentId);
        this.putItem(courseId, course);
    }

    @Override
    protected Course setBasicInfo(BasicCourse basic, Course all) {
        if (!Objects.equals(all.getProfessor(), basic.getProfessor())) {
            if (all.getProfessor() != null)
                professorService.removeCourseFromProfessor(all.getCourseId(), all.getProfessor());
            professorService.addCourseToProfessor(all.getCourseId(), basic.getProfessor());
        }
        if (!Objects.equals(all.getProgram(), basic.getProgram())) {
            if (all.getProgram() != null)
                programService.removeCourseFromProgram(all.getCourseId(), all.getProgram());
            programService.addCourseToProgram(all.getCourseId(), basic.getProgram());
        }
        all.setBasicCourse(basic);
        return all;
    }

    @Override
    protected Course create(BasicCourse obj) {
        Course newCourse = new Course();
        return newCourse.roster(new ArrayList<>());
    }

    @Override
    protected boolean checkDependency(BasicCourse course) {
        if (programService.get(course.getProgram()) == null)
            throw new DependencyException("Program " + course.getProgram() + " not exists.");
        if (studentService.get(course.getTa()) == null)
            throw new DependencyException("TA student " + course.getTa() + " not exists.");
        if (professorService.get(course.getProfessor()) == null)
            throw new DependencyException("Professor " + course.getProfessor() + " not exists.");
        return true;
    }

    public Course register(Long courseId, Long studentId) {
        this.addStudentToCourse(studentId, courseId);
        studentService.addCourseToStudent(courseId, studentId);
        return this.get(courseId);
    }

    @Override
    protected void deleteDependencies(Course course) {
        programService.removeCourseFromProgram(course.getCourseId(), course.getProgram());
        professorService.removeCourseFromProfessor(course.getCourseId(), course.getProfessor());
    }
}
