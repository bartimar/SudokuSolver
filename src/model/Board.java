/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marek
 */
public class Board {

    ArrayList<ArrayList<Cell>> cells;

    public Board() {
        cells = new ArrayList();
        for (int i = 0; i < BOARD_SIZE; i++) {
            cells.add(new ArrayList());
        }
        initBoard();
        generateBoard();
    }

    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells.get(i).add(new Cell());
            }
        }
    }

    private void generateBoard() {
        Random rand = new Random();
        int cnt = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                cells.get(i).get(j).setValue(rand.nextInt(9) + 1);
                    int val = 1;
                while (!check()) {
                    //int val = rand.nextInt(9) + 1;
                    //System.out.println("Trying to use val=" + val);
                    cells.get(i).get(j).setValue(val);
                    val = (val +1)%9 + 1;
                }
                System.out.println("Cnt=" + cnt++);
                System.out.println(toString());
            }
        }
        //check();
    }

    public boolean check() {
        if (!rowCheck() || !columnCheck() || !squareCheck()) {
            // System.out.println("Fail check");
            //System.out.println(toString());
            return false;
        }
        return true;
    }

    private boolean squareCheck() {
       ArrayList<Integer> cont = new ArrayList();
       Square square = Square.getInstance();

        for (int sq = 0; sq < Square.COUNT; sq++) {
            cont.clear();
            for (int i = square.getBeginX(sq); i < square.getEndX(sq); i++) {
                for (int j = square.getBeginY(sq); j < square.getEndY(sq); j++) {
                    int val = cells.get(j).get(i).getValue();
                    if (cont.contains(val)) {
                        //System.out.println("Fail at rowCheck: " + j + "," + i + " val=" + val);
                        return false;
                    }
                    if (val != 0) {
                        cont.add(val);
                    }
                }
            }
        }
        return true; 
    }
    private boolean rowCheck() {
        ArrayList<Integer> cont = new ArrayList();

        for (int i = 0; i < cells.size(); i++) {
            cont.clear();
            for (int j = 0; j < cells.size(); j++) {
                int val = cells.get(j).get(i).getValue();
                if (cont.contains(val)) {
                    //System.out.println("Fail at rowCheck: " + j + "," + i + " val=" + val);
                    return false;
                }
                if (val != 0) {
                    cont.add(val);
                }
            }
        }
        return true;
    }

    private boolean columnCheck() {
        ArrayList<Integer> cont = new ArrayList();

        for (int i = 0; i < cells.size(); i++) {
            cont.clear();
            for (int j = 0; j < cells.get(i).size(); j++) {
                int val = cells.get(i).get(j).getValue();
                if (cont.contains(val)) {
                    //System.out.println("Fail at columnCheck: " + i + "," + j + " val=" + val);
                    return false;
                }
                if (val != 0) {
                    cont.add(val);
                }
            }
        }
        return true;
    }

    public static final int BOARD_SIZE = 9;

    @Override
    public String toString() {
        String res;
        res = "Board{\n" + "   cells=\n    ";

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                res += cells.get(i).get(j).toString() + " ";
            }
            res += "\n    ";
        }

        res += "\n}";
        return res;
    }

}
