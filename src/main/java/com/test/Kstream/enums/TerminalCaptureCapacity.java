package com.test.Kstream.enums;

public enum TerminalCaptureCapacity  {
    ICC,
    MAGNETIC_STRIPE,
    OTHER;

    public static TerminalCaptureCapacity fromString(String au) throws Exception{
        for (TerminalCaptureCapacity terminalCaptureCapacity : TerminalCaptureCapacity.values()) {
            if (terminalCaptureCapacity.toString().equals(au.toUpperCase())) {
                return terminalCaptureCapacity;
            }


        }

        return OTHER;

    }

}
