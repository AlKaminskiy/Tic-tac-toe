package com.company;
public class Logic {
    private static int[][] playfield = new int[20][20];
    static int movecounter = 0;
    private static final int i=20;
    private static final int j=20;
    private static int old_i;
    private static int old_j;
    static boolean iswin;

   static void updatefield(){
        for(int i = 0; i< Logic.i; i++){
            for (int j = 0; j< Logic.j; j++){
                playfield[i][j] = 0;
            }
        }
    }
    static boolean DoMove(int i,int j){
        old_i = i;
        old_j = j;
    if (playfield[i][j] == 0){
        if(movecounter%2 == 0){
            playfield[i][j] = 1;//крестик
        }else{
            playfield[i][j] = 2;//нолик
        }
        movecounter++;
        if (movecounter % 2 == 1) {
            iswin = DeathCheck((byte) 1, old_i, old_j);
        } else {
            iswin = DeathCheck((byte) 2, old_i, old_j);
        }

        return true;
    }else return false;
    }
    static boolean DeathCheck(byte tot, int i, int j){
        int count = 0;
        for (int k = -4;k <= 4;k++) {
            try {
                if (playfield[i + k][j] == tot) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }else count = 0;
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
        count = 0;
        for (int k = -4;k <= 4;k++) {
            try {
                if (playfield[i][j+k] == tot) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }else count = 0;
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
        count = 0;
        for (int k = -4;k <= 4;k++) {
            try {
                if (playfield[i + k][j + k] == tot) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }else count = 0;
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
        count = 0;
        for (int k = -4;k <= 4;k++) {
            try {
                if (playfield[i + k][j - k] == tot) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }else count = 0;
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
        return false;
    }
}
