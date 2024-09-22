package studycaseaplikasiapi.springbeaidil.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.mockito.Mockito.*;
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class BatchJobTest {

    @MockBean
    private BatchJob batchJob;

    @BeforeEach
    public void setup() {
        // Spy the actual batch job to keep the original method behavior
        batchJob = Mockito.spy(new BatchJob());
    }

    @Test
    public void testProcessTextFile() throws IOException {
        // Mock BufferedReader to simulate file reading
        BufferedReader bufferedReaderMock = Mockito.mock(BufferedReader.class);
        when(bufferedReaderMock.readLine())
                .thenReturn("Line 1", "Line 2", "Line 3", null); // Simulate three lines of text

        // Override the createBufferedReader method to return the mocked BufferedReader
        doReturn(bufferedReaderMock).when(batchJob).createBufferedReader(anyString());

        // Execute the batch job method
        batchJob.processTextFile();

        // Verify that 'readLine' is called for each line, plus one additional time for the null return (end of file)
        verify(bufferedReaderMock, times(4)).readLine();

        // Optionally, you could verify that System.out.println is called to print each line
        // This part depends on your logic; remove if not applicable
        verify(batchJob, times(1)).processTextFile();
    }
}
