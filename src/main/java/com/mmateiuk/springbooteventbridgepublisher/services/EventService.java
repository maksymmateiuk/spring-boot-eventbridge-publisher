package com.mmateiuk.springbooteventbridgepublisher.services;

import com.mmateiuk.springbooteventbridgepublisher.model.common.Event;

public interface EventService {

    String sendEvent(Event event);
}
