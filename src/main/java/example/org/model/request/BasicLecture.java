package example.org.model.request;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "Lecture")
public class BasicLecture {
    private String notes = null;

    private List<String> materials = null;

    private Long course = null;

    public BasicLecture notes(String notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Get notes
     *
     * @return notes
     **/
    @DynamoDBAttribute(attributeName = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BasicLecture materials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public BasicLecture addMaterialsItem(String materialsItem) {
        if (this.materials == null) {
            this.materials = new ArrayList<>();
        }
        this.materials.add(materialsItem);
        return this;
    }

    /**
     * Get materials
     *
     * @return materials
     **/
    @DynamoDBAttribute(attributeName = "materials")
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
    @DynamoDBAttribute(attributeName = "course")
    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public BasicLecture course(Long course) {
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
        BasicLecture lecture = (BasicLecture) o;
        return Objects.equals(this.notes, lecture.notes) &&
                Objects.equals(this.materials, lecture.materials) &&
                Objects.equals(this.course, lecture.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes, materials, course);
    }


    @Override
    public String toString() {

        return "class Lecture {\n" +
                "    notes: " + toIndentedString(notes) + "\n" +
                "    materials: " + toIndentedString(materials) + "\n" +
                "    course: " + toIndentedString(course) + "\n" +
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