package com.sdp.demo;

import java.net.UnknownHostException;

public class CustomServerException extends RuntimeException {

    public CustomServerException(String msg, UnknownHostException e) {
        super(msg, e);
    }
}
