package com.kodilla;

import java.util.*;

public class GameEngine {

    private static final Set<Set<Integer>> winningCombinations = new HashSet<Set<Integer>>(Arrays.asList(
            new HashSet<Integer>( Arrays.asList( 0, 1, 2 ) ),
            new HashSet<Integer>( Arrays.asList( 3, 4, 5 ) ),
            new HashSet<Integer>( Arrays.asList( 6, 7, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 0, 3, 6 ) ),
            new HashSet<Integer>( Arrays.asList( 1, 4, 7 ) ),
            new HashSet<Integer>( Arrays.asList( 2, 5, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 0, 4, 8 ) ),
            new HashSet<Integer>( Arrays.asList( 2, 4, 6 ) )));

    private boolean isHard = false;
    private Set<Integer> userTable = new HashSet<>();
    private Set<Integer> computerTable = new HashSet<>();


    public void getUserMove(int buttonNumber) {
        userTable.add( buttonNumber );
    }

    public void setLevel(boolean isHard) {
        this.isHard = isHard;
    }

    public int getComputerMoveO() {
        if (isHard) {
            return getComputerMoveHardLeveL();
        } else {
            return getComputerMoveLowLevel();
        }
    }

    public int getComputerMoveHardLeveL() {
        if (computerTable.isEmpty()) {
            return getComputerMoveLowLevel();
        }
        for (Set<Integer> winningSet : winningCombinations) {
            if (containsComputerFields(winningSet) && notContainsUserFields( winningSet )) {
                for (Integer i : winningSet) {
                    System.out.println("Checking " + i);
                    if (computerTable.contains( i )) {
                        continue;
                    } else {
                        computerTable.add(i);
                        return i;
                    }
                }
            }
        }
        return getComputerMoveLowLevel();
    }

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

    private boolean containsComputerFields(Set winningSet) {
        for (Integer i : computerTable) {
            if (winningSet.contains( i )) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean notContainsUserFields(Set winningSet) {
        for (Integer i : userTable) {
            if (winningSet.contains( i )) {
                return false;
            }
        }
        return true;
    }

    public int getComputerMoveLowLevel() {
        List<Integer> availableFields = new ArrayList<>(  );
        for (int i=0; i<9; i++) {
            if(!userTable.contains( i ) && !computerTable.contains( i )) {
                availableFields.add( i );
            }
        }
        int item = new Random().nextInt( availableFields.size() );
        computerTable.add( availableFields.get( item ) );
        return availableFields.get( item );
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

    public boolean isEndOfGameForComputer() {
        if (computerTable.size() < 3) {
            return false;
        } else if (winningSetContainTable( computerTable)) {
            System.out.println( "Computer won !!! " );
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

    void clearTables() {
        userTable.clear();
        computerTable.clear();
    }

    public void addToUserTable(Integer integer) {
        userTable.add(integer);
    }

    public void addToComputerTable(Integer integer) {
        computerTable.add(integer);
    }

    public Set<Integer> getUserTable() {
        return userTable;
    }

    public Set<Integer> getComputerTable() {
        return computerTable;
    }
}


