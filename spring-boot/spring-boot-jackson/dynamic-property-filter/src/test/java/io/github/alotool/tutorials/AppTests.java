package io.github.alotool.tutorials;

import io.github.alotool.tutorials.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AppTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void test_getBooks_IgnoreProperties_quantity_and_gender() throws Exception {
        mvc.perform(get("/api/books").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].name").value(hasItem("Spring in Action")))
            .andExpect(jsonPath("$.[*].price").value(hasItem(1000.0)))
            .andExpect(jsonPath("$.[*].quantity").doesNotExist())
            .andExpect(jsonPath("$.[*].authors.[*].gender").doesNotExist());
    }

    @Test
    void test_getBooks_detail_IgnoreProperties_quantity_and_gender() throws Exception {

        final Long id = bookRepository.findAll().get(0).getId();

        mvc.perform(get("/api/books/" + id).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.quantity").doesNotExist())
            .andExpect(jsonPath("$.authors.[*].gender").doesNotExist());
    }

}
