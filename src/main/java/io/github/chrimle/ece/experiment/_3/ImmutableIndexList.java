package io.github.chrimle.ece.experiment._3;

import java.util.*;

public class ImmutableIndexList<E extends Enum<?>> implements List<E> {

  private final ArrayList<Integer> internalList;
  private final Class<E> keyType;
  private final List<E> enumConstants;

  private ImmutableIndexList() {
    internalList = new ArrayList<>();
    keyType = null;
    enumConstants = null;
  }

  private ImmutableIndexList(final Collection<E> collection) {
    keyType = (Class<E>) collection.iterator().next().getClass();
    enumConstants = List.of(keyType.getEnumConstants());
    internalList = new ArrayList<>(collection.stream().map(enumConstants::indexOf).toList());
  }

  public static <E extends Enum<?>> List<E> of() {
    return new ImmutableIndexList<>();
  }

  public static <E extends Enum<?>> List<E> of(final Collection<E> c) {
    return new ImmutableIndexList<>(c);
  }

  private Integer getEnumIndex(final E e) {
    return enumConstants.indexOf(e);
  }

  private E getEnumValue(final Integer index) {
    return enumConstants.get(index);
  }

  @Override
  public int size() {
    return internalList.size();
  }

  @Override
  public boolean isEmpty() {
    return internalList.isEmpty();
  }

  @Override
  public int indexOf(Object o) {
    return internalList.indexOf(getEnumIndex((E) o));
  }

  @Override
  public int lastIndexOf(Object o) {
    return internalList.lastIndexOf(getEnumIndex((E) o));
  }

  @Override
  public E get(int index) {
    return getEnumValue(internalList.get(index));
  }

  @Override
  public boolean contains(Object o) {
    if (o == null) return false;
    return internalList.contains(getEnumIndex((E) o));
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return internalList.containsAll(c.stream().map(o -> (E) o).map(this::getEnumIndex).toList());
  }

  // Ignored Methods

  @Override
  public Iterator<E> iterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public E[] toArray() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean add(E o) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(Collection c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(int index, Collection c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException();
  }

  @Override
  public E set(int index, E element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void add(int index, E element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public E remove(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ListIterator<E> listIterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean retainAll(Collection c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean removeAll(Collection c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException();
  }
}
