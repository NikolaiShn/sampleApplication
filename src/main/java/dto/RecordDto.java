package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordDto {
    private Double number;
    private String text;
    private LocalDateTime date;
    private String image;
    private String imageOriginalName;
    private String imageFormat;
}
