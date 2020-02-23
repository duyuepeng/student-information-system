package example.org.model.request;

import java.util.Objects;

public class BasicProgram {

    private String name = null;

    private String info = null;


    public BasicProgram name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicProgram info(String info) {
        this.info = info;
        return this;
    }

    /**
     * Get info
     *
     * @return info
     **/
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicProgram)) return false;
        BasicProgram that = (BasicProgram) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getInfo(), that.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getInfo());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BasicProgram {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    info: ").append(toIndentedString(info)).append("\n");
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
