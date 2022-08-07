## Solution Justification

There are 3 possible approaches that to achieve collections join. Below one can find their description, time and space complexity comparison and justification of the chosen solution.

Approach | Time complexity | Space complexity
--- | --- | ---
Double loop | O(n2) | O(1)
HashMap and single loop | O(2n) ~ O(n) | O(n)
Single loop and merge | O(2n) ~ O(n) | O(1)

##### Double loop
The least sophisticated solution which implies `foreach` loop for the first collection and inner `foreach` loop to find match in the second collection. Advantage of this approach is zero space consumption as far as no additional data structures required. Disadvantage of this approach is its time complexity. It can be used for small collections when `n^2` is not much greater then `2n`. However, there is no information in task regarding input collections size, so we assume that we should be "time complexity aware".

##### Single loop and merge
Looks like the most efficient approach with linear time complexity and zero space consumption. This approach implies usage of two iterators. We move left or right iterator when left or right value is greater or less than another, and create new result object if values are equal. However, this approach imposes restrictions on input collections. Firstly, input collections should be sorted, or we should sort them first if not (which implies additional time complexity - `O(n * log n)` in average for each collection). Secondly, key type should implement `Comparable` if we want to operate with terms "grater than" and "less than". However, there is no information in a task description about whether input data addresses such restrictions.

##### HashMap and single loop
This approach implies first loop/stream which "inverse" one of the collections into `HashMap` and second loop which checks for key match. So far, it requires two separate loops and additional data structure (we neglect complexity of key search as far as it is constant complexity `O(1)` for `HashMap`). This approach works finely for any input data type with properly implemented `equals` and `hashCode`. So far, for all the reasons mentioned, this approach has been chosen as a final solution for this application.

## Install and launch

##### Prerequisites

One should have the following tools installed and set up to install and launch the application:
1. JDK 11+
2. Maven
3. GitBash

##### Run locally

To download codebase use `GitBash`:

`git clone <repository> <path-on-your-pc>`

To run project use `Maven`:

`mvn exec:java`

To run all the tests use `Maven`:

`mvn test`