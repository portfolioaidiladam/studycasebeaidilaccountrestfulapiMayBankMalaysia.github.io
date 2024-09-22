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
        batchJob = Mockito.spy(new BatchJob());
    }

    @Test
    public void testProcessTextFile() throws IOException {
        BufferedReader bufferedReaderMock = Mockito.mock(BufferedReader.class);
        when(bufferedReaderMock.readLine())
                .thenReturn("Line 1", "Line 2", "Line 3", null);


        doReturn(bufferedReaderMock).when(batchJob).createBufferedReader(anyString());

        batchJob.processTextFile();


        verify(bufferedReaderMock, times(4)).readLine();


        verify(batchJob, times(1)).processTextFile();
    }
}
