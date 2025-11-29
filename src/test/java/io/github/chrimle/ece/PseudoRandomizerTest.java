package io.github.chrimle.ece;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PseudoRandomizerTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 10})
  void testEvenDistribution(final int countPerEnum) {
    final var enumCount = ExampleEnum.getIndexCount();
    final var expectedArrayLength = enumCount * countPerEnum;
    // When
    final var evenDistribution = PseudoRandomizer.getEvenDistribution(expectedArrayLength);
    // Then
    assertNotNull(evenDistribution);
    assertEquals(expectedArrayLength, evenDistribution.length);
    final var evenDistributionAsMap =
        Arrays.stream(evenDistribution)
            .collect(Collectors.toMap(element -> element, ignored -> 1, Integer::sum));

    Arrays.stream(ExampleEnum.values())
        .forEachOrdered(
            exampleEnum -> {
              final var actualCount = evenDistributionAsMap.get(exampleEnum);
              assertEquals(countPerEnum, actualCount);
            });
  }
}
