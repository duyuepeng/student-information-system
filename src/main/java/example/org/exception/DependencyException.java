package example.org.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DependencyException extends RuntimeException implements ExceptionMapper<DependencyException> {
    private static final long serialVersionUID = 1L;

    public DependencyException() {
        super("Dependency Exception");
    }

    public DependencyException(String s) {
        super(s);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response toResponse(DependencyException exception) {
        return Response.status(400).entity("{\"error\": \"" + exception.getMessage() + "\"}").type(MediaType.APPLICATION_JSON).build();
    }
}
