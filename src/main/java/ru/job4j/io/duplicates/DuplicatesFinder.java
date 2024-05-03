package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor res = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("C:\\Users\\pc\\Desktop\\X1"), res);
        for (Map.Entry<FileProperty, List<Path>> entry : res.getFiles().entrySet()) {
            List<Path> result = entry.getValue();
            if (result.size() > 1) {
                System.out.println(result);
            }
        }
    }
}
