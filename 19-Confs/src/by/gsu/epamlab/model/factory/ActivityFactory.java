package by.gsu.epamlab.model.factory;

import by.gsu.epamlab.ifaces.ActivityDAO;
import by.gsu.epamlab.model.impl.ActivityImplCsv;
import by.gsu.epamlab.model.impl.ActivityImplDb;

import javax.servlet.ServletConfig;
import java.util.ResourceBundle;
import java.util.function.BiFunction;

public class ActivityFactory {
    private enum ActivitySource {
        CSV (ActivityImplCsv::new),
        DB (ActivityImplDb::new);

        private final BiFunction<ResourceBundle, ServletConfig, ActivityDAO> function;

        ActivitySource(BiFunction<ResourceBundle, ServletConfig, ActivityDAO> function) {
            this.function = function;
        }

        public ActivityDAO getActiImpl(ResourceBundle rb, ServletConfig sc){
            return function.apply(rb, sc);
        }
    }

    private static ActivityDAO activImpl;

    public static void init(ResourceBundle rb, ServletConfig sc){
        String version = rb.getString("factory.activity");
        ActivitySource as = ActivitySource.valueOf(version.toUpperCase());
        activImpl = as.getActiImpl(rb, sc);
    }

    public static ActivityDAO getClassFromFactory(){
        return activImpl;
    }

}
