package studycaseaplikasiapi.springbeaidil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studycaseaplikasiapi.springbeaidil.entity.Account;
import studycaseaplikasiapi.springbeaidil.model.AccountDTO;
import studycaseaplikasiapi.springbeaidil.model.UpdateAccountDTO;
import studycaseaplikasiapi.springbeaidil.repository.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO getAccountByCustomerId(String customerId) {
        Account account = accountRepository.findByCustomerId(customerId);
        if (account != null) {
            return convertToDTO(account);
        }
        return null; // Consider throwing an exception or returning a custom response if not found
    }

    public AccountDTO getAccountByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            return convertToDTO(account);
        }
        return null; // Consider throwing an exception or returning a custom response if not found
    }

    public void updateAccount(Long id, UpdateAccountDTO updateAccountDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setDescription(updateAccountDTO.getDescription());
            accountRepository.save(account);
        } else {
            // Handle case where account is not found
            throw new RuntimeException("Account not found with id: " + id);
        }
    }

    public List<AccountDTO> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable).getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AccountDTO convertToDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .customerId(account.getCustomerId())
                .accountNumber(account.getAccountNumber())
                .description(account.getDescription())
                .build();
    }

}
