package com.ureca.idle.originapi.implementation.util;


import org.springframework.stereotype.Component;


@Component
public class MBTIUtil {

    public MBTI generateRandomMBTI() {
        int ei = (int)(Math.random() * 100) + 1;
        int sn = (int)(Math.random() * 100) + 1;
        int tf = (int)(Math.random() * 100) + 1;
        int jp = (int)(Math.random() * 100) + 1;
        String mbti = getMBTIByElement(ei, sn, tf, jp);
        return new MBTI(ei, sn, tf, jp, mbti);
    }

    public String getMBTIByElement(int ei, int sn, int tf, int jp) {
        StringBuilder mbti = new StringBuilder();

        if (ei >= 51) mbti.append("E");
        else mbti.append("I");

        if (sn >= 51) mbti.append("S");
        else mbti.append("N");

        if (tf >= 51) mbti.append("T");
        else mbti.append("F");

        if (jp >= 51) mbti.append("J");
        else mbti.append("P");

        return mbti.toString();
    }
}
