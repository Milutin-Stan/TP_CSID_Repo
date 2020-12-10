package fr.paris8univ.iut.csid.csidwebrepositorybase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryDto {


    private String name;
    private String login;
    private int forks;
    private int open_issues;

    @Autowired
    public GithubRepositoryDto(String name, String login, int forks, int open_issues){
        this.name = name;
        this.login= login;
        this.forks = forks;
        this.open_issues = open_issues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }
}
