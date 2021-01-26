package Lessons7;

public class Robot implements JumpRun {
    protected String name;
    protected float maxJump;
    protected int maxRun;
    protected boolean done = false;

    public Robot(String name, float maxJump, int maxRun, boolean done) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.done = done;
    }

    // проверка на переопределение метода
//    @Override
//    public void run(){
//        System.out.println(name + " Этот робот любит бегать");
//    }
    @Override
    public void run(int length){
        System.out.println("Робот " +name + " любит бегать и может пробежать не более " + length+ " метров");
    }

    // проверка на переопределение метода
//    @Override
//    public void jump(){
//        System.out.println(name + " Этот робот любит прыгать");
//    }
    @Override
    public void jump(float length){
        System.out.println("Робот " +name + " любит прыгат и может подпрыгнуть на высоту не более " + length+ " метров");
    }

    @Override
    public boolean runDo(int lengthRunDo){
        if  (lengthRunDo <= maxRun) {
            this.done= true;
            return true;
        }
        else return false;
    }

    @Override
    public boolean jumpDo(float heightJumpDo){
        if  (heightJumpDo <= maxJump) {
            this.done= true;
            return true;
        }
        else return false;
    }

//    public void runDo(RunTrack runTrack){
//        if  (runTrack.length >=maxrun) this.done= true;
//    }
//
//    public void jumpDo(Wall wall){
//        if  (wall.height >=maxJump) this.done= true;
//    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maxJump=" + maxJump +
                ", maxrun=" + maxRun +
                ", done=" + done +
                '}';
    }
}
