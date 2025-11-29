package io.github.chrimle.ece.experiment._2;

import java.util.*;

public class ImmutableList<E extends Enum<?>> implements List<E> {

  private final ArrayList<E> internalList;

  private ImmutableList() {
    internalList = new ArrayList<>();
  }

  private ImmutableList(final Collection<E> collection) {
    internalList = new ArrayList<>(collection);
  }

  public static <E extends Enum<?>> List<E> of() {
    return new ImmutableList<>();
  }

  public static <E extends Enum<?>> List<E> of(final Collection<E> c) {
    return new ImmutableList<>(c);
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
    return internalList.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return internalList.lastIndexOf(o);
  }

  @Override
  public E get(int index) {
    return internalList.get(index);
  }

  @Override
  public boolean contains(Object o) {
    return internalList.contains(o);
  }

  @Override
  public boolean containsAll(Collection c) {
    return internalList.containsAll(c);
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
