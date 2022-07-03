package edu.miu.bookclient.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class RestTemplateTest {
    @GetMapping()
    public String getResultsFromBookApplication() throws URISyntaxException {
        String resultFromBookApplication = "";

        RestTemplate rst = new RestTemplate();
        String bookResource = "http://localhost:4000/";
        URI uri = new URI(bookResource);

        ResponseEntity<String> response = rst.getForEntity(uri, String.class);
        System.out.println(response);
        return response.getBody();
    }
}
