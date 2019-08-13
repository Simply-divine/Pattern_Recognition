package PatternRecognition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FastCollinearPoints {
    List<LineSegment> listoflineSegments = new ArrayList<>();
    private int counter = 0;
    Point aux[];

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        Point[] aux=Arrays.copyOf(points,points.length);
        Arrays.sort(aux);
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(aux, points[i].slopeOrder());
            int min=0;
            while(min<points.length&&points[i]==points[min])min++;
            if(min!=1)throw new IllegalArgumentException();
            int max=min+3;
            while(max<points.length&&points[i].slopeTo(points[min])==points[i].slopeTo(points[max]))max++;
            for (int j = 1; j < points.length - 3; j++) {
                if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[j + 1]) &&
                        points[i].slopeTo(points[j]) == points[i].slopeTo(points[j + 2])) {
                    listoflineSegments.add(new LineSegment(points[i], points[j + 2]));
                    counter++;

                    }
            }

        }
    }     // finds all line segments containing 4 or more points

    public int numberOfSegments() {
        return counter;
    }        // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] listofsegments = new LineSegment[listoflineSegments.size()];
        listoflineSegments.toArray(listofsegments);
        return listofsegments;
    }                // the line segments
}
