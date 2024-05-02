package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import static java.nio.file.Files.size;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<String, Long> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty newFile = new FileProperty(size(file), file.toFile().getName());
        if (files.containsKey(newFile.getName())) {
            if (files.get(newFile.getName()) == newFile.getSize()) {
                System.out.println(file);
            }
        } else {
            files.put(newFile.getName(), newFile.getSize());
        }
        return super.visitFile(file, attributes);
    }
}
