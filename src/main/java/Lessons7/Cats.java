package Lessons7;

public class Cats implements JumpRun {
    protected String name;
    protected float maxJump;
    protected int maxRun;
    protected boolean done = false;

    public Cats(String name, int maxJump, int maxRun, boolean done) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.done = done;
    }



    @Override
    public void jump(float heightJump) {
        System.out.println(name + " любит прыгат и может подпрыгнуть на высоту не более " + heightJump+ " метров");
    }

//    @Override
//    public void jump() {
//        System.out.println(name + " Это Кошка любит прыгать");
//    }

    @Override
    public void run(int lengthRun) {
        System.out.println(name + " любит бегать и может пробежать не более " + lengthRun+ " метров");
    }

//    @Override
//    public void run() {
//        System.out.println(name + " Это Кошка любит бегать");
//    }

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
//
//        if  (wall.height >=maxJump) this.done= true;
//    }

    @Override
    public String toString() {
        return "Cats{" +
                "name='" + name + '\'' +
                ", maxJump=" + maxJump +
                ", maxrun=" + maxRun +
                ", done=" + done +
                '}';
    }
}
