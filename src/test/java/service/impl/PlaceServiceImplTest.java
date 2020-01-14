package service.impl;

import dao.DaoCRUD;
import dao.impl.PlaceDaoImpl;
import dto.PlaceDto;
import entity.Place;
import exception.NotFoundException;
import mapper.PlaceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static exception.Message.PLACE_NOT_FOUND_EXCEPTION_MESSAGE;
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

    List<Place> emptyPlaceList = new ArrayList<>();

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


    @Test
    public void getByIdTest() {

        Place expectedPlace = new Place(1L,
                                        "country",
                                        "town",
                                        "name",
                                        "desc",
                                        "photo");

        when(daoCRUD.getById(1L)).thenReturn(Optional.of(expectedPlace));

        PlaceDto resultPlaceDto = placeServiceImpl.getById(1L);

        assertEquals("country", resultPlaceDto.getCountry());
        assertEquals("town", resultPlaceDto.getTown());
        assertEquals("name", resultPlaceDto.getName());

        verify(daoCRUD, times(1)).getById(anyLong());
    }

    @Test(expected = NotFoundException.class)
    public void getByIdExceptionTest() {

        long nonexistentId = 1L;

        when(daoCRUD.getById(nonexistentId)).thenThrow(new NotFoundException(String.format(PLACE_NOT_FOUND_EXCEPTION_MESSAGE, nonexistentId)));

        placeServiceImpl.getById(nonexistentId);
    }




//    @Override
//    public PlaceDto getById(Long id) {
//        Place place = daoCRUD.getById(id)
//                .orElseThrow(() -> new NotFoundException(String.format(PLACE_NOT_FOUND_EXCEPTION_MESSAGE, id)));
//
//        return PlaceMapper.getPlaceDto(place);
//    }
//
//    @Override
//    public PlaceDto getByField(String text) {
//        Place place = daoCRUD.getByField(text)
//                .orElseThrow(() -> new NotFoundException(String.format(PLACENAME_NOT_FOUND_EXCEPTION_MESSAGE, text)));
//
//        return PlaceMapper.getPlaceDto(place);
//    }
//
    @Test
    public void getAllPlacesTest() {

        when(daoCRUD.getAll()).thenReturn(testPlaceList);

        List<PlaceDto> resultList = placeServiceImpl.getAll();

        assertEquals(testPlaceDtoList, resultList);

        verify(daoCRUD, times(1)).getAll();
    }

        @Test(expected = NotFoundException.class)
        public void getAllPlacesExceptionTest() {

            when(daoCRUD.getAll()).thenReturn(emptyPlaceList);

            placeServiceImpl.getAll();
        }
//
//    @Override
//    public List<PlaceDto> getAllLimit() {
//        List<Place> list = daoCRUD.getAllLimit();
//
//        List<PlaceDto> placeDtoList = list.stream()
//                .map(PlaceMapper::getPlaceDto)
//                .collect(Collectors.toList());
//
//        if (placeDtoList.isEmpty()) {
//            throw new NotFoundException(EMPTY_PLACE_LIST_EXCEPTION_MESSAGE);
//        }
//        return placeDtoList;
//    }
//
//    @Override
//    public List<PlaceDto> getByTemplate(String template) {
//        PlaceDaoImpl placeDao = new PlaceDaoImpl();
//        List<Place> list = placeDao.getByTemplate(template);
//
//        List<PlaceDto> placeDtoList = list.stream()
//                .map(PlaceMapper::getPlaceDto)
//                .collect(Collectors.toList());
//
//        if (placeDtoList.isEmpty()) {
//            throw new NotFoundException(EMPTY_PLACE_LIST_EXCEPTION_MESSAGE);
//        }
//        return placeDtoList;
//    }
//
//    @Override
//    public boolean insert(Place place) {
//        if (daoCRUD.insert(place)) {
//            return true;
//        } else {
//            throw new NotFoundException(CREATE_PLACE_EXCEPTION_MESSAGE);
//        }
//    }
//
//    @Override
//    public boolean updateByEntity(Place place) {
//        if (daoCRUD.updateByEntity(place)) {
//            return true;
//        } else {
//            throw new NotFoundException(UPDATE_PLACE_EXCEPTION_MESSAGE);
//        }
//    }
//
//    @Override
//    public boolean updateByField(String text, String textCondition) {
//        if (daoCRUD.updateByField(text, textCondition)) {
//            return true;
//        } else {
//            throw new NotFoundException(UPDATE_PLACE_EXCEPTION_MESSAGE);
//        }
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        if (daoCRUD.deleteById(id)) {
//            return true;
//        } else {
//            throw new NotFoundException(DELETE_PLACE_EXCEPTION_MESSAGE);
//        }
//    }
////
////    @Override
////    public boolean deleteByFieldName(String textCondition) {
////        return daoCRUD.deleteByFieldName(textCondition);
////    }
//
//    @Override
//    public boolean delete(Place place) {
//        if (daoCRUD.delete(place)) {
//            return true;
//        } else {
//            throw new NotFoundException(DELETE_PLACE_EXCEPTION_MESSAGE);
//        }
//    }
}
