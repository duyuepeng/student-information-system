package example.org.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Lecture
 */
public class Lecture implements PrimaryKey<Long, Lecture> {
    private Long lectureId = null;

    private String notes = null;

    private List<String> materials = null;

    private Long course = null;

    public Lecture lectureId(Long lectureId) {
        this.lectureId = lectureId;
        return this;
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
    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Lecture notes(String notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Get notes
     *
     * @return notes
     **/
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Lecture materials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public Lecture addMaterialsItem(String materialsItem) {
        if (this.materials == null) {
            this.materials = new ArrayList<String>();
        }
        this.materials.add(materialsItem);
        return this;
    }

    /**
     * Get materials
     *
     * @return materials
     **/
    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    /**
     * Get course
     *
     * @return course
     **/
    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Lecture course(Long course) {
        this.course = course;
        return this;
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
                Objects.equals(this.notes, lecture.notes) &&
                Objects.equals(this.materials, lecture.materials) &&
                Objects.equals(this.course, lecture.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId, notes, materials, course);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Lecture {\n");

        sb.append("    lectureId: ").append(toIndentedString(lectureId)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    materials: ").append(toIndentedString(materials)).append("\n");
        sb.append("    course: ").append(toIndentedString(course)).append("\n");
        sb.append("}");
        return sb.toString();
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
