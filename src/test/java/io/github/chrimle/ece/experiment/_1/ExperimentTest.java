package io.github.chrimle.ece.experiment._1;

import static org.junit.jupiter.api.Assertions.*;

import io.github.chrimle.ece.ExampleEnum;
import io.github.chrimle.ece.PseudoRandomizer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

final class ExperimentTest {

  static Stream<Arguments> getEnumArraysForTests() {
    return Stream.of(
        Arguments.of((Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount())),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 2)),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 5)),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 10)),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 100)),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 1000)),
        Arguments.of(
            (Object) PseudoRandomizer.getEvenDistribution(ExampleEnum.getIndexCount() * 10000)));
  }

  @ParameterizedTest
  @MethodSource("getEnumArraysForTests")
  void testInstantiate(final ExampleEnum[] enumArray) {
    final var expectedLength = enumArray.length;
    final var expectedCountPerEnum = enumArray.length / ExampleEnum.getIndexCount();
    // When
    final var resultList = assertDoesNotThrow(() -> List.of(enumArray));
    // Then
    assertNotNull(resultList);
    assertEquals(expectedLength, resultList.size());
    final var enumMap =
        resultList.stream()
            .collect(Collectors.toMap(element -> element, ignored -> 1, Integer::sum));
    Arrays.stream(ExampleEnum.values())
        .forEachOrdered(
            exampleEnum -> {
              final var actualCount = enumMap.get(exampleEnum);
              assertEquals(expectedCountPerEnum, actualCount);
            });
  }
}
