package solveprojects;
public class Worker implements Comparable<Worker>{
    int salary;
    @Override
    public int compareTo(Worker worker){
     return this.salary-worker.salary;
    }
}
