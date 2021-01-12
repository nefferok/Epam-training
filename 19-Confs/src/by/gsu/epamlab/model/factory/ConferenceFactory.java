package by.gsu.epamlab.model.factory;

import by.gsu.epamlab.ifaces.ConferenceDAO;
import by.gsu.epamlab.model.impl.ConferenceImplDb;
import by.gsu.epamlab.model.impl.ConferenceImplMemory;

import java.util.ResourceBundle;
import java.util.function.Function;

public class ConferenceFactory {

    private enum ConferencesSources{
        MEMORY (ConferenceImplMemory::new),
        DB (ConferenceImplDb::new);

        private final Function<ResourceBundle, ConferenceDAO> function;

        ConferencesSources(Function<ResourceBundle, ConferenceDAO> function){
            this.function = function;
        }

        public ConferenceDAO getConfImpl(ResourceBundle rb){
            return function.apply(rb);
        }
    }

    private static ConferenceDAO confImpl;

    public static void init(ResourceBundle rb){
        String version = rb.getString("factory.conf");
        ConferencesSources cs = ConferencesSources.valueOf(version.toUpperCase());
        confImpl = cs.getConfImpl(rb);
    }

    public static ConferenceDAO getClassFromFactory(){
        return confImpl;
    }

}
