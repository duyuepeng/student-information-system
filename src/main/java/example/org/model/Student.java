package example.org.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import example.org.model.request.BasicStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Student
 */
@DynamoDBTable(tableName = "Student")
public class Student extends BasicStudent implements PrimaryKey<Long, Student> {
    private Long studentId = null;

    private List<Long> coursesEnrolled = null;

    public void setBasicStudent(BasicStudent basicStudent) {
        this.firstName(basicStudent.getFirstName())
                .lastName(basicStudent.getLastName())
                .image(basicStudent.getImage())
                .program(basicStudent.getProgram());
    }

    public Student studentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    /**
     * Get studentId
     *
     * @return studentId
     **/
    @DynamoDBHashKey(attributeName = "studentId")
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public void changePk(Long obj) {
        this.setStudentId(obj);
    }

    @Override
    public Long retrievePk() {
        return this.getStudentId();
    }

    @Override
    public Student pk(Long obj) {
        return this.studentId(obj);
    }


    public Student firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }


    public Student lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }


    public Student image(String image) {
        this.setImage(image);
        return this;
    }


    public Student program(Long program) {
        this.setProgram(program);
        return this;
    }


    public Student coursesEnrolled(List<Long> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
        return this;
    }

    public Student addCoursesEnrolledItem(Long courseEnrolled) {
        if (this.coursesEnrolled == null) {
            this.coursesEnrolled = new ArrayList<>();
        }
        this.coursesEnrolled.add(courseEnrolled);
        return this;
    }

    /**
     * Get coursesEnrolled
     *
     * @return coursesEnrolled
     **/
    @DynamoDBAttribute(attributeName = "coursesEnrolled")
    public List<Long> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<Long> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
                Objects.equals(getCoursesEnrolled(), student.getCoursesEnrolled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, getCoursesEnrolled());
    }

    @Override
    public String toString() {

        return "class Student {\n" +
                "    studentId: " + toIndentedString(studentId) + "\n" +
                "    firstName: " + toIndentedString(this.getFirstName()) + "\n" +
                "    lastName: " + toIndentedString(this.getLastName()) + "\n" +
                "    image: " + toIndentedString(this.getImage()) + "\n" +
                "    program: " + toIndentedString(this.getProgram()) + "\n" +
                "    Long: " + toIndentedString(coursesEnrolled) + "\n" +
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
