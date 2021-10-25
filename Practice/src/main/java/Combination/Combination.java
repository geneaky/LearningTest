package Combination;

public class Combination {

  public static void main(String[] args) {
    Combination ex = new Combination();
    int[] arr = {1,3,5,7,9};
    int n = arr.length;
    int r= 3;
    //크기가 5인 수열 arr에서 3개를 뽑은 경우
    int[] com = new int[n];//뽑은 원소의 인덱스를 저장하는 배열

    ex.combinate(com,n,r,0,0,arr);
  }

  private void combinate(int[] com, int n, int r,int index,int target, int[] arr) {
    if(r==0){ //다 뽑았을 때
      for(int i =0;i<index;i++){
        System.out.print(arr[com[i]]+" ");
      }
      System.out.println();
    }else if(target == n){ // r개 다 못 뽑았는데 arr의 모든 원소를 다 검사했을 때, 실패 -> 아무것도 안하고 끝남
      return;
    }else{
      com[index] = target;
      combinate(com,n,r-1,index+1,target+1,arr); // 원소를 뽑는 경우
      combinate(com,n,r,index,target+1,arr); // 원소를 안뽑는 경우(지금 위치에서 인덱스 안뽑고 다음으로 넘어가서 뽑을 때)
    }
  }

}
