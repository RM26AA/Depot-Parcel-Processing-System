import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private static Log instance; //singleton instance
    private List<String> events;

    private Log()
    {
        events = new ArrayList<>();
    }

    //get the singleton instance
    public static Log getInstance()
    {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    //log an event
    public void logEvent(String event)
    {
        events.add(event);
        System.out.println("Event logged: " + event);
    }

    //write log to a file
    public void writeLogToFile(String filename)
    {
        try (FileWriter writer = new FileWriter(filename))
        {
            for (String event : events)
            {
                writer.write(event + "\n");
            }
            System.out.println("Log written to " + filename);
        } catch (IOException e)
        {
            System.err.println("Error writing log to file: " + e.getMessage());
        }
    }
}

