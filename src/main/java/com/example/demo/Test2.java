package com.example.demo;

public class Test2 {
    public static void main(String[] args) {
        PrintService printService=new PrintService();
        Thread.currentThread().setName("MainThread");
        new EvenThread(printService).start();
        new OddThread(printService).start();

    }
}
class PrintService{
    private boolean evenPrinted=false;
    public synchronized void printEven(int i) throws InterruptedException {
        this.notifyAll();
        if (!evenPrinted){
            System.out.println("Even = "+i);
            evenPrinted=true;
            this.wait();//even thread relase lock on PrintService and go to waiting state
            Thread.sleep(1000);
        }

    }
    public synchronized void printOdd(int i) throws InterruptedException {
        this.notifyAll();
        if (evenPrinted){
            System.out.println("Odd = "+i);
            evenPrinted=false;
            this.wait();//odd thread relase lock and waiting state
            Thread.sleep(1000);
        }

    }
}
class EvenThread extends Thread{
    PrintService printService;
    public EvenThread(PrintService printService){
        this.printService=printService;
    }
    public void run(){
        Thread.currentThread().setName("EvenThread");
        for (int i=0;i<=10;i=i+2){
            try {printService.printEven(i);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
class OddThread extends Thread{
    PrintService printService;
    OddThread(PrintService printService){
        this.printService=printService;
    }
    public void run(){
        Thread.currentThread().setName("OddThread");
        for (int i=1;i<=10;i=i+2){
            try {printService.printOdd(i);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }

}