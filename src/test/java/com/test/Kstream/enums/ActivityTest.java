package com.test.Kstream.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ActivityTest {




    @DisplayName("Test enum mapping")
    @Test
    void testGet() throws Exception {
        assertEquals(Activity.OTHER, Activity.fromString(null));
    }

}