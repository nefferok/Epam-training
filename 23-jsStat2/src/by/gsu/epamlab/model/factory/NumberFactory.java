package by.gsu.epamlab.model.factory;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.model.interfaces.NumberDAO;
import by.gsu.epamlab.model.implementation.NumberImplCsv;
import by.gsu.epamlab.model.implementation.NumberImplDb;
import by.gsu.epamlab.model.implementation.NumberImplMemory;

import javax.servlet.ServletConfig;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NumberFactory {
    private enum Sources {
        MEMORY (NumberImplMemory::new),
        CSV (NumberImplCsv::new),
        DB (NumberImplDb::new);

        private final Function<String, NumberDAO> function;

        Sources(Function<String, NumberDAO> function) {
            this.function = function;
        }

        public NumberDAO getImpl(String params) {
            return function.apply(params);
        }
    }

    private static NumberDAO numberImpl;

    public static void init(String param){
        final int PARAM_COUNT = 2;
        final int TYPE_ID = 0;
        final int PARAM_ID = 1;

        String [] params = param.split(ConstantsJSP.SPLITTER, PARAM_COUNT);
        String sourceType = params[TYPE_ID];
        String sourceParam = params.length > 1 ? params[PARAM_ID] :"";
        Sources sources = Sources.valueOf(sourceType.toUpperCase());
        numberImpl = sources.getImpl(sourceParam);
    }

    public static NumberDAO getClassFromFactory(){
        return numberImpl;
    }
}
