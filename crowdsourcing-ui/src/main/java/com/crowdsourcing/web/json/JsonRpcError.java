package com.crowdsourcing.web.json;

/**
 * A JSO-RPC 1.1 Specification error member of the response object as outlined at
 * http://json-rpc.org/wd/JSON-RPC-1-1-WD-20060807.html
 * <pre>
 * Example:
 * {
 *         "name" : "JSONRPCError",
 *         "code" : 123,
 *         "message" : "An error occurred parsing the request object.",
 *         "error" : <some JSON Object>
 * }
 * </pre>
 */
public class JsonRpcError {


    private static final String NAME_JSON_RPC_ERROR = "JSONRPCError";
    private int code;
    private String message;
    private Object error;

    public JsonRpcError () {

    }

    public JsonRpcError (final int code, final String message, final Object error){
        this.code = code;
        this.message = message;
        this.error = error;
    }

    /**
     * REQUIRED.
     * A Number value that indicates the actual error that occurred.
     * This MUST be an integer between 100 and 999.
     * @return A Number value that indicates the actual error that occurred.
     */
    public int getCode() {
        return code;
    }

    /**
     * REQUIRED.
     * A Number value that indicates the actual error that occurred.
     * This MUST be an integer between 100 and 999.
     * @param code A Number value that indicates the actual error that occurred.
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * REQUIRED.
     * A String value that provides a short description of the error.
     * The message SHOULD be limited to a single sentence.
     * @return A String value that provides a short description of the error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * REQUIRED.
     * A String value that provides a short description of the error.
     * The message SHOULD be limited to a single sentence.
     * @param message A String value that provides a short description of the error.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * OPTIONAL.
     * A JSON Null, Number, String or Object value that carries custom and
     * application-specific error information.
     * Error objects MAY be nested using this property.
     * @return error A JSON Null, Number, String or Object value
     */
    public Object getError() {
        return error;
    }

    /**
     * OPTIONAL.
     * A JSON Null, Number, String or Object value that carries custom and
     * application-specific error information.
     * Error objects MAY be nested using this property.
     * @param error A JSON Null, Number, String or Object value
     */
    public void setError(final Object error) {
        this.error = error;
    }

    /**
     * REQUIRED.
     * A String value that MUST read "JSONRPCError".
     * @return "JSONRPCError"
     */
    public String getName() {
        return NAME_JSON_RPC_ERROR;
    }

}
