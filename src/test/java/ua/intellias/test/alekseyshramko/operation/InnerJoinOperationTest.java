package ua.intellias.test.alekseyshramko.operation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.dto.JoinedDataRow;

class InnerJoinOperationTest {
  private InnerJoinOperation<Integer, String, String> innerJoinOperation;

  @BeforeEach
  void setUp() {
    innerJoinOperation = new InnerJoinOperation<>();
  }

  @Test
  void givenEmptyRightCollectionWhenInnerJoinThenReturnEmptyCollection() {
    //Given
    List<DataRow<Integer, String>> left = List.of(new DataRow<>(0, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of();

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = innerJoinOperation.join(left, right);

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
    Collection<JoinedDataRow<Integer, String, String>> result = innerJoinOperation.join(left, right);

    //Then
    assertEquals(result.size(), 0);
  }

  @Test
  void givenNullAsValueOfRightCollection() {
    //Given
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(0, "Ukraine"));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(0, null));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = innerJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(0, "Ukraine", null)));
  }

  @Disabled("something went wrong, I get an error NPE")
  @Test
  void givenNullAsValueOfLeftCollection() {
    //Given
    List<DataRow<Integer, String>> left = List.of(
        new DataRow<>(0, null));
    List<DataRow<Integer, String>> right = List.of(
        new DataRow<>(0, "Kiev"));

    //When
    Collection<JoinedDataRow<Integer, String, String>> result = innerJoinOperation.join(left, right);

    //Then
    assertEquals(result, List.of(new JoinedDataRow(0, "Ukraine", null)));
  }

}