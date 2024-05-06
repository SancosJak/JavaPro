package de.ait;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EducationCenterApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void simple_test() throws Exception{
        mockMvc.perform(get("/api/courses"))
                .andDo(print());
    }

    @Test
    public void return_list_of_courses_test() throws Exception{
        mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk());
    }

}
