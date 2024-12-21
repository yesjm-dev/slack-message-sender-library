package com.yesjm.slackmessagesender;

import java.util.ArrayList;
import java.util.List;

public class SlackPayloadBuilder {
    private final List<SlackSectionComponent> components = new ArrayList<>();

    public SlackPayloadBuilder addComponent(SlackSectionComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
        components.add(component);
        return this;
    }

    public String build() {
        if (components.isEmpty()) {
            throw new IllegalStateException("Payload must contain at least one component");
        }

        StringBuilder payload = new StringBuilder("{\"blocks\":[");
        for (int i = 0; i < components.size(); i++) {
            payload.append(components.get(i).build());
            if (i < components.size() - 1) {
                payload.append(",");
            }
        }
        payload.append("]}");
        return payload.toString();
    }
}
