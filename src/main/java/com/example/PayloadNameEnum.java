package com.example;

public enum PayloadNameEnum {

    configRequest(Constant.CONFIG_REQUEST_VALUE)

    ;

    PayloadNameEnum(final String value) {
        if(!value.equals(this.name()))
            throw new RuntimeException("Invalid payload type! " + this.name() + " mapped to " + value);
    }

    public static class Constant {
        public static final String CONFIG_REQUEST_VALUE = "configRequest";
    }
}
