package studycaseaplikasiapi.springbeaidil.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id", nullable = false)
    private String customerId;
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

}
