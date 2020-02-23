package example.org.model.request;

import java.util.Objects;

public class BasicStudent {
    private String firstName = null;

    private String lastName = null;

    private String image = null;

    private Long program = null;


    public BasicStudent firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

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

    public BasicStudent lastName(String lastName) {
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

    public BasicStudent image(String image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BasicStudent program(Long program) {
        this.program = program;
        return this;
    }

    /**
     * Get program
     *
     * @return program
     **/
    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BasicStudent student = (BasicStudent) o;
        return Objects.equals(this.firstName, student.firstName) &&
                Objects.equals(this.lastName, student.lastName) &&
                Objects.equals(this.image, student.image) &&
                Objects.equals(this.program, student.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, image, program);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BasicStudent {\n");

        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    program: ").append(toIndentedString(program)).append("\n");
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
