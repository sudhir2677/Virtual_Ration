package com.IBHacakathon.Virtual_Ration.Exception;

public class ApiException extends Throwable {
    public ApiException(String user_not_found) {
        super(user_not_found);
    }
}
