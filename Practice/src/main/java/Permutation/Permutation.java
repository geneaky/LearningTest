package Permutation;

public class Permutation {

  public static void main(String[] args) {

    String[] list = {"A","B","C","D","E"};
    boolean[] isVisited = new boolean[list.length];
    dfs("",isVisited,list);
  }

  public static void dfs(String name,boolean[] isVisited,String[] list){

    if(name.length()==list.length-1){
      System.out.println(name);
    }

    for(int i = 0;i<list.length;i++){
      if(!isVisited[i]){
        isVisited[i] = true;
        String n = name + list[i];
        dfs(n,isVisited,list);
        isVisited[i] = false;
      }
    }
  }

}
