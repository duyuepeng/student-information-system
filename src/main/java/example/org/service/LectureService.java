package example.org.service;

import example.org.database.InMemoryDatabase;
import example.org.model.Lecture;

import java.util.HashMap;
import java.util.Map;

public class LectureService extends BaseService<Lecture, Long, Lecture> {

    static HashMap<Long, Object> map = InMemoryDatabase.getDB(Lecture.class.getName());

    @Override
    protected Map<Long, Object> getMap() {
        return map;
    }

    @Override
    protected boolean checkDependency(Lecture obj) {
        return true;
    }
}
