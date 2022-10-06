package com.mmateiuk.springbooteventbridgepublisher.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Event<T> {

    @JsonProperty("source")
    private String source;

    @JsonProperty("eventBus")
    private String eventBus;

    private T detail;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEventBus() {
        return eventBus;
    }

    public void setEventBus(String eventBus) {
        this.eventBus = eventBus;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event<?> event = (Event<?>) o;
        return Objects.equals(source, event.source) && Objects.equals(eventBus, event.eventBus)
                && Objects.equals(detail, event.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, eventBus, detail);
    }

    @Override
    public String toString() {
        return "Event{" +
                "source='" + source + '\'' +
                ", eventBus='" + eventBus + '\'' +
                ", detail=" + detail +
                '}';
    }
}
