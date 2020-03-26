package example.org.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import example.org.model.request.BasicProfessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Professor
 */

@DynamoDBTable(tableName = "Professor")
public class Professor extends BasicProfessor implements PrimaryKey<Long, Professor> {
    private Long professorId = null;

    private List<Long> coursesTaught = null;

    public void setBasicProfessor(BasicProfessor basicProfessor) {
        this.firstName(basicProfessor.getFirstName())
                .lastName(basicProfessor.getLastName())
                .email(basicProfessor.getEmail())
                .joiningDate(basicProfessor.getJoiningDate())
                .department(basicProfessor.getDepartment());
    }

    public Professor professorId(Long professorId) {
        this.professorId = professorId;
        return this;
    }

    @Override
    public void changePk(Long obj) {
        this.setProfessorId(obj);
    }

    @Override
    public Long retrievePk() {
        return this.getProfessorId();
    }

    @Override
    public Professor pk(Long obj) {
        return this.professorId(obj);
    }

    /**
     * Get professorId
     *
     * @return professorId
     **/
    @DynamoDBHashKey(attributeName = "professorId")
    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Professor firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public Professor lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public Professor email(String email) {
        this.setEmail(email);
        return this;
    }

    public Professor joiningDate(Date joiningDate) {
        this.setJoiningDate(joiningDate);
        return this;
    }

    public Professor department(String department) {
        this.setDepartment(department);
        return this;
    }

    public Professor coursesTaught(List<Long> coursesTaught) {
        this.coursesTaught = coursesTaught;
        return this;
    }

    public Professor addCoursesTaughtItem(Long coursesTaughtItem) {
        if (this.coursesTaught == null) {
            this.coursesTaught = new ArrayList<>();
        }
        this.coursesTaught.add(coursesTaughtItem);
        return this;
    }

    /**
     * Get coursesTaught
     *
     * @return coursesTaught
     **/
    @DynamoDBAttribute(attributeName = "coursesTaught")
    public List<Long> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Long> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getProfessorId(), professor.getProfessorId()) &&
                Objects.equals(getCoursesTaught(), professor.getCoursesTaught());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProfessorId(), getCoursesTaught());
    }

    @Override
    public String toString() {

        return "class Professor {\n" +
                "    professorId: " + toIndentedString(professorId) + "\n" +
                "    firstName: " + toIndentedString(this.getFirstName()) + "\n" +
                "    lastName: " + toIndentedString(getLastName()) + "\n" +
                "    email: " + toIndentedString(getEmail()) + "\n" +
                "    joiningDate: " + toIndentedString(getJoiningDate()) + "\n" +
                "    department: " + toIndentedString(getDepartment()) + "\n" +
                "    coursesTaught: " + toIndentedString(coursesTaught) + "\n" +
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
