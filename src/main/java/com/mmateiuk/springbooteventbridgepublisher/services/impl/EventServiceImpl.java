package com.mmateiuk.springbooteventbridgepublisher.services.impl;

import com.mmateiuk.springbooteventbridgepublisher.model.common.Event;
import com.mmateiuk.springbooteventbridgepublisher.services.EventService;
import com.mmateiuk.springbooteventbridgepublisher.util.marshaller.Marshaller;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequest;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequestEntry;
import software.amazon.awssdk.services.eventbridge.model.PutEventsResponse;
import software.amazon.awssdk.services.eventbridge.model.PutEventsResultEntry;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public String sendEvent(Event event) {

        PutEventsResponse putEventsResponse;
        try (EventBridgeClient eventBridgeClient = EventBridgeClient.builder()
                .build()) {

            PutEventsRequestEntry requestEntry = PutEventsRequestEntry.builder()
                    .source(event.getSource())
                    .detail(Marshaller.marshal(event.getDetail()))
                    .detailType("Simple detail type") // required field
                    .eventBusName(event.getEventBus())
                    .build();

            List<PutEventsRequestEntry> requestEntries = Collections.singletonList(requestEntry);

            PutEventsRequest eventsRequest = PutEventsRequest.builder()
                    .entries(requestEntries)
                    .build();

            putEventsResponse = eventBridgeClient.putEvents(eventsRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String eventId = null;

        for (PutEventsResultEntry resultEntry : putEventsResponse.entries()) {
            if (resultEntry.eventId() != null) {
                System.out.println("Event Id: " + resultEntry.eventId());
                eventId = resultEntry.eventId();
            } else {
                System.out.println("PutEvents failed with Error Code: " + resultEntry.errorCode());
            }
        }

        return eventId;
    }
}
