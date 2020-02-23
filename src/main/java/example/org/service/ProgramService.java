package example.org.service;

import example.org.database.InMemoryDatabase;
import example.org.model.Program;
import example.org.model.request.BasicProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramService extends BaseService<Program, Long, BasicProgram> {

    static HashMap<Long, Object> map = InMemoryDatabase.getDB(Program.class.getName());

    public void addCourseToProgram(Long courseId, Long programId) {
        Program program = this.get(programId);
        if (program == null)
            return;
        List<Long> list = program.getCourses();
        if (!list.contains(courseId))
            program.addCoursesItem(courseId);
        this.putItem(programId, program);
    }

    public void removeCourseFromProgram(Long courseId, Long programId) {
        Program program = this.get(programId);
        if (program == null)
            return;
        program.getCourses().remove(courseId);
        this.putItem(programId, program);
    }

    @Override
    protected Program setBasicInfo(BasicProgram basic, Program all) {
        all.setBasicProgram(basic);
        return all;
    }

    @Override
    protected Program create(BasicProgram obj) {
        Program newProgram = new Program();
        return newProgram.courses(new ArrayList<>());
    }

    @Override
    protected Map<Long, Object> getMap() {
        return map;
    }

    @Override
    protected boolean checkDependency(BasicProgram program) {
        return true;
    }
}
