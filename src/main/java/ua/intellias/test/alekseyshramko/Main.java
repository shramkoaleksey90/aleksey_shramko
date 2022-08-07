package ua.intellias.test.alekseyshramko;

import java.util.List;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.operation.InnerJoinOperation;
import ua.intellias.test.alekseyshramko.operation.LeftJoinOperation;
import ua.intellias.test.alekseyshramko.operation.RightJoinOperation;

public class Main {
  public static void main(String[] args) {
    InnerJoinOperation<Integer, String, String> innerJoinOperation = new InnerJoinOperation<>();
    LeftJoinOperation<Integer, String, String> leftJoinOperation = new LeftJoinOperation<>();
    RightJoinOperation<Integer, String, String> rightJoinOperation = new RightJoinOperation<>();

    List<DataRow<Integer, String>> leftCollection = List.of(
        new DataRow<>(0, "Ukraine"),
        new DataRow<>(1, "Germany"),
        new DataRow<>(2, "France")
    );

    List<DataRow<Integer, String>> rightCollection = List.of(
        new DataRow<>(0, "Kiev"),
        new DataRow<>(1, "Berlin"),
        new DataRow<>(3, "Budapest")
    );

    System.out.println(innerJoinOperation.join(leftCollection, rightCollection));
    System.out.println(leftJoinOperation.join(leftCollection, rightCollection));
    System.out.println(rightJoinOperation.join(leftCollection, rightCollection));
  }
}
