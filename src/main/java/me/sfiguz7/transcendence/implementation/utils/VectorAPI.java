package me.sfiguz7.transcendence.implementation.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;


public class VectorAPI {

    public static Vector getVector(Location a, Location b) {
        Double ax = a.getX();
        Double ay = a.getY();
        Double az = a.getZ();
        Double bx = b.getX();
        Double by = b.getY();
        Double bz = b.getZ();
        return new Vector(bx - ax, by - ay, bz - az);
    }
}
