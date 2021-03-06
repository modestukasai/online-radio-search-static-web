package com.modzo.ors.web.api.radio.stations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "radioStationsClient", url = "${application.apiUrl}")
public interface RadioStationsClient {

    @GetMapping("/radio-stations?enabled=true&sort=id%2Cdesc&size=${application.radioStationsClient.size:1}")
    PagedModel<EntityModel<RadioStationResponse>> getRadioStationsSortedDesc(@RequestParam("page") long page);

    @GetMapping("/radio-stations?enabled=true")
    PagedModel<EntityModel<RadioStationResponse>> getRadioStations(@RequestParam("page") long page,
                                                                   @RequestParam("size") int size);

    @GetMapping("/radio-stations?enabled=true&size=${application.radioStationsClient.size:1}")
    PagedModel<EntityModel<RadioStationResponse>> getRadioStationByPlayedSongId(
            @RequestParam("songId") long songId,
            @RequestParam("page") long page
    );

    @GetMapping("/radio-stations?enabled=true&size=${application.radioStationsClient.size:1}")
    PagedModel<EntityModel<RadioStationResponse>> getRadioStationByGenreId(
            @RequestParam("genreId") long genreId,
            @RequestParam("page") long page
    );

    @GetMapping("/radio-stations/{id}")
    EntityModel<RadioStationResponse> getRadioStation(@PathVariable("id") long id);
}