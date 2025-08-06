/*
 A cafeteria table consists of a row of N  seats, numbered from 1 1 to N from left to right. 
 Social distancing guidelines require that every diner be seated such that K seats to their left and K 
 seats to their right (or all the remaining seats to that side if there are fewer than K ) remain empty.
 There are currently M diners seated at the table, the iith of whom is in seat Si. 
 No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners,
 assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long N = 15;
        long K = 2;
        int M = 3;
        long[] S = {11, 6, 14};
        Arrays.sort(S);
        long result = getMaxAdditionalDinersCount(N, K, M, S);

        System.out.println("\nAvailable seats: " + result);
    }

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        char[] seats = new char[(int)N + 2];
        Arrays.fill(seats, '.');

        for (long seat : S) {
            if (seat >= 1 && seat <= N) {
                seats[(int)seat] = 'X';
            }
        }

        long count = 0;
        for (long seat = 1; seat <= N; seat++) {
            if (seats[(int)seat] == '.' // not already occupied
                    && !checkPreviousPosition(seat, seats, K, N)
                    && !checkNextPosition(seat, seats, K, N)) {

                count++;
                seats[(int)seat] = 'X';
            }
        }

        System.out.print("Diners: ");
        for (long i = 1; i <= N; i++) {
            if (seats[(int)i] == 'X') {
                System.out.print("[" + i + "]");
            } else {
                System.out.print(i);
            }
            if (i < N) System.out.print(" ");
        }
        System.out.println();

        System.out.println("Legend: [n] = occupied, n = empty");

        return count;
    }

    public static boolean checkPreviousPosition(long position, char[] seats, long K, long N) {
        long start = Math.max(1, position - K);
        for (long i = start; i < position; i++) {
            if (seats[(int)i] == 'X') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNextPosition(long position, char[] seats, long K, long N) {
        long end = Math.min(N, position + K);
        for (long i = position + 1; i <= end; i++) {
            if (seats[(int)i] == 'X') {
                return true;
            }
        }
        return false;
    }
}
