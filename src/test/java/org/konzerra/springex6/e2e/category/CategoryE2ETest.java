package org.konzerra.springex6.e2e.category;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.konzerra.springex6.domain.category.Category;
import org.konzerra.springex6.domain.category.CategoryApi;
import org.konzerra.springex6.domain.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// TODO dangerous setting up for test
// It can possibly load default yml and its datasource if profile is not set properly
@ActiveProfiles("tester")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository; // Assuming you're directly using a repository for test data preparation

    private String baseUrl;
    private Long firstId;
    @BeforeEach
    void setUp() {
        // Assuming CategoryApi.FIND_BY_ID is something like "/categories/{id}"
        this.baseUrl = "http://localhost:" + port;

        // Prepare test data
        Category category = new Category();
        category.setName("Sports");
        category.setDescription("Athletics is good for health");
        category = categoryRepository.save(category);
        firstId = category.getId();
    }

    @AfterEach
    void tearDown() {
        // Clean up test data to ensure independence of tests

    }

    @Test
    void testFindById() {
        // Perform the test
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + CategoryApi.FIND_BY_ID, String.class, firstId);

        // Assert the response status code and body
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Sports");
        // More assertions can be added to validate the response content
    }
}
