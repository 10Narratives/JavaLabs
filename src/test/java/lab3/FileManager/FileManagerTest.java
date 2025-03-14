package lab3.FileManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @TempDir
    Path tempDir;

    private File testDirectory;

    @BeforeEach
    void setUp() throws IOException {
        testDirectory = tempDir.toFile();

        Files.createFile(tempDir.resolve("file1.txt"));
        Files.createFile(tempDir.resolve("file2.jpg"));
        Files.createFile(tempDir.resolve("file3.txt"));
        Files.createDirectory(tempDir.resolve("subdir1"));
        Files.createDirectory(tempDir.resolve("subdir2"));
        Files.createFile(tempDir.resolve("subdir1/file4.txt"));
    }

    @Test
    void testFilter_ValidDirectoryAndExtension() {
        String[] result = FileManager.filter(testDirectory.getAbsolutePath(), "txt");
        assertEquals(2, result.length);
        assertTrue(Arrays.asList(result).contains("file1.txt"));
        assertTrue(Arrays.asList(result).contains("file3.txt"));
    }

    @Test
    void testFilter_NoMatchingFiles() {
        String[] result = FileManager.filter(testDirectory.getAbsolutePath(), "pdf");
        assertEquals(0, result.length);
    }

    @Test
    void testFilter_InvalidDirectoryPath() {
        String invalidPath = "/invalid/path";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FileManager.filter(invalidPath, "txt");
        });
        assertEquals("The specified path is not an existing directory", exception.getMessage());
    }

    @Test
    void testSort_DirectoriesBeforeFiles() {
        File[] files = testDirectory.listFiles();
        assertNotNull(files, "The list of files should not be null");
        FileManager.sort(files);
        assertTrue(files[0].isDirectory());
        assertTrue(files[1].isDirectory());
        assertFalse(files[2].isDirectory());
    }

    @Test
    void testSort_AlphabeticalOrder() {
        File[] files = testDirectory.listFiles();
        assertNotNull(files, "The list of files should not be null");
        FileManager.sort(files);
        assertEquals("subdir1", files[0].getName());
        assertEquals("subdir2", files[1].getName());
        assertEquals("file1.txt", files[2].getName());
        assertEquals("file2.jpg", files[3].getName());
        assertEquals("file3.txt", files[4].getName());
    }

    @Test
    void testSort_EmptyArray() {
        File[] files = new File[0];
        assertDoesNotThrow(() -> FileManager.sort(files));
    }
}