package example.org.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import example.org.model.request.BasicProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Program
 */

@DynamoDBTable(tableName = "Program")
public class Program extends BasicProgram implements PrimaryKey<Long, Program> {
    private Long programId = null;

    private List<Long> courses = null;

    public void setBasicProgram(BasicProgram basicProgram) {
        this.name(basicProgram.getName())
                .info(basicProgram.getInfo());
    }

    public Program programId(Long programId) {
        this.programId = programId;
        return this;
    }

    @Override
    public void changePk(Long obj) {
        this.setProgramId(obj);
    }

    @Override
    public Long retrievePk() {
        return this.getProgramId();
    }

    @Override
    public Program pk(Long obj) {
        return this.programId(obj);
    }

    /**
     * Get programId
     *
     * @return programId
     **/
    @DynamoDBHashKey(attributeName = "programId")
    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Program name(String name) {
        this.setName(name);
        return this;
    }


    public Program info(String info) {
        this.setInfo(info);
        return this;
    }


    public Program courses(List<Long> courses) {
        this.courses = courses;
        return this;
    }

    public Program addCoursesItem(Long coursesItem) {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }
        this.courses.add(coursesItem);
        return this;
    }

    /**
     * Get courses
     *
     * @return courses
     **/
    @DynamoDBAttribute(attributeName = "courses")
    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;
        if (!super.equals(o)) return false;
        Program program = (Program) o;
        return Objects.equals(getProgramId(), program.getProgramId()) &&
                Objects.equals(getCourses(), program.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProgramId(), getCourses());
    }

    @Override
    public String toString() {

        return "class Program {\n" +
                "    programId: " + toIndentedString(programId) + "\n" +
                "    name: " + toIndentedString(this.getName()) + "\n" +
                "    info: " + toIndentedString(this.getInfo()) + "\n" +
                "    courses: " + toIndentedString(courses) + "\n" +
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
