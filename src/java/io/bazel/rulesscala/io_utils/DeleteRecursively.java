package io.bazel.rulesscala.io_utils;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
import java.io.IOException;

public class DeleteRecursively {
  public static void run(Path path) throws IOException {
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
     @Override
     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
           Files.delete(file);
           return FileVisitResult.CONTINUE;
       }

       @Override
       public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
           Files.delete(dir);
           return FileVisitResult.CONTINUE;
       }
    });
  }
}
