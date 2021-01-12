package by.gsu.epamlab.models.factories;

import static by.gsu.epamlab.constants.ConstantsSQL.*;

public class OperationFactory {
    private enum Requests{
        FIX(FIX_TASK_QUERY),
        RECYCLE(RECYCLE_TASK_QUERY),
        UNFIX(UNFIX_TASK_QUERY),
        RESTORE(RESTORE_TASK_QUERY),
        DELETE(DELETE_TASK_QUERY),
        DELETE_ALL(DELETE_ALL_TASKS_QUERY);

        private final String request;

        Requests(String request){
            this.request = request;
        }

        private String getRequest(){
            return request;
        }
    }

    public static String getOperationRequest(String operation){
        Requests req = Requests.valueOf(operation.toUpperCase());
        return req.getRequest();
    }
}
