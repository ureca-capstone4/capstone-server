package com.ureca.idle.idleapi.idleoriginapi.implementation.util;


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

        mbti.append(ei >= 51 ? "E" : "I");
        mbti.append(sn >= 51 ? "S" : "N");
        mbti.append(tf >= 51 ? "T" : "F");
        mbti.append(jp >= 51 ? "J" : "P");

        return mbti.toString();
    }
}
