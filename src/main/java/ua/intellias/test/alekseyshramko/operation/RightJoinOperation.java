package ua.intellias.test.alekseyshramko.operation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.dto.JoinedDataRow;

public class RightJoinOperation<K, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>,
    JoinedDataRow<K, V1, V2>> {
  @Override
  public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
                                                   Collection<DataRow<K, V2>> rightCollection) {
    Map<K, V1> leftCollectionMap = new HashMap<>();
    leftCollection.forEach(map -> leftCollectionMap.put(map.getKey(), map.getValue()));

    return rightCollection.stream()
        .map(dataRow -> {
          JoinedDataRow<K, V1, V2> joinedDataRow = new JoinedDataRow<>();
          joinedDataRow.setKey(dataRow.getKey());
          joinedDataRow.setLeftValue(leftCollectionMap.get(dataRow.getKey()));
          joinedDataRow.setRightValue(dataRow.getValue());
          return joinedDataRow;
        })
        .collect(Collectors.toList());
  }
}
