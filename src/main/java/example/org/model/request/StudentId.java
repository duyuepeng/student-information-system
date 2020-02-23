package example.org.model.request;

import java.util.Objects;

public class StudentId {
    private Long studentId = null;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentId)) return false;
        StudentId studentId1 = (StudentId) o;
        return Objects.equals(getStudentId(), studentId1.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}
