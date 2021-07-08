package com.example.techtile.Resources;
import com.example.techtile.Model.Event;
import com.example.techtile.R;

public class Events {
    public static Event[] getEvents(){
        return EVENTS;
    }

    public static final Event EVENT_GRAND_OPENING = new Event("Grand Opening", R.drawable.event_img,
            "Main Stage - Ushuaia", 5.0, 14, 2, true);

    public static final Event EVENT_GRAND_OPENING2 = new Event("Grand Opening", R.drawable.event_img,
            "Main Stage - Copenhagen", 5.0, 22, 5, true);

    public static final Event EVENT_GRAND_OPENING3 = new Event("Grand Opening", R.drawable.event_img,
            "Main Stage - New York", 5.0, 18, 4, true);

    public static final Event[] EVENTS = {EVENT_GRAND_OPENING, EVENT_GRAND_OPENING2, EVENT_GRAND_OPENING3};
}
