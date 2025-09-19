package com.sonukumar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtil {
    public static byte[] readImage(String fileName) throws IOException {
        Path path = Paths.get("src/main/resources/images/" + fileName);
        return Files.readAllBytes(path);
    }
}
