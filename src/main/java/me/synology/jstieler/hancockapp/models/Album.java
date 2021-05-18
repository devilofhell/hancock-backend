package me.synology.jstieler.hancockapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Album {

    @Id
    @GeneratedValue
    long id;

    String title;

    /*
    User owner;

    List<Picture> children;
    List<Like> likes;

     */
}
