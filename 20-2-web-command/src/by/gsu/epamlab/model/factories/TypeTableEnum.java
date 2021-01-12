package by.gsu.epamlab.model.factories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static by.gsu.epamlab.model.factories.OperationEnum.*;
import static by.gsu.epamlab.model.impl.ConstantsSql.*;

public enum TypeTableEnum {
    TODAY(SELECT_TASK_TODAY, new OperationEnum[]{FIX, REMOVE}),
    TOMORROW(SELECT_TASK_TOMORROW, new OperationEnum[]{FIX, REMOVE}),
    SOMEDAY(SELECT_TASK_SOMEDAY, new OperationEnum[]{FIX, REMOVE}),
    FIXED(SELECT_TASK_FIXED, new OperationEnum[]{REMOVE, CANCEL}),
    RECYCLE(SELECT_TASK_DEL, new OperationEnum[]{DELETE, RESTORE});

    private String requestSQL;
    private OperationEnum[] buttons;

    TypeTableEnum(String requestSQL, OperationEnum[] buttons) {
        this.requestSQL = requestSQL;
        this.buttons = buttons;
    }

    public String getRequestSQL() {
        return requestSQL;
    }


    public List<String> getButtons() {
        return Arrays.stream(buttons)
                .map(OperationEnum::toString)
                .collect(Collectors.toList());
    }

    public List<String> getNamesTable() {
        return Arrays.stream(TypeTableEnum.values())
                .filter(table -> table != this)
                .map(TypeTableEnum::toString)
                .collect(Collectors.toList());
    }

    public static TypeTableEnum getTypeTable(String table){
        return valueOf(table.toUpperCase());
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}