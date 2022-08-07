package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
         if (start.getX() == end.getX() && start.getY() == end.getY())
            throw new RuntimeException();
        if (start == null || end == null)
            throw new RuntimeException();
            
        this.start = start;
        this.end = end;
    }

    double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2)
                + Math.pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
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

        double high = (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4);
        double low = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        double t = high / low;

        // if (t >= 0 || t <= 1)
        //     return null;

        // return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));

        if ((high>= 0 && high <= 1) && (low >= 0 && low <= 1)) {
            return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        }
        else
            return null;
    }

}
