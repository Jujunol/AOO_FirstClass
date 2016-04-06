package aoo.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 200240927 on 4/6/2016.
 */
public class Logger implements AutoCloseable {

    private static final String dirname = "logs/";
    private static final String timestampFormat = "YYmmdd-HHMMss";
    
    private final BufferedWriter bufferedWriter;
    private final File file;

    public Logger() {
        final String filename = dirname + getCurrentTimestamp() + ".log";
        try {
            file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            throw new RuntimeException("Unable to create log file: " + filename);
        }
    }

    public void logEvent(String event) {
        if(bufferedWriter == null) return;
        try {
            bufferedWriter.write(event);
        } catch (IOException ex) {
            System.err.println("Error occurred while logging event: " + event);
            ex.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    private String getCurrentTimestamp() {
        return new SimpleDateFormat(timestampFormat).format(new Date());
    }

    @Override
    public void close() throws Exception {
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
