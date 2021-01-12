package by.gsu.epamlab.models.factories;

import java.util.stream.Stream;

import static by.gsu.epamlab.constants.ConstantsController.*;
import static by.gsu.epamlab.constants.ConstantsSQL.*;

public class ViewsFactory {
    private enum Views {
        TODAY(POSTFIX_TO_QUERY_TODAY, new String[]{FIX_BUTTON, RECYCLE_BUTTON}),
        TOMORROW(POSTFIX_TO_QUERY_TOMORROW, new String[]{FIX_BUTTON, RECYCLE_BUTTON}),
        SOMEDAY(POSTFIX_TO_QUERY_SOMEDAY, new String[]{FIX_BUTTON, RECYCLE_BUTTON}),
        FIXED(POSTFIX_TO_QUERY_FIXED, new String[]{UNFIX_BUTTON, RECYCLE_BUTTON}),
        RECYCLE(POSTFIX_TO_QUERY_RECYCLE, new String[]{RESTORE_BUTTON, DELETE_BUTTON, DELETE_ALL_BUTTON});

        private final String requestPart;
        private final String[] buttons;

        Views(String requestPart, String[] buttons) {
            this.requestPart = requestPart;
            this.buttons = buttons;
        }

        private String getRequestPart() {
            return requestPart;
        }

        public String[] getButtons() {
            return buttons;
        }
    }

    public static String getReqVersion(String view) {
        Views source = Views.valueOf(view.toUpperCase());
        return source.getRequestPart();
    }

    public static String[] getButtons(String view) {
        Views source = Views.valueOf(view.toUpperCase());
        return source.getButtons();
    }

    public static String[] getViews(){
        return Stream.of(Views.values())
                .map(Views::name)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }
}
