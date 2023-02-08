package org.openweathermap.exceptions;

public class AssertionsErrorMessages extends AssertionError {
    private static final long serialVersionUID = 1L;

    public static final String THE_STATUS_CODE_IS_NOT_EXPECTED = "The status code response is not expected";
    public static final String THE_SCHEMA_IS_NOT_EXPECTED = "The schema response is not expected";


    public AssertionsErrorMessages(String message, Throwable cause) { super(message, cause); }

    public AssertionsErrorMessages(String message) { super(message); }
}
