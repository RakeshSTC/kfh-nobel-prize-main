package kfh.nobel.prize.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


//		{
//		"id": "992",
//		"firstname": "Jennifer A.",
//		"surname": "Doudna",
//		"motivation": "\"for the development of a method for genome editing\"",
//		"share": "2"
//		}

@Entity
@Table(name = "laureate")
public class Laureate {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    private String firstname;
    private String surname;

    @Lob
    @Column( length = 100000 )
    private String motivation;
    private String share;

    public Laureate(){
    }

    public Laureate(String id, String firstname, String surname, String motivation, String share) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.motivation = motivation;
        this.share = share;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
