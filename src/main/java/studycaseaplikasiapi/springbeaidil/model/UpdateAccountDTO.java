package studycaseaplikasiapi.springbeaidil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAccountDTO {
    private String description;

    // Getters and Setters
}
