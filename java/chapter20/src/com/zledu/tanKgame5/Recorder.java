package com.zledu.tanKgame5;

import java.io.*;
import java.util.Vector;

/**
 * @author Alonso
 * 记录相关信息和文件交互
 */
public class Recorder {

    //定义变量，记录击毁敌方坦克数
    private static int AllEnemyTanKNum = 0;
    //定义IO变量，把数据写入到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String RecordFile = "e:\\myRecorder.txt";
    //因为敌人坦克是在 MyPanel的Vector集合中，所以要在本类中定义一个Vector集合，用于存放 MyPanel类传进来的EnemyTanK
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的 Vector，用于存放敌人的信息node
    private static Vector<Node> nodes = new Vector<>();


    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //编写一个方法，用户读取文件中的数据
    //该方法在继续上局游戏的时候使用
    public static Vector<Node> getNodesEnemyTanK(){
        try {
            //读取 RecordFile中的数据
            br = new BufferedReader(new FileReader(RecordFile));
            //先读取第一行，恢复敌方坦克数
            AllEnemyTanKNum = Integer.parseInt(br.readLine());
            //再循环读取恢复坐标方向，生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null){
                //使用 split()分割，获取到x,y,d
                String[] xyd = line.split(" ");
                //把分割后的数组放入 Node中
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                //把获取到的node对象放入nodes集合中
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }

    //编写方法，当游戏结束时，将数据写入文件 myRecord.txt
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(RecordFile));
            bw.write(AllEnemyTanKNum + "\r\n"); //"\r\n" 换行
            //记录当时的敌人坦克坐标
            //遍历 enemyTanks集合
            for (int i = 0; i < enemyTanks.size(); i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                //把 enemyTank的坐标和方向存入变量中
                String recorde = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                bw.write(recorde + "\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAllEnemyTanKNum() {
        return AllEnemyTanKNum;
    }

    public static void setAllEnemyTanKNum(int allEnemyTanKNum) {
        AllEnemyTanKNum = allEnemyTanKNum;
    }

    //当击中敌方坦克时，AllEnemyTanKNum++
    public static void addAllEnemyTanKNum(){
        AllEnemyTanKNum++;
    }
}
