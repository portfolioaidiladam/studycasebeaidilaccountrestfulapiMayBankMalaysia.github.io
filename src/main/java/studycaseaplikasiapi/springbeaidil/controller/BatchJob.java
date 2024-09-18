package studycaseaplikasiapi.springbeaidil.controller;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class BatchJob {

    private final String filePath = "path/to/your/textfile.txt"; // Update with actual file path

    @Scheduled(fixedRate = 60000) // Every 60 seconds
    public void processTextFile() {
        try (BufferedReader br = createBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process each line
                System.out.println(line); // Printing for demonstration; replace with actual processing logic
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Allow the BufferedReader creation to be overridden in tests
    protected BufferedReader createBufferedReader(String filePath) throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }
}
