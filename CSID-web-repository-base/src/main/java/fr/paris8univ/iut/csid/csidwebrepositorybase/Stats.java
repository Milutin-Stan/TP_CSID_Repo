package fr.paris8univ.iut.csid.csidwebrepositorybase;

public class Stats {

    private int id;
    private String entry_type;
    private String datetime;
    private int value;
    private String repository_name;

    public Stats(){

    }

    public Stats(int id, String entry_type, String datetime, int value, String repository_name){

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
