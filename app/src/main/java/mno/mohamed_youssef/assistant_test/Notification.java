package mno.mohamed_youssef.assistant_test;

/**
 * Created by Mohamed Yossif on 28/04/2016.
 */
public class Notification {

    private String title ;
    private String description;
    private int  year ;
    private String group ;
    private String section;


    public Notification(String title , String description , int year , String group ,String section){
        this.title = title;
        this.description = description;
        this.year = year;
        this.group = group ;
        this.section = section;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    public String getSection() {
        return section;
    }
}
