package multi_tenant_back.tenant_api.barbershops;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
public class TestBarberShopsController {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBarberShop() throws Exception {
        String payload = """
                {"name": "Barberia Jhon",
                "address": "Calle falsa 123",
                "phone": 12345678901,
                "city": {
                    "id": 1,
                    "name": "Ciudad Falsa"
                }}
                """;
        mockMvc.perform(post("/barbershops")
                .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Barberia Jhon"));
    }
}
