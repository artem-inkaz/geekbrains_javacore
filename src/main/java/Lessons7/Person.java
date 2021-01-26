package Lessons7;

public class Person implements JumpRun{
    protected String name;
    protected float maxJump;
    protected int maxRun;
    protected boolean done = false;

    public Person(String name, float maxJump, int maxRun, boolean done) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.done = done;
    }


//    @Override
//    public void run(){
//        System.out.println(name + " Этот человек любит бегать");
//    }
    @Override
    public void run(int length){
        System.out.println("Человек " + name + " любит бегать и может пробежать не более " + length+ " метров");
    }


//    @Override
//    public void jump(){
//        System.out.println(name + " Этот человек любит прыгать");
//    }
    @Override
    public void jump(float length){
        System.out.println("Человек " + name + " любит прыгать и может подпрыгнуть на высоту не более " + length+ " метров");
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

//    public void runDo(JumpRun jumpRun){
//        if  (jumpRun..length >=maxRun) this.done= true;
//    }

//    public void runDo(RunTrack runTrack){
//        if  (runTrack.length >=maxrun) this.done= true;
//    }
//
//    public void jumpDo(Wall wall){
//        if  (wall.height >=maxJump) this.done= true;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", maxJump=" + maxJump +
                ", maxrun=" + maxRun +
                ", done=" + done +
                '}';
    }
}
