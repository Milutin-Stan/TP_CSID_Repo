package fr.paris8univ.iut.csid.csidwebrepositorybase;

import java.sql.Time;

public class GitRepository {

    private String name;
    private String owner;
    private int forks;
    private int open_issues;
   // private Time time;

    public GitRepository(){
    }

    public GitRepository(String name, String owner, int forks, int open_issues){
        this.name = name;
        this.owner = owner;
        this.forks = forks;
        this.open_issues = open_issues;
       // this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getForks() {
        return forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

  /*  public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }*/
}
