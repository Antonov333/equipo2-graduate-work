package ru.skypro.homework.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.skypro.homework.model.Images;
import ru.skypro.homework.repository.ImagesRepository;

import java.util.Optional;

@Service
@Data
public class ImagesService {
    final private ImagesRepository imagesRepository;

    public byte[] getPictureData(long pictureId) {
        Optional<Images> pictureOptional = imagesRepository.findById(pictureId);
        if (pictureOptional.isEmpty()) {
            return null;
        }
        Images picture = pictureOptional.get();
        return picture.getData();
    }
}
