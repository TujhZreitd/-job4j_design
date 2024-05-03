package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {
    public static void main(String[] args) throws IOException {
        validateMethod(args);
        search(Path.of(args[0]), path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validateMethod(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(String.format("Must be two arguments"));
        }
        Path start = Path.of(args[0]);
        if (!Files.exists(start)) {
            throw new IllegalArgumentException(String.format("Not exists %s", start.toAbsolutePath()));
        }
        if (!Files.isDirectory(start)) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toAbsolutePath()));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format("Absent character '.' in %s", args[1]));
        }
        if (args[1].length() < 2) {
            throw new IllegalArgumentException(String.format("Absent extension %s", args[1]));
        }
    }
}

class SearchFiles extends SimpleFileVisitor<Path> {
    private Predicate<Path> condition;
    private List<Path> paths = new ArrayList<>();

    public SearchFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            paths.add(file);
        }
        return CONTINUE;
    }
}