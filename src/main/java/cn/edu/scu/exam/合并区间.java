package cn.edu.scu.exam;

import java.util.ArrayList;
import java.util.Comparator;

public class 合并区间 {


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        ArrayList<Interval> res = new ArrayList<>();
        if(intervals.isEmpty()) return res;

        int left = intervals.get(0).start;
        int right = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval a = intervals.get(i);
            if (right >= a.start) {
                right = Math.max(right, a.end);
            } else {
                res.add(new Interval(left, right));
                left = a.start;
                right = a.end;
            }
        }
        res.add(intervals.get(intervals.size()-1));
        return res;

    }


    public static void main(String[] args) {


    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}



