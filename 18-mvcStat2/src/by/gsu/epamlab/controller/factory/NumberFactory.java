package by.gsu.epamlab.controller.factory;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.controller.interfaces.NumberDAO;
import by.gsu.epamlab.controller.implementation.NumberImplCsv;
import by.gsu.epamlab.controller.implementation.NumberImplDb;
import by.gsu.epamlab.controller.implementation.NumberImplMemory;

import javax.servlet.ServletConfig;
import java.util.function.BiFunction;

public class NumberFactory {
    private enum Sources {
        MEMORY (NumberImplMemory::new),
        CSV (NumberImplCsv::new),
        DB (NumberImplDb::new);

        private final BiFunction<String, ServletConfig, NumberDAO> function;

        Sources(BiFunction<String, ServletConfig, NumberDAO> function) {
            this.function = function;
        }

        public NumberDAO getImpl(String params, ServletConfig sc) {
            return function.apply(params, sc);
        }
    }

    private static NumberDAO numberImpl;

    public static void init(ServletConfig sc){
        final int PARAM_COUNT = 2;
        final int TYPE_ID = 0;
        final int PARAM_ID = 1;

        String param = sc.getInitParameter(ConstantsJSP.CONTROLLER_FACTORY);
        String [] params = param.split(ConstantsJSP.SPLITTER, PARAM_COUNT);
        String sourceType = params[TYPE_ID];
        String sourceParam = params.length > 1 ? params[PARAM_ID] :"";
        Sources sources = Sources.valueOf(sourceType.toUpperCase());
        numberImpl = sources.getImpl(sourceParam, sc);
    }

    public static NumberDAO getClassFromFactory(){
        return numberImpl;
    }
}
