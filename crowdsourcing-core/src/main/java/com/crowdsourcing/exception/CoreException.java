package com.crowdsourcing.exception;

public class CoreException extends Exception{
    /**
	 * serialVersionUID of EmsBlogException class
	 */
	private static final long serialVersionUID = -2758297944563834664L;

	/** The code. */
    private int code;
    
    /** The error. */
    private String error;

	public CoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

    /**
     * Instantiates a new blog exception.
     *
     * @param code the code
     * @param message the message
     * @param error the error
     * @param cause the cause
     */
    public CoreException(final int code, final String message,
            final String error, final Throwable cause) {
        super(message, cause);
        this.code = code;
        this.error = error;
    }

    /**
     * Instantiates a new blog exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public CoreException(final String message, final Throwable cause) {
        super(message, cause);
        this.error = message;
    }

    /**
     * Instantiates a new Blog exception.
     *
     * @param message the message
     */
	public CoreException(final String message) {
		super(message);
		this.error = message;
	}

    /**
     * Instantiates a new Blog exception.
     *
     * @param message the message
     * @param code the code
     * @param error the error
     */
	public CoreException(final int code, final String message,
            final String error) {
		super(message);
		this.code = code;
		this.error = error;
	}

	/**
	 * @return the code
	 */
	public synchronized int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public synchronized void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the error
	 */
	public synchronized String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public synchronized void setError(String error) {
		this.error = error;
	}
    
	
    
}
