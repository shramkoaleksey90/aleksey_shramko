package ua.intellias.test.alekseyshramko.operation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import ua.intellias.test.alekseyshramko.dto.DataRow;
import ua.intellias.test.alekseyshramko.dto.JoinedDataRow;

public class LeftJoinOperation<K, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>,
    JoinedDataRow<K, V1, V2>> {

  @Override
  public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
                                                   Collection<DataRow<K, V2>> rightCollection) {
    Map<K, V2> rightCollectionMap = new HashMap<>();
    rightCollection.forEach(map -> rightCollectionMap.put(map.getKey(), map.getValue()));

    return leftCollection.stream()
        .map(dataRow -> {
          JoinedDataRow<K, V1, V2> joinedDataRow = new JoinedDataRow<>();
          joinedDataRow.setKey(dataRow.getKey());
          joinedDataRow.setLeftValue(dataRow.getValue());
          joinedDataRow.setRightValue(rightCollectionMap.get(dataRow.getKey()));
          return joinedDataRow;
        })
        .collect(Collectors.toList());
  }
}
