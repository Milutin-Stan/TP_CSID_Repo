package fr.paris8univ.iut.csid.csidwebrepositorybase;

import javax.persistence.*;

@Entity
@Table(name = "stats")
public class StatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "entry_type")
    private String entry_type;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "value")
    private int value;

    @Column(name = "repository_name")
    private  String repository_name;


    public StatsEntity(){

    }

    public StatsEntity(int id, String entry_type, String datetime, int value, String repository_name) {
        this.id = id;
        this.entry_type = entry_type;
        this.datetime = datetime;
        this.value = value;
        this.repository_name = repository_name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public void setEntry_type(String entry_type) {
        this.entry_type = entry_type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }
}
