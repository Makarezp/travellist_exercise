package com.believeapps.travelinfo.api.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HotelsCustomDeserializer implements JsonDeserializer<HotelsByChildDestination> {

    @Override
    public HotelsByChildDestination deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        final List<Hotels> hotelsList = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> set = jsonObject.get("Aggregates").getAsJsonObject().get("HotelsByChildDestination").getAsJsonObject().entrySet();

        Iterator<Map.Entry<String, JsonElement>> hotelsSet = set.iterator();

        while (hotelsSet.hasNext()) {
            Map.Entry<String, JsonElement> elementEntry = hotelsSet.next();
            Hotels hotels = context.deserialize(elementEntry.getValue(), Hotels.class);
            String[] imgValues = elementEntry.getKey().split("\\|");
            hotels.setImageType(imgValues[0]);
            hotels.setImageId(imgValues[1]);
            hotelsList.add(hotels);
        }

        return new HotelsByChildDestination(hotelsList);
    }


}
