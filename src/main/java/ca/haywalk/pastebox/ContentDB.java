package ca.haywalk.pastebox;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Manage storing and retrieving content.
 * 
 * @author Hayden Walker
 * @version 2025-06-25
 */
public class ContentDB {
    /**
     * Folder
     */
    private static final String FOLDER = "pastes";

    /**
     * Singleton instance.
     */
    private static ContentDB instance;

    /**
     * Create a new ContentDB.
     */
    private ContentDB() {

    }

    /**
     * Get the ContentDB instance.
     * @return ContentDB instance.
     */
    public static ContentDB instance() {
        if (instance == null) {
            instance = new ContentDB();
        }

        return instance;
    }

    /**
     * Upload content.
     * 
     * @param content Content.
     * @return Content ID.
     */
    public String addContent(String content) {
        String id = Long.toString(System.currentTimeMillis());

        try {
            File newFile = new File(FOLDER + "/" + id);
            FileUtils.write(newFile, content, "utf-8");
            return id;
        } catch (IOException e) {
            return "500";
        }
    }

    /**
     * Retrieve content.
     * 
     * @param id Content ID.
     * @return Content.
     */
    public String getContent(String id) {
        try {
            File file = new File(FOLDER + "/" + id);
            String content = FileUtils.readFileToString(file, "utf-8");
            return content; 
        } catch(IOException e) {
            return "404";
        }
    }
}
