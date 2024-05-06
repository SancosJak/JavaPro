package de.ait.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CoursesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET/courses")
    public class GetCourses {

        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)// после теста база пересоздается заново
        public void return_empty_list_of_courses() throws Exception{
            mockMvc.perform(get("/api/courses"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()",is(0)));
        }
        @Test
        @Sql(scripts ="/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)// после теста база пересоздается заново
        public void return_list_of_courses_for_not_empty_database() throws Exception{
            mockMvc.perform(get("/api/courses"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()",is(4)))
                    .andExpect(jsonPath("$.[0].id",is(1)))
                    .andExpect(jsonPath("$.[1].id",is(2)))
                    .andExpect(jsonPath("$.[2].id",is(3)))
                    .andExpect(jsonPath("$.[3].id",is(4)))
                    .andExpect(jsonPath("$.[2].price",is(10.0)));

        }
    }

    @Nested
    @DisplayName("POST/courses")
    public class PostCourse {
        @Test
        @Sql(scripts ="/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)// после теста база пересоздается заново
        public void add_new_course() throws Exception{
            mockMvc.perform(post("/api/courses")
                    .contentType("application/json")
                    .content("{\"title\":\"New course3\",\"beginDate\":\"2024-02-02\",\"endDate\":\"2024-02-02\",\"description\":\"Description3\",\"price\":100.0}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id",is(5)))
                    .andExpect(jsonPath("$.title",is("New course3")))
                    .andExpect(jsonPath("$.beginDate",is("2024-02-02")))
                    .andExpect(jsonPath("$.endDate",is("2024-02-02")))
                    .andExpect(jsonPath("$.description",is("Description3")))
                    .andExpect(jsonPath("$.price",is(100.0)));
        }
    }

    @Nested
    @DisplayName("GET/courses/{course-id}:")
    public class GetCourse {
        @Test
        @Sql(scripts ="/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_existed_course_by_id() throws Exception{
            mockMvc.perform(get("/api/courses/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id",is(1)))
                    .andExpect(jsonPath("$.title",is("Course1")))
                    .andExpect(jsonPath("$.beginDate",is("2024-05-06")))
                    .andExpect(jsonPath("$.endDate",is("2024-05-06")))
                    .andExpect(jsonPath("$.description",is("Description1")))
                    .andExpect(jsonPath("$.price",is(100.0)));
        }

        @Test
        @Sql(scripts ="/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_404_not_existed_course_by_id() throws Exception{
            mockMvc.perform(get("/api/courses/5"))
                    .andExpect(status().isNotFound());
        }
    }
}