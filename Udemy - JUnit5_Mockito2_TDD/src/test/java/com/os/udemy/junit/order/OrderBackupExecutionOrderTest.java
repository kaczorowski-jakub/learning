package com.os.udemy.junit.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException() throws IOException {
        // given
        OrderBackup orderBackup = new OrderBackup();

        // when + then
        Assertions.assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
