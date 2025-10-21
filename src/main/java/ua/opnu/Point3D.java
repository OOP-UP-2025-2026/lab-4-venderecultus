package ua.opnu;

import java.awt.*;

public class Point3D extends Point {

    // Координата Z
    int z;

    // Конструктор без параметрів
    public Point3D() {
        super();
        this.z = 0;
    }

    // Конструктор з координатами
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    // Задає нові координати (z = 0)
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    // Задає координати X, Y, Z
    public void setLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Відстань до іншої точки
    public double distance(Point3D p) {
        int dx = (p.x - this.x) * (p.x - this.x);
        int dy = (p.y - this.y) * (p.y - this.y);
        int dz = (p.z - this.z) * (p.z - this.z);
        return Math.sqrt(dx + dy + dz);
    }

    // Текстове представлення точки
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    // Відстань від початку координат
    public double distanceFromOrigin() {
        int dx = this.x * this.x;
        int dy = this.y * this.y;
        int dz = this.z * this.z;
        return Math.sqrt(dx + dy + dz);
    }

}
