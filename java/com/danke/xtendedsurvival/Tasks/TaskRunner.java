package com.danke.xtendedsurvival.Tasks;

import java.util.Random;

public class TaskRunner implements Runnable{

    private boolean closed = false;

    @Override
    public void run() {
        while (!closed) {
            try {
                Random r = new Random();
                int time = r.nextInt(8000, 15000);
                Thread.sleep(time);
                SpawnEnemyTask s = new SpawnEnemyTask();
                EnemyAttackTask attackTask = new EnemyAttackTask();
                Thread attackThread = new Thread(attackTask);
                attackThread.start();
                Thread t = new Thread(s);
                t.start();
                System.out.println(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void close(){
        this.closed = true;
    }
}
