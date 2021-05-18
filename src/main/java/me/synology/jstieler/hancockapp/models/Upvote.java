package me.synology.jstieler.hancockapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upvote")
public class Upvote {

    //User user;
    @Id
    @GeneratedValue
    long id;

    String type;

}
