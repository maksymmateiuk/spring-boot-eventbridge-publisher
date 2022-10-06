package com.mmateiuk.springbooteventbridgepublisher.services;

import com.mmateiuk.springbooteventbridgepublisher.model.common.Event;

public interface EventService {

    public String sendEvent(Event event);
}
