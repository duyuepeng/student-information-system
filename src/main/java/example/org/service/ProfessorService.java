package example.org.service;

import example.org.database.InMemoryDatabase;
import example.org.model.Professor;
import example.org.model.request.BasicProfessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorService extends BaseService<Professor, Long, BasicProfessor> {

    static HashMap<Long, Object> map = InMemoryDatabase.getDB(Professor.class.getName());

    @Override
    protected Map<Long, Object> getMap() {
        return map;
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

//    public Professor add(BasicProfessor professor) {
//        Long pk = this.generatePk();
//        Professor newProfessor = new Professor();
//        newProfessor.coursesTaught(new ArrayList<>()).pk(pk).setBasicProfessor(professor);
//        return this.putItem(newProfessor.getProfessorId(), newProfessor);
//    }

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


//    public Professor update(BasicProfessor professor, Long professorId) {
//        Professor oldProfessor = this.get(professorId);
//        if (oldProfessor == null)
//            return null;
//        oldProfessor.setBasicProfessor(professor);
//        return this.putItem(oldProfessor.getProfessorId(), oldProfessor);
//    }
}
