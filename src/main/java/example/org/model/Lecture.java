package example.org.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import example.org.model.request.BasicLecture;

import java.util.Objects;

/**
 * Lecture
 */
@DynamoDBTable(tableName = "Lecture")
public class Lecture extends BasicLecture implements PrimaryKey<Long, Lecture> {
    private Long lectureId = null;

    public Lecture lectureId(Long lectureId) {
        this.lectureId = lectureId;
        return this;
    }

    public void setBasicLecture(BasicLecture basicLecture) {
        this.notes(basicLecture.getNotes())
                .materials(basicLecture.getMaterials())
                .course(basicLecture.getCourse());
    }

    @Override
    public void changePk(Long obj) {
        this.setLectureId(obj);
    }

    @Override
    public Long retrievePk() {
        return this.getLectureId();
    }

    @Override
    public Lecture pk(Long obj) {
        return this.lectureId(obj);
    }

    /**
     * Get lectureId
     *
     * @return lectureId
     **/
    @DynamoDBHashKey(attributeName = "lectureId")
    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lecture lecture = (Lecture) o;
        return Objects.equals(this.lectureId, lecture.lectureId) &&
                Objects.equals(this.getNotes(), lecture.getNotes()) &&
                Objects.equals(this.getMaterials(), lecture.getMaterials()) &&
                Objects.equals(this.getCourse(), lecture.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId, super.hashCode());
    }


    @Override
    public String toString() {

        return "class Lecture {\n" +
                "    lectureId: " + toIndentedString(lectureId) + "\n" +
                "    notes: " + toIndentedString(getNotes()) + "\n" +
                "    materials: " + toIndentedString(getMaterials()) + "\n" +
                "    course: " + toIndentedString(getCourse()) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
