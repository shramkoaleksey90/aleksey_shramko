package ua.intellias.test.alekseyshramko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinedDataRow<K, V1, V2> {
  private K key;
  private V1 leftValue;
  private V2 rightValue;
}
