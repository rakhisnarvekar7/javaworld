package com.hsbc.java.test;


import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import java.io.IOException;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.*;

public class FileHandlingTest {
    {

    @Test
    public void testReverseFileContent() throws IOException {
        // Prepare a test content
        String testContent = "Hello, this is a test content.";

        // Create mock objects for file operations
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        BufferedWriter mockBufferedWriter = mock(BufferedWriter.class);

        // Mock file reading
        when(mockFileReader.readLine()).thenReturn(testContent, null);

        // Mock file writing
        doNothing().when(mockBufferedWriter).write(anyString());
        doNothing().when(mockBufferedWriter).close();

        // Inject mocks into the ReverseFileContent class
        ReverseFileContent reverseFileContent = new ReverseFileContent();
        reverseFileContent.setFileReader(mockFileReader);
        reverseFileContent.setFileWriter(mockFileWriter);

        // Run the main program logic
        reverseFileContent.reverseContent("input.txt", "output.txt");

        // Verify that the mocked methods were called as expected
        verify(mockFileReader, times(2)).readLine();
        verify(mockBufferedWriter).write(anyString());
        verify(mockBufferedWriter).close();
    }
}

