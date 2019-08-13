package PatternRecognition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private List<LineSegment> listofLineSegments=new ArrayList<>();
    private int counter=0;
    public BruteCollinearPoints(Point[] points){
        if(points==null)throw new NullPointerException();
        Arrays.sort(points);
        for (int i = 1; i <points.length ; i++) {
            if(points[i]==null)throw new IllegalArgumentException();
            if(points[i]==points[i-1]){
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i <points.length ; i++) {
            for (int j = i+1; j <points.length; j++) {
                for (int k = j+1; k <points.length ; k++) {
                    for (int l = k+1; l <points.length ; l++) {
                       Double a= points[i].slopeTo(points[j]);
                        //System.out.println("a= "+a);
                       Double b= points[i].slopeTo(points[k]);
                        //System.out.println("b= "+b);
                        //System.out.println("a==b -> "+(a==b));
                       Double c= points[i].slopeTo(points[l]);
                       // System.out.println("c= "+c);
                       // System.out.println("a==c -> "+(a==c));
                       if((double)(a)==(double)(b)&&(double)a==(double)c){
                           //System.out.println("condition true");
                           listofLineSegments.add(new LineSegment(points[i],points[l]));
                       }
                    }
                }
            }
        }
    }
    public int numberOfSegments(){
        return counter;
    }        // the number of line segments
    public LineSegment[] segments() {
        LineSegment listofsegments[]=new LineSegment[listofLineSegments.size()];
        listofLineSegments.toArray(listofsegments);
        return listofsegments;
    }               // the line segments
}
