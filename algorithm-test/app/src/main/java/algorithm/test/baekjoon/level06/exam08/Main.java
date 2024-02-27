package algorithm.test.baekjoon.level06.exam08;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);

    String[] subjects = new String[20];
    double[] grades = new double[20];
    String[] grades1 = new String[20];
    double sum = 0;
    double total = 0;

    for (int i = 0; i < 20; i++) {
      subjects[i] = sc.next();
      grades[i] = sc.nextDouble();
      grades1[i] = sc.next();
      if (grades1[i].equals("P")) {
        continue;
      } else {
        total += grades[i];
      }
    }

    for (int i = 0; i < 20; i++) {
      if (grades1[i].equals("A+")) {
        sum += grades[i] * 4.5;
      } else if (grades1[i].equals("A0")) {
        sum += grades[i] * 4.0;
      } else if (grades1[i].equals("B+")) {
        sum += grades[i] * 3.5;
      } else if (grades1[i].equals("B0")) {
        sum += grades[i] * 3.0;
      } else if (grades1[i].equals("C+")) {
        sum += grades[i] * 2.5;
      } else if (grades1[i].equals("C0")) {
        sum += grades[i] * 2.0;
      } else if (grades1[i].equals("D+")) {
        sum += grades[i] * 1.5;
      } else if (grades1[i].equals("D0")) {
        sum += grades[i] * 1.0;
      } else if (grades1[i].equals("F")) {
        sum += grades[i] * 0.0;
      } else if (grades1[i].equals("P")) {
        continue;
      }
    }
    System.out.printf("%f", sum / total);
    sc.close();
  }
}


