package studycaseaplikasiapi.springbeaidil.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountDTO {
    @Size(max = 200)
    private Long id;
    @Size(max = 50)
    private String customerId;
    @Size(max = 50)
    private String accountNumber;
    @Size(max = 200)
    private String description;

    // Getters and Setters
}
