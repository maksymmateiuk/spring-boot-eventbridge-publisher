package com.mmateiuk.springbooteventbridgepublisher.model.response;

import com.mmateiuk.springbooteventbridgepublisher.model.common.Event;
import java.util.Objects;

public class DemoResponse {

    private String eventId;
    private Event event;

    public static Builder newBuilder() {
        return new Builder();
    }

    public DemoResponse() {
    }

    public DemoResponse(String eventId, Event event) {
        this.eventId = eventId;
        this.event = event;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DemoResponse that = (DemoResponse) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, event);
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "eventId=" + eventId +
                ", event=" + event +
                '}';
    }

    public static final class Builder {

        private String eventId;
        private Event event;

        private Builder() {
        }

        public Builder withId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder withEvent(Event event) {
            this.event = event;
            return this;
        }

        public DemoResponse build() {
            DemoResponse demoResponse = new DemoResponse();
            demoResponse.setEventId(eventId);
            demoResponse.setEvent(event);
            return demoResponse;
        }
    }

}

