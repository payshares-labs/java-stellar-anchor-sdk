package org.stellar.anchor.exception;

public class SepException extends AnchorException {
    public SepException(String message, Exception cause) {
        super(message, cause);
    }

    public SepException(String message) {
        super(message);
    }

    public SepException(int httpStatus, String message) {
        super(httpStatus, message);
    }
}
