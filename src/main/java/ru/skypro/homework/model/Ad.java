package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ads")
@Data
@NoArgsConstructor
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer pk;

    @Column(name = "Author")
    private Integer author;

    @Column(name = "URL")
    private String image;

    @Column(name = "Price")
    @Size(min = 0, max = 1000000000)
    private Integer price;

    @Column(name = "Title")
    @Size(min = 4, max = 32)
    private String title;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @JsonIgnore
    @Column(name = "Data")
    private byte[] data;

    public Ad(Integer pk, Integer author, String image, Integer price, String title, byte[] data) {
        this.pk = pk;
        this.author = author;
        this.image = image;
        this.price = price;
        this.title = title;
        this.data = data;
    }
    // removed commented out code
}
