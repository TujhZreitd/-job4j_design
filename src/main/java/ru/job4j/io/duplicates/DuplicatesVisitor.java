package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import static java.nio.file.Files.size;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> files = new HashMap<>();

    public Map<FileProperty, List<Path>> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty newFile = new FileProperty(size(file), file.toFile().getName());
        if (!files.containsKey(newFile)) {
            files.computeIfAbsent(newFile, s -> new ArrayList<>(List.of(file)));
        } else {
            files.get(newFile).add(file);
        }

        return super.visitFile(file, attributes);
    }
}
