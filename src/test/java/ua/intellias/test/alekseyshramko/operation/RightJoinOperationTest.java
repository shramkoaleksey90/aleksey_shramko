package ua.intellias.test.alekseyshramko.operation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.dto.JoinedDataRow;

class RightJoinOperationTest {
  private RightJoinOperation<Integer, String, String> rightJoinOperation;

  @BeforeEach
  void setUp() {
    rightJoinOperation = new RightJoinOperation<>();
  }

  @Test
  void givenEmptyRightCollectionWhenRightJoinThenReturnEmptyCollection() {
    //Given
    List<DataRow<Integer, String>> left = List.of(new DataRow<>(0, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of();

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = rightJoinOperation.join(left, right);

    //Then
    assertEquals(result.size(), 0);
  }

  @Test
  void givenNullKeyValue() {
    //Given
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(0, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(null, "Kiev"));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = rightJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(null, null, "Kiev")));
  }

  @Test
  void givenNullAsValue() {
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(0, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(0, null));
    //When
    Collection<JoinedDataRow<Integer, String, String>> result = rightJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(0, "Ukraine", null)));
  }
}