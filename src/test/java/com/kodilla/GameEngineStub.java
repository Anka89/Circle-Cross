package com.kodilla;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameEngineStub {

    private static final Set<Integer> userTable = new HashSet<>();
    private Set<Integer> computerTable = new HashSet<>( );

    public Set<Integer>getUserTable(){
        userTable.add(1);
        userTable.add(2);
        userTable.add(3);
        userTable.add(4);
            return userTable;
}

    public Set<Integer>getComputerTable(){
        computerTable.add(6);
            return userTable;
    }

    private static final Set<Set<Integer>> winningCombinations = new HashSet<Set<Integer>>( Arrays.asList(
            new HashSet<Integer>( Arrays.asList( 0, 1, 2 ) ),
            new HashSet<Integer>( Arrays.asList( 3, 4, 5 ) ),
            new HashSet<Integer>( Arrays.asList( 6, 7, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 0, 3, 6 ) ),
            new HashSet<Integer>( Arrays.asList( 1, 4, 7 ) ),
            new HashSet<Integer>( Arrays.asList( 2, 5, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 0, 4, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 2, 4, 6 ) )));


    boolean winningSetContainTable(Set<Integer> table) {
        for (Set winningSet: winningCombinations) {
            HashSet hashSet = new HashSet<>( winningSet );
            hashSet.removeAll( table );
            if(hashSet.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isEndOfGameForUser() {
        if (userTable.size() < 3) {
            return false;
        } else if (winningSetContainTable( userTable )) {
            System.out.println( "You won !!! " );
            return true;
        } else if (fullBoard()) {
            System.out.println( "Draw" );
            return true;
        }
        return false;
    }
    private boolean fullBoard() {
        return userTable.size() + computerTable.size() == 9;
    }
}
