package com.codebyte;

import java.util.HashSet;
import java.util.Set;

public class ArraySeatingDesk {

    public static int SeatingStudents(int[] arr) {
        final int sumOfDesks = arr[0];
        final Set<Integer> occupiedDesks = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            occupiedDesks.add(arr[i]);
        }

        System.out.println("sumOfDesks: " + sumOfDesks);
        System.out.println("occupiedDesks: " + occupiedDesks);

        int count = 0;
        for (int currentDesk = 1; currentDesk < sumOfDesks; currentDesk++) {
            if (isOccupied(currentDesk, occupiedDesks, sumOfDesks)) {
                continue;
            }
            if (currentDesk % 2 != 0) {
                final int sideDesk = currentDesk + 1;
                if (!isOccupied(sideDesk, occupiedDesks, sumOfDesks)) {
                    count++;
                }
            }
            final int belowDesk = currentDesk + 2;
            if (!isOccupied(belowDesk, occupiedDesks, sumOfDesks)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isOccupied(final int desk, final Set<Integer> occupiedDesks, final int totalDesks) {
        return desk > totalDesks || occupiedDesks.contains(desk);

    }

}

