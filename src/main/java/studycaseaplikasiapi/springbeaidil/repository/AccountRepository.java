package studycaseaplikasiapi.springbeaidil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studycaseaplikasiapi.springbeaidil.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCustomerId(String customerId);
    Account findByAccountNumber(String accountNumber);
}
