package example.org.model;

import example.org.model.request.BasicStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Student
 */
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
            this.coursesEnrolled = new ArrayList<Long>();
        }
        this.coursesEnrolled.add(courseEnrolled);
        return this;
    }

    /**
     * Get Long
     *
     * @return Long
     **/
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
        StringBuilder sb = new StringBuilder();
        sb.append("class Student {\n");

        sb.append("    studentId: ").append(toIndentedString(studentId)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(this.getFirstName())).append("\n");
        sb.append("    lastName: ").append(toIndentedString(this.getLastName())).append("\n");
        sb.append("    image: ").append(toIndentedString(this.getImage())).append("\n");
        sb.append("    program: ").append(toIndentedString(this.getProgram())).append("\n");
        sb.append("    Long: ").append(toIndentedString(coursesEnrolled)).append("\n");
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
