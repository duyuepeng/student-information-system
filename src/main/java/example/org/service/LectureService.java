package example.org.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import example.org.database.DynamoDB;
import example.org.exception.DependencyException;
import example.org.model.Lecture;
import example.org.model.request.BasicLecture;

public class LectureService extends BaseService<Lecture, Long, BasicLecture> {

    private static CourseService courseService = new CourseService();

    public LectureService() {
        this.mainClass = Lecture.class;
        this.mapper = new DynamoDBMapper(DynamoDB.client);
    }

    @Override
    protected Lecture setBasicInfo(BasicLecture basic, Lecture all) {
        all.setBasicLecture(basic);
        return all;
    }

    @Override
    protected boolean checkDependency(BasicLecture obj) {
        if (courseService.get(obj.getCourse()) == null)
            throw new DependencyException("Course " + obj.getCourse() + " not exists.");
        return true;
    }
}
