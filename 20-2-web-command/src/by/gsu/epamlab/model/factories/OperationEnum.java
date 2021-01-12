package by.gsu.epamlab.model.factories;

import static by.gsu.epamlab.model.impl.ConstantsSql.*;

public enum OperationEnum {
    FIX(FIX_TASK),
    REMOVE(REMOVE_TASK),
    DELETE(DELETE_TASK),
    RESTORE(RESTORE_TASK),
    CANCEL(CANCEL_TASK);

    private String requestSQL;

    OperationEnum(String requestSQL) {
        this.requestSQL = requestSQL;
    }

    public String getRequestSQL() {
        return requestSQL;
    }

    public static OperationEnum getOperationEnum(String operation) {
        return valueOf(operation.toUpperCase());
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}