package io.github.chrimle.ece;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class PseudoRandomizer {

  private PseudoRandomizer() {}

  public static ExampleEnum[] getEvenDistribution(final int arrayLength) {
    if (arrayLength % ExampleEnum.getIndexCount() != 0) {
      throw new IllegalArgumentException(
          "arrayLength is not a multiple of %d".formatted(ExampleEnum.getIndexCount()));
    }
    final var countPerEnum = arrayLength / ExampleEnum.getIndexCount();
    final var remainingPerEnum =
        Arrays.stream(ExampleEnum.values())
            .collect(Collectors.toMap(Function.identity(), ignore -> countPerEnum));
    final var result = new ExampleEnum[arrayLength];
    for (int index = 0; index < arrayLength; index++) {
      final var random = getRandom(List.copyOf(remainingPerEnum.keySet()));
      result[index] = random;
      remainingPerEnum.computeIfPresent(
          random,
          (ignore, oldValue) -> {
            oldValue--;
            return oldValue == 0 ? null : oldValue;
          });
    }
    return result;
  }

  private static ExampleEnum getRandom(final List<ExampleEnum> availableChoices) {
    final int size = availableChoices.size();
    if (size == 0) {
      throw new IllegalArgumentException("Cannot select a value from 0 available choices!");
    }
    if (size == 1) {
      return availableChoices.getFirst();
    }
    return availableChoices.get((int) (Math.random() * size));
  }
}
