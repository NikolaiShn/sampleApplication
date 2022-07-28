package model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "listrecords")
public class Record {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "some_number")
    private Double number;
    @Column(name = "some_text")
    private String text;
    @Column(name = "some_date")
    private LocalDateTime date;
    @Lob
    private byte[] image;
    @Column(name = "image_original_name")
    private String imageOriginalName;
    @Column(name = "image_format")
    private String imageFormat;
}
