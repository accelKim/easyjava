package Chapter9Chellenge;


import java.util.*;

public class ArrayListScoreExample {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> scoreArray = new ArrayList<>();
    int score = 0;
    while(true){
      System.out.print("학생의 점수를 입력하세요. (종료하려면 -1 입력) : ");
      score = in.nextInt();
      if(score < 0) {
        // 학생의 정보 출력
        printScore(scoreArray);
        // 최고 점수 구하기
        int maxScore = getMaxScore(scoreArray);
        // 성적 처리
        printGrade(scoreArray, maxScore);
        break;
      }
      // 학생의 정보 추가
      scoreArray.add(score);
    }
  }

  static void printScore(ArrayList<Integer> arrList){
    // 학생의 정보 출력
    System.out.printf("전체 학생은 %d 명이다.\n", arrList.size());
    System.out.print("학생들의 성적 : ");
    for (int score : arrList) {
      System.out.print(score + " ");
    }
    System.out.println();
  }

  static void printGrade(ArrayList<Integer> scores, int maxScore){
    // 학생의 성적 처리
    int score = 0;
    for (int i = 0; i < scores.size() ; i++) {
      score = scores.get(i);
      if(score - maxScore > -10)
        System.out.printf("%d 번 학생의 성적은 %d 이며 등급은 A이다.\n", i, score);
      else if(score - maxScore > -20)
        System.out.printf("%d 번 학생의 성적은 %d 이며 등급은 B이다.\n", i, score);
      else
        System.out.printf("%d 번 학생의 성적은 %d 이며 등급은 C이다.\n", i, score);
    }

    System.out.println();
  }

  static int getMaxScore(ArrayList<Integer> arrList){
    Integer[] scoreArray = arrList.toArray(new Integer[0]);
    Arrays.sort(scoreArray);
    return scoreArray[scoreArray.length -1];
  }
}