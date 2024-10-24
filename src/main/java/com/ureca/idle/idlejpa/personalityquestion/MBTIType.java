package com.ureca.idle.idlejpa.personalityquestion;

import lombok.Getter;

@Getter
public enum MBTIType {
    EI("ei"),
    SN("sn"),
    TF("tf"),
    JP("jp");

    private final String value;

    MBTIType(String value) {
        this.value = value;
    }



}
