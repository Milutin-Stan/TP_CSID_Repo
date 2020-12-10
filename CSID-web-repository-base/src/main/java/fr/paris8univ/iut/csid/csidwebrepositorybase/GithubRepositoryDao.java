package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GithubRepositoryDao {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubRepositoryDao(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public GithubRepositoryDto getGitJson(String repository,String owner) throws RestClientException, URISyntaxException {
        return restTemplate.getForEntity(new URI("https://api.github.com/repos/"+owner+"/"+repository),GithubRepositoryDto.class).getBody();
    }
}
