package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private void validate(ArgsName zip) {
        Path start = Path.of(zip.get("d"));
        if (!Files.exists(start)) {
            throw new IllegalArgumentException(String.format("Not exists %s", start.toAbsolutePath()));
        }
        if (!Files.isDirectory(start)) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toAbsolutePath()));
        }
        String extension = zip.get("e");
        if (!extension.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Error format extension %s", extension));
        }
        String archive = zip.get("o");
        if (!archive.endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Error format archive %s", archive));
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    if (Files.isRegularFile(path)) {
                        zip.write(input.readAllBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName inputArgs = ArgsName.of(args);
        zip.validate(inputArgs);
        List<Path> source = Search.search(Path.of(inputArgs.get("d")), path -> !path.toString().endsWith(inputArgs.get("e")));
        File target = new File(inputArgs.get("o"));
        zip.packFiles(source, target);
    }
}