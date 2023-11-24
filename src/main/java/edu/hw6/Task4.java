package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private Task4() {
    }

    public static void writeTextToFile(String fileName) {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(fileName), StandardOpenOption.CREATE);
             OutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                 bufferedOutputStream,
                 StandardCharsets.UTF_8
             );
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            String text = "Programming is learned by writing programs. ― Brian Kernighan";
            printWriter.println(text);

        } catch (IOException ignored) {
        }
    }
}
