package example.org.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundException extends RuntimeException implements ExceptionMapper<NotFoundException> {
    private static final long serialVersionUID = 2L;

    public NotFoundException() {
        super("Not Found Exception");
    }

    public NotFoundException(String s) {
        super(s);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(404).entity("{\"error\": \"" + exception.getMessage() + "\"}").type(MediaType.APPLICATION_JSON).build();
    }
}
