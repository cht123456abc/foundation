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

        for (int i = 0; i+1 < intervals.size(); i++) {

            Interval a = intervals.get(i);
            Interval b = intervals.get(i+1);
            if (a.end >= b.start) {
                intervals.set(i + 1, new Interval(a.start, Math.max(a.end,b.end)));
            } else {
                res.add(a);
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



