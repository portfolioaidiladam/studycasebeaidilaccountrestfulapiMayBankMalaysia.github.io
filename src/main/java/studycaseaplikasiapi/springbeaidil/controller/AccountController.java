package studycaseaplikasiapi.springbeaidil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import studycaseaplikasiapi.springbeaidil.model.AccountDTO;
import studycaseaplikasiapi.springbeaidil.model.UpdateAccountDTO;
import studycaseaplikasiapi.springbeaidil.service.AccountService;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{customerId}")
    public AccountDTO getAccountByCustomerId(@PathVariable String customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public AccountDTO getAccountByAccountNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody UpdateAccountDTO updateAccountDTO) {
        accountService.updateAccount(id, updateAccountDTO);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        return accountService.getAllAccounts(pageable);
    }


}
