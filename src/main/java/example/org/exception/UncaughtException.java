package example.org.exception;

import javax.json.stream.JsonParsingException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {
    private static final long serialVersionUID = 9L;

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof JsonParsingException || exception instanceof ProcessingException)
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid data supplied for request\"}").type(MediaType.APPLICATION_JSON).build();
        System.out.println(exception.getMessage());
        exception.printStackTrace();
        return Response.status(500).entity("{\"error\": \"Something bad happened. Please try again !!\"}").type(MediaType.APPLICATION_JSON).build();
    }
}
