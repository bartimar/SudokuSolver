/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Marek
 */
public class Square {

    private final ArrayList<Coord> coords;
    static Square instance;
    public static final int COUNT = 9;
    public static final int DIM = 3;

    private Square() {
        coords = new ArrayList();
        init();
    }
    
    private void init() {
        coords.add(new Coord(0,0));
        coords.add(new Coord(0,3));
        coords.add(new Coord(0,6));
        coords.add(new Coord(3,0));
        coords.add(new Coord(3,3));
        coords.add(new Coord(3,6));
        coords.add(new Coord(6,0));
        coords.add(new Coord(6,3));
        coords.add(new Coord(6,6));
    }
    
    public int getBeginX(int sqId) {
        return coords.get(sqId).getX();
    } 
    public int getBeginY(int sqId) {
        return coords.get(sqId).getY();
    }
    public int getEndX(int sqId) {
        return getBeginX(sqId)+DIM;
    } 
    public int getEndY(int sqId) {
        return getBeginY(sqId)+DIM;
    }

    public static Square getInstance() {
        if (instance == null) {
            instance = new Square();
        }
        return instance;
    }

    
}
