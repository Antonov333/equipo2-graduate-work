package ru.skypro.homework;

import lombok.Data;
import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.mapping.AdMapper;
import ru.skypro.homework.model.Ad;

@Data
public class AdTest {



    @Test
   public void test1() {

        Ad ad = new Ad(11L, 5, "/images/5", 100, " title");
        AdDto adDto = AdMapper.INSTANCE.adToDto(ad);
        System.out.println("adDto = " + adDto);
    }

}
