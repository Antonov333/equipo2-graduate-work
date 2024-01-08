package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.service.ImagesService;

@RestController
@Data
@Tag(name = "Images Controller", description = "Picture delivery to frontend application")
@RequestMapping("/images")
public class ImagesController {
    private final ImagesService imagesService;

    @GetMapping(value = "/{pictureId}", produces = {MediaType.IMAGE_PNG_VALUE,
            MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, "image/*"})
    byte[] getPicture(@PathVariable(name = "pictureId") Long pictureId) {
        return imagesService.getPictureData(pictureId);
    }

    /*
    * @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "ad_id")
    private long adId;

    @Enumerated(EnumType.STRING)
    @Column(name = "picture_type")
    private PictureType pictureType;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_size")
    private long fileSize;

    @Column(name = "media_type")
    private String mediaType;

    @Lob
    @Column(name = "data")
    private byte[] data;

}
    * */

}
