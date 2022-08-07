package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point start;
    private Point end;

   
    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (length() == 0) {
            throw new IllegalArgumentException("Segment is degenerative, " +
                    "which means that start and the  end of the segment is not the same point.");
        }
    }

    double length() {
        return sqrt(
                pow(end.getX() - start.getX(), 2) +
                pow(end.getY() - start.getY(), 2)
        );
    }

    Point middle() {
        return new Point(
                (start.getX() + end.getX())/2,
                (start.getY() + end.getY())/2
        );
    }

    Point intersection(Segment another) {
        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();
        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        double t = ((x1 - x3)*(y3 - y4) - (y1 - y3)*(x3 - x4)) / denominator;
        double u = ((x1 - x3)*(y1 - y2) - (y1 - y3)*(x1 - x2)) / denominator;
        if (0 > t || t > 1 || 0 > u || u > 1) {
            return null;
        }
        Point intersection = new Point(
                x1 + t * (x2 - x1),
                y1 + t * (y2 - y1));
        if (Double.valueOf(intersection.getX()).isNaN() &&
            Double.valueOf(intersection.getY()).isNaN()) {
            return null;
        }
        return intersection;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

}
