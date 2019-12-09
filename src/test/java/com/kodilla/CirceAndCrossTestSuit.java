package com.kodilla;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;


import java.util.Set;

public class CirceAndCrossTestSuit {

        @Test
        public void testIsEndOfGameForUser() {

        //Given
                GameEngineStub gameEngineStub = new GameEngineStub();
                Set<Integer> userTable;
                userTable = gameEngineStub.getUserTable();

                Set<Integer> computerTable;
                computerTable = gameEngineStub.getComputerTable();

        //When
                gameEngineStub.winningSetContainTable(userTable);
                boolean result = gameEngineStub.isEndOfGameForUser();
        //Than
                Assert.assertTrue( result );

        }
}
