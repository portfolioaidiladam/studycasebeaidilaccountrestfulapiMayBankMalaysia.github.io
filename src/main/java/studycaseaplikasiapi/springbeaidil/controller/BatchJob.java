package studycaseaplikasiapi.springbeaidil.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@Slf4j
@Component
public class BatchJob {

    private final String filePath = "src/main/resources/files/dataSource.txt";

    @Scheduled(fixedRate = 60000)
    public void processTextFile() {
        try (BufferedReader br = createBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedReader createBufferedReader(String filePath) throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }
}
