import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //creating an object of job
    static class job {
        int deadline;
        int profit;
        int id;//0(A) 1(B) 2(C) 3(D)

        //creating constructor of job
        public job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> sequence = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            job curr = jobs.get(i);
            if (curr.deadline > time) {
                sequence.add(curr.id);
                time++;
            }
        }

        //print sequence
        System.out.println("max jobs: " + sequence.size());
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();
    }
}
