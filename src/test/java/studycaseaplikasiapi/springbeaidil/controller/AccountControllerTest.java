package studycaseaplikasiapi.springbeaidil.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import studycaseaplikasiapi.springbeaidil.model.AccountDTO;
import studycaseaplikasiapi.springbeaidil.service.AccountService;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccountByCustomerId() throws Exception {

        AccountDTO mockAccount = AccountDTO.builder()
                .id(1L)
                .customerId("12345")
                .accountNumber("987654")
                .description("Mock Account")
                .build();


        when(accountService.getAccountByCustomerId("12345")).thenReturn(mockAccount);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{customerId}", "12345"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("987654"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Mock Account"));
    }

    @Test
    public void testGetAccountByAccountNumber() throws Exception {

        AccountDTO mockAccount = AccountDTO.builder()
                .id(2L)
                .customerId("54321")
                .accountNumber("123456")
                .description("Another Mock Account")
                .build();


        when(accountService.getAccountByAccountNumber("123456")).thenReturn(mockAccount);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/accountNumber/{accountNumber}", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value("54321"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("123456"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Another Mock Account"));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        String updateJson = "{ \"description\": \"Updated Description\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/accounts/{id}", 1L)
                        .contentType("application/json")
                        .content(updateJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
