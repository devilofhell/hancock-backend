package me.synology.jstieler.hancockapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue
    long id;

    String filename;

    Date uploadDate;

    /*
    User owner;

    List<Like> likes;
    List<Album> albums;
     */

    public Picture() {
    }

    public Picture(long id, String filename, Date uploadDate) {
        this.id = id;
        this.filename = filename;
        this.uploadDate = uploadDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
