package com.bezkoder.spring.test.controller;

//import com.bezkoder.spring.test.model.Hikes;
import com.bezkoder.spring.test.model.Trail;
import com.bezkoder.spring.test.repository.TrailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import com.bezkoder.spring.test.controller.TrailController;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrailController.class)
class TrailControllerTest {
    @MockBean
    private TrailRepository trailRepository;



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateTrail() throws Exception {
        Trail trail = new Trail("Mordor", "15:00", "17:00", 99.23);

        mockMvc.perform(post("/trails/create").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(trail)))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    void integrationTestCreateFind() throws Exception {
        Trail trail = new Trail("Mordor", "15:00", "17:00", 99.23);

        mockMvc.perform(post("/trails/create").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(trail)))
                .andExpect(status().isOk());
        assertEquals(trail.getName(),"Mordor");
    }


}