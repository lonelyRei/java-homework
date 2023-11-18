package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

@FunctionalInterface
public interface CastomAbstractFilter extends DirectoryStream.Filter<Path> {
    CastomAbstractFilter REGULAR_FILE = Files::isRegularFile;
    CastomAbstractFilter READABLE = Files::isReadable;

    static CastomAbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static CastomAbstractFilter magicNumber(int... magicBytes) {
        return path -> {
            try {
                byte[] fileBytes = Files.readAllBytes(path);
                if (fileBytes.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if (fileBytes[i] != (byte) magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static CastomAbstractFilter globMatches(String glob) {
        return path -> path.getFileName().toString().matches(glob);
    }

    static CastomAbstractFilter regexContains(String regex) {
        return path -> path.getFileName().toString().matches(".*" + regex + ".*");
    }

    default CastomAbstractFilter and(CastomAbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }
}
