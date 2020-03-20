package com.test.Kstream.enums;

public enum ClientPresence {
    CLIENT_PRESENT(1),
    CLIENT_NOT_PRESENT(0),
    OTHER;

    ClientPresence(int description) {
    }

    ClientPresence() {

    }

    public static ClientPresence fromString(String au) throws Exception{
        for (ClientPresence clientPresence : ClientPresence.values()) {
            if (clientPresence.toString().equals(au.toUpperCase())) {
                return clientPresence;
            }


        }

        return OTHER;

    }
}
