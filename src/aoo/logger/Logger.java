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
    private static final String timestampFormat = "YYMMdd-HHmmss";

    private final BufferedWriter bufferedWriter;
    private final File file;

    public Logger() {
        final String filename = dirname + getCurrentTimestamp() + ".log";
        try {
            file = new File(filename);
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            this.generateHeader();
        } catch (IOException ex) {
            throw new RuntimeException("Unable to create log file: " + filename);
        }
    }

    private void generateHeader() {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            bufferedWriter.write("/*********************/");
            bufferedWriter.newLine();
            bufferedWriter.write("/* Date: " + timestamp + "  */");
            bufferedWriter.newLine();
            bufferedWriter.write("/*********************/");
            bufferedWriter.newLine();
            bufferedWriter.write("/* Starting Program  */");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            System.out.println("Starting program...\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void generateFooter() {
        try {
            bufferedWriter.write("/*********************/");
            bufferedWriter.newLine();
            bufferedWriter.write("/*   END OF PROGRAM  */");
            bufferedWriter.newLine();
            bufferedWriter.write("/*********************/");
            bufferedWriter.newLine();
            System.out.println("\nProgram finished");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void logEvent(String event) {
        System.out.println(event);
        if(bufferedWriter == null) return;
        try {
            bufferedWriter.write(event);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("Error occurred while logging event: " + event);
            ex.printStackTrace();
        }
    }

    public void logEvent(String event, Exception ex) {
        logEvent(event);
        logEvent(ex.getMessage());
        ex.printStackTrace();
    }

    public File getFile() {
        return file;
    }

    private String getCurrentTimestamp() {
        return new SimpleDateFormat(timestampFormat).format(new Date());
    }

    @Override
    public void close() throws Exception {
        this.generateFooter();
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
