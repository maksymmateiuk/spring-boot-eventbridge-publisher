package com.mmateiuk.springbooteventbridgepublisher.controller;

import com.mmateiuk.springbooteventbridgepublisher.model.common.Event;
import com.mmateiuk.springbooteventbridgepublisher.model.common.TnDetail;
import com.mmateiuk.springbooteventbridgepublisher.model.response.DemoResponse;
import com.mmateiuk.springbooteventbridgepublisher.services.impl.EventServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tn", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    private final EventServiceImpl eventService;

    public DemoController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<DemoResponse> provisionTn(@RequestBody Event<TnDetail> event) {

        String eventId = eventService.sendEvent(event);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(DemoResponse.newBuilder()
                        .withId(eventId)
                        .withEvent(event)
                        .build());
    }
}
