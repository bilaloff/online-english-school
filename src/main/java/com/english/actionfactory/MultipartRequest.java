package com.english.actionfactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipartRequest {

    private final Map<String, FileItem> itemMap = new HashMap<>();

    public MultipartRequest(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = request.getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            items.forEach(item -> itemMap.put(item.getFieldName(), item));
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    public FileItem getItem(String fieldName) {
        return itemMap.get(fieldName);
    }
}
