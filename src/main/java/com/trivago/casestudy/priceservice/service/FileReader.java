package com.trivago.casestudy.priceservice.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
