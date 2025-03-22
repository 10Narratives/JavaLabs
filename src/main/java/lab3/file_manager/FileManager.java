package lab3.file_manager;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * The {@code FileManager} class provides utility methods for working with files and directories.
 */
public final class FileManager {

    /**
     * Filters files in the specified directory by the given extension.
     *
     * <p>This method checks if the provided directory path exists and is a valid directory.
     * If the path is invalid or does not point to a directory, an {@link IllegalArgumentException}
     * is thrown. Otherwise, it returns an array of file names that end with the specified extension.</p>
     *
     * @param directoryPath the path to the directory to filter files from
     * @param extension     the file extension to filter by (e.g., "txt", "jpg")
     * @return an array of file names in the directory that match the specified extension
     * @throws IllegalArgumentException if the provided path is not an existing directory
     */
    public static String[] filter(String directoryPath, String extension) {
        File directory = new File(directoryPath);

        // Validate that the provided path is an existing directory
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("The specified path is not an existing directory");
        }

        // Filter files by the specified extension using a lambda expression
        return directory.list((dir, name) -> name.endsWith("." + extension));
    }

    /**
     * Sorts an array of {@link File} objects in a specific order.
     *
     * <p>This method sorts the files such that directories appear before regular files.
     * If both files are directories or both are regular files, they are sorted alphabetically
     * by their absolute paths.</p>
     *
     * @param files the array of {@link File} objects to be sorted
     */
    public static void sort(File[] files) {
        Comparator<File> comparator = (file1, file2) -> {
            if (file1.isDirectory() && !file2.isDirectory()) {
                return -1;
            } else if (!file1.isDirectory() && file2.isDirectory()) {
                return 1;
            } else {
                return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
            }
        };
        Arrays.sort(files, comparator);
    }
}
