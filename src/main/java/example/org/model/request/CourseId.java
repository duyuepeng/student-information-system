package example.org.model.request;

import java.util.Objects;

public class CourseId {
    private Long courseId = null;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseId)) return false;
        CourseId courseId1 = (CourseId) o;
        return Objects.equals(getCourseId(), courseId1.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId());
    }
}
