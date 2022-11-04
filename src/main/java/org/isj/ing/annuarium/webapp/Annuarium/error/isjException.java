package org.isj.ing.annuarium.webapp.Annuarium.error;

import org.zalando.problem.Status;

import java.util.Arrays;
import java.util.List;

public class isjException extends  Exception{

    private static final long serialVersionUID = 1L;
    private final Status httpStatus;
    private List<String> messages;


    public isjException(ErrorInfo errorInfo,String... messages) {
        super(errorInfo.getMessage());
        this.httpStatus = errorInfo.getHttpStatus();
        this.messages = Arrays.asList(messages);
    }

    /**
     * @param msg
     * @param httpStatus
     */
    public isjException(String msg, Status httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    /**
     * @param cause
     * @param httpStatus
     */
    public isjException(Throwable cause, Status httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    /**
     * @return the httpStatus
     */
    public Status getHttpStatus() {
        return httpStatus;
    }

}
