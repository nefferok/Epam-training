package by.gsu.epamlab.constants;

public class ConstantsListener {
    public static final String CREATED_SESSION = "\nCREATED session:";
    public static final String DESTROYED_SESSION = "\nDESTROYED session:";
    public static final String ACTIVATED_SESSION = "\nACTIVATED session is about to be:";
    public static final String SESSION_PASSIVATED = "\nPASSIVATED session is about to be:";
    public static final String ADDED_SESSION_ATTRIBUTE = "\nADDED Session ATTRIBUTE (HttpSessionAttributeListener):";
    public static final String VALUE_BOUND = "\nADDED Session ATTRIBUTE (HttpSessionBindingListener):";
    public static final String REMOVED_SESSION_ATTRIBUTE = "\nREMOVED Session ATTRIBUTE (HttpSessionAttributeListener):";
    public static final String VALUE_UNBOUND = "\nREMOVED Session ATTRIBUTE (HttpSessionBindingListener):";
    public static final String REPLACED_SESSION_ATTRIBUTE = "\nREPLACED Session ATTRIBUTE (HttpSessionAttributeListener):";
    public static final String DESCRIPTION_SESSION_ATTRIBUTE = "\nThe simple name of the underlying class: %s" +
            "\nFrom session: %s" +
            "\nThe session ID: %s" +
            "\nThe attribute name: %s" +
            "\nThe attribute value: %s\n";
    public static final String ADDED_SERVLET_CONTEXT_ATTRIBUTE = "\nADDED ServletContext ATTRIBUTE:";
    public static final String REMOVED_SERVLET_CONTEXT_ATTRIBUTE = "\nREMOVED ServletContext ATTRIBUTE:";
    public static final String REPLACED_SERVLET_CONTEXT_ATTRIBUTE = "\nREPLACED ServletContext ATTRIBUTE:";
    public static final String DESCRIPTION_SERVLET_CONTEXT_ATTRIBUTE = "\nThe simple name of the underlying class: %s" +
            "\nFrom session: %s" +
            "\nThe attribute name: %s" +
            "\nThe attribute value: %s\n";
    public static final String ADDED_SERVLET_REQUEST_ATTRIBUTE = "\nADDED ServletRequest ATTRIBUTE:";
    public static final String REMOVED_SERVLET_REQUEST_ATTRIBUTE = "\nREMOVED ServletRequest ATTRIBUTE:";
    public static final String REPLACED_SERVLET_REQUEST_ATTRIBUTE = "\nREPLACED ServletRequest ATTRIBUTE:";
    public static final String DESCRIPTION_SERVLET_REQUEST_ATTRIBUTE = "\nThe simple name of the underlying class: %s" +
            "\nFrom session: %s" +
            "\nThe session ID: %s" +
            "\nThe attribute name: %s" +
            "\nThe attribute value: %s\n";
    public static final String DESCRIPTION_INITIALIZED_REQUEST = "\nREQUEST INITIALIZED:" +
            "\nThe simple name of the underlying class: %s" +
            "\nRequest for: %s" +
            "\nURL of the request source: %s" +
            "\nSession ID: %s" +
            "\nIP: %s" +
            "\nMethod: %s" +
            "\nQuery String: %s\n";
    public static final String DESCRIPTION_CREATED_SESSION = "\nThe simple name of the underlying class: %s"+
            "\nNew session created on %s " +
            "\nID: %s " +
            "\nThere are now %d live session in the application\n";
    public static final String DESCRIPTION_DESTROYED_SESSION = "\nThe simple name of the underlying class: %s" +
            "\nValue of destroyed session ID is %s " +
            "\nThere are now %d live session in the application\n";
    public static final String DESCRIPTION_MIGRATING_SESSION = "\nThe simple name of the underlying class: %s" +
            "\nFrom session: %s" +
            "\nThe session ID: %s" +
            "\nSession migrated with data: %s\n";
    public static final int TIME_INTERVAL = 30;
    public static final String HEADER_NAME_REFERER = "referer";
    public static final String REQUEST_WITHOUT_PARAMETERS = "Request Initialized without parameters";
    public static final String REQUEST_WITH_PARAMETERS = "Request Initialized with parameters:";
    public static final String KEY_VALUE_DELIMITER = " = ";
    public static final String CONTEXT_INITIALIZED = "Context Initialized";
    public static final String CONTEXT_DESTROYED = "Context Destroyed";
    public static final String REQUEST_DESTROYED = "\nRequest for %s Destroyed\n";
    public static final String EMPTY_REFERER = "no information about the previous page";
    public static final String DELIMITER_RESOURCE_BUNDLE = " = ";
}
