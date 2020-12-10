package fr.paris8univ.iut.csid.csidwebrepositorybase;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "repository")
public class GitRepositoryEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "forks")
    private int forks;

    @Column(name = "open_issues")
    private int open_issues;

  //  @Temporal(TemporalType.TIME)
   // @Column(name = "time")
  //  private Time time;

    public GitRepositoryEntity(){

    }

    public GitRepositoryEntity(String name, String owner ,int forks, int open_issues){

        this.name = name;
        this.owner = owner;
        this.forks = forks;
        this.open_issues = open_issues;
       // this.time = time;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
/*
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }*/
}
