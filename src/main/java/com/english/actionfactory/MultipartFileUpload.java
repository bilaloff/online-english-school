package com.english.actionfactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Random;

public class MultipartFileUpload {

    private final String realPath;

    public MultipartFileUpload(HttpServletRequest request) {
        realPath = request.getServletContext().getRealPath("");
    }

    public String save(FileItem uploadItem, String path) throws FileUploadException {
        File file;
        String fileExtension = getFileExtension(uploadItem);
        do {
            file = new File(realPath.concat(path), generateRandomName().concat(fileExtension));
        } while (file.exists());
        try {
            uploadItem.write(file);
        } catch (Exception e) {
            throw new FileUploadException("Something went wrong. Could not upload the file.");
        }
        return file.getName();
    }

    private static String generateRandomName() {
        int leftLimit = 48;
        int rightLimit = 122;
        int generatedNameLength = 30;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(generatedNameLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String getFileExtension(FileItem item) {
        String filename = item.getName();
        int startIndex = filename.lastIndexOf(".");
        if (startIndex == -1) {
            return "";
        }
        return filename.substring(startIndex);
    }
}
