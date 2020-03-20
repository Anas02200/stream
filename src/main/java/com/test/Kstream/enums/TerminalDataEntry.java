package com.test.Kstream.enums;

public enum TerminalDataEntry {
    ICC,
    CCV,
    OTHER;
    public static TerminalDataEntry fromString(String au) throws Exception {
        for (TerminalDataEntry terminalCaptureCapacity : TerminalDataEntry.values()) {
            if (terminalCaptureCapacity.toString().equals(au.toUpperCase())) {
                return terminalCaptureCapacity;
            }


        }

        return OTHER;

    }
}


