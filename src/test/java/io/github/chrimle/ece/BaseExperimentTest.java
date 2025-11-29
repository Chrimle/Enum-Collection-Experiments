package io.github.chrimle.ece;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class BaseExperimentTest {

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
}
