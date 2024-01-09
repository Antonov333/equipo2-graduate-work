package ru.skypro.homework.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;

@Mapper
public interface AdMapper {
    AdMapper INSTANCE = Mappers.getMapper(AdMapper.class);

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long pk;
//    @Column(name = "Author")
//    private Integer author;


    //
//    @Column(name = "URL")
//    private String image;
//
//    @Column(name = "Price")
//    @Size(min = 0, max = 1000000000)
//    private Integer price;
//
//    @Column(name = "Title")
//    @Size(min = 4, max = 32)
//    private String title;
    AdDto adToDto (Ad ad);


    Ad adDtoToad(AdDto dto);

    Ad CrOUpdToAd(CreateOrUpdateAdDto createOrUpdateAdDto);

}
