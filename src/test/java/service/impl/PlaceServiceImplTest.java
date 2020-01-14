package service.impl;

import dao.DaoCRUD;
import dto.PlaceDto;
import entity.Place;
import mapper.PlaceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {

    @Mock
    DaoCRUD<Place> daoCRUD;

    @InjectMocks
    PlaceServiceImpl placeServiceImpl;

    List<PlaceDto> testPlaceDtoList = new ArrayList<>(Arrays
            .asList(new PlaceDto(1L, "country", "town", "name"),
                    new PlaceDto(2L, "country", "town", "name"),
                    new PlaceDto(3L, "country", "town", "name"),
                    new PlaceDto(4L, "country", "town", "name")
            ));

    List<Place> testPlaceList = testPlaceDtoList.stream().map(PlaceMapper::getPlaceEntity).collect(Collectors.toList());


    @Test
    public void getAllPlacesTest() {

        when(daoCRUD.getAll()).thenReturn(testPlaceList);

        List<PlaceDto> list = placeServiceImpl.getAll();

        assertEquals(4, list.size());

        verify(daoCRUD, times(1)).getAll();
    }

//    @Test
//    public void getPlaceByIdTest() {
//        when(daoCRUDImpl.getById(1L)).thenReturn(Optional.of(new Place(1L, "country", "town", "name", "desc", "photo")));
//
//        PlaceDto placeDto = placeService.getById(1L);
//
//        assertEquals("country", placeDto.getCountry());
//        assertEquals("town", placeDto.getTown());
//        assertEquals("name", placeDto.getName());
//    }
//
//    @Test
//    public void createPlaceTest()
//    {
//        Place place=new Place( 1L, "country", "town", "name", "desc", "photo");
//
//        placeService.insert(place);
//
//        verify(daoCRUDImpl, times(1)).insert(place);
//    }
}
