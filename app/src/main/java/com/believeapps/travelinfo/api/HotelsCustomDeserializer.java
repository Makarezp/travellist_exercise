package com.believeapps.travelinfo.api;

import com.believeapps.travelinfo.api.wrappers.HotelsByChildDestination;
import com.believeapps.travelinfo.model.DestinationHotels;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HotelsCustomDeserializer implements JsonDeserializer<HotelsByChildDestination> {

    @Override
    public HotelsByChildDestination deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        final List<DestinationHotels> hotelsList = new ArrayList<>();


        Set<Map.Entry<String, JsonElement>> set = jsonObject.get("Aggregates").getAsJsonObject().get("HotelsByChildDestination").getAsJsonObject().entrySet();

        Iterator<Map.Entry<String, JsonElement>> destinatnionHotelsIterator = set.iterator();

        while (destinatnionHotelsIterator.hasNext()) {
            Map.Entry<String, JsonElement> elementEntry = destinatnionHotelsIterator.next();
            DestinationHotels destinationHotels = context.deserialize(elementEntry.getValue(), DestinationHotels.class);
            String[] imgValues = elementEntry.getKey().split("\\|");
            destinationHotels.setImageType(imgValues[0]);
            destinationHotels.setImageId(imgValues[1]);
            hotelsList.add(destinationHotels);
        }

        return new HotelsByChildDestination(hotelsList);
    }


}
