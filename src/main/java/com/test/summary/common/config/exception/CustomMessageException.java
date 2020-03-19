package com.test.summary.common.config.exception;

/**
 * @author DuKaixiang
 * @date 2018/12/14.
 */
public class CustomMessageException extends BaseException {

    private static final long serialVersionUID = 375743064731184647L;

    public CustomMessageException(Integer msgid, String message) {
        super(msgid, message);
    }
    public CustomMessageException(String message) {
        super(message);
    }
    public CustomMessageException() {
        super();
    }
}
