package Utils;

public class EndPoints {

    protected static final String BASE_URI = FileOperation.getProperties("Environment").getProperty("baseUri");
    protected static final String PATH_CONTACTS = FileOperation.getProperties("Environment").getProperty("contacts");
    protected static final String PATH_USERS = FileOperation.getProperties("Environment").getProperty("user");
    protected static final String PATH_SESSIONS = FileOperation.getProperties("Environment").getProperty("sessions");
    protected static final String PATH_TASKS = FileOperation.getProperties("Environment").getProperty("tasks");
}

