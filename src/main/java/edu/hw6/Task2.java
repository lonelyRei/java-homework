package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Task2 {
    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        String fileName = path.getFileName().toString();
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));

        int copyNumber = 1;
        Path copyPath = path.resolveSibling(baseName + " — копия" + extension);

        while (Files.exists(copyPath)) {
            copyNumber++;
            copyPath = path.resolveSibling(baseName + " — копия (" + copyNumber + ")" + extension);
        }

        Files.copy(path, copyPath, StandardCopyOption.COPY_ATTRIBUTES);
    }
}
