package example.org.model.request;

import java.util.Date;
import java.util.Objects;

public class BasicProfessor {

    private String firstName = null;

    private String lastName = null;

    private String email = null;

    private Date joiningDate = null;

    private String department = null;

    /**
     * Get firstName
     *
     * @return firstName
     **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BasicProfessor lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BasicProfessor email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BasicProfessor joiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
        return this;
    }

    /**
     * Get joiningDate
     *
     * @return joiningDate
     **/
    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public BasicProfessor department(String department) {
        this.department = department;
        return this;
    }

    /**
     * Get department
     *
     * @return department
     **/
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BasicProfessor professor = (BasicProfessor) o;
        return Objects.equals(this.firstName, professor.firstName) &&
                Objects.equals(this.lastName, professor.lastName) &&
                Objects.equals(this.email, professor.email) &&
                Objects.equals(this.joiningDate, professor.joiningDate) &&
                Objects.equals(this.department, professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, joiningDate, department);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BasicProfessor {\n");

        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
        sb.append("    department: ").append(toIndentedString(department)).append("\n");
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
