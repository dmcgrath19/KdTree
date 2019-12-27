/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deliamcgrath
 */
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class PointSET {

    private final SET<Point2D> points;

    public PointSET() {
        points = new SET<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        points.add(p);
    }

    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        Stack<Point2D> stack = new Stack<>();
        for (Point2D point : points) {
            if (rect.contains(point)) {
                stack.push(point);
            }
        }
        return stack;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }

        Point2D result = null;
        double minDistance = Double.POSITIVE_INFINITY;

        for (Point2D point : points) {
            double distance = p.distanceSquaredTo(point);
            if (distance < minDistance) {
                minDistance = distance;
                result = point;
            }

        }
        return result;
    }

    public void draw() {
        for (Point2D point : points) {
            point.draw();
        }
    }
}
