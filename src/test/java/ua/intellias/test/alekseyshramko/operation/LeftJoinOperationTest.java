package ua.intellias.test.alekseyshramko.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.dto.JoinedDataRow;

class LeftJoinOperationTest {
  private LeftJoinOperation<Integer, String, String> leftJoinOperation;

  @BeforeEach
  void setup() {
    leftJoinOperation = new LeftJoinOperation<>();
  }

  @Test
  void givenEmptyLeftCollectionWhenLeftJoinThenReturnEmptyCollection() {
    //Given
    List<DataRow<Integer, String>> left = List.of();
    List<DataRow<Integer, String>> right = List.of(new DataRow<>(0, "Kiev"));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = leftJoinOperation.join(left, right);

    //Then
    assertEquals(result.size(), 0);
  }

  @Test
  void givenNullKeyValue() {
    //Given
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(null, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(0, "Kiev"));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = leftJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(null, "Ukraine", null)));
  }

  @Test
  void givenNullAsValue() {
    //Given
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(0, null));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(0, "Kiev"));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = leftJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(0, null, "Kiev")));
  }
}