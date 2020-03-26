package example.org.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import example.org.database.DynamoDB;
import example.org.model.Professor;
import example.org.model.request.BasicProfessor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService extends BaseService<Professor, Long, BasicProfessor> {

    public ProfessorService() {
        this.mainClass = Professor.class;
        this.mapper = new DynamoDBMapper(DynamoDB.client);
    }

    @Override
    protected boolean checkDependency(BasicProfessor obj) {
        return true;
    }

    public void addCourseToProfessor(Long courseId, Long professorId) {
        Professor professor = this.get(professorId);
        if (professor == null)
            return;
        List<Long> list = professor.getCoursesTaught();
        if (!list.contains(courseId))
            professor.addCoursesTaughtItem(courseId);
        this.putItem(professorId, professor);
    }

    public void removeCourseFromProfessor(Long courseId, Long professorId) {
        Professor professor = this.get(professorId);
        if (professor == null)
            return;
        professor.getCoursesTaught().remove(courseId);
        this.putItem(professorId, professor);
    }


    @Override
    protected Professor setBasicInfo(BasicProfessor basic, Professor all) {
        all.setBasicProfessor(basic);
        return all;
    }

    @Override
    protected Professor create(BasicProfessor basic) {
        Professor newProfessor = new Professor();
        return newProfessor.coursesTaught(new ArrayList<>());
    }

}
