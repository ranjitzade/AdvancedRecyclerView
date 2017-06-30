//package com.ranjitzade.advrecyclerview.adapter;
//
//import android.support.annotation.NonNull;
//import android.util.SparseArray;
//
//import com.ranjitzade.advrecyclerview.adapter.model.Item;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Spliterator;
//import java.util.function.Consumer;
//import java.util.function.UnaryOperator;
//
///**
// * @author ranjit
// */
//public class ItemList<I extends Item> /*extends ArrayList*/ {
//    private SparseArray<I> mItemTypeArray = new SparseArray<>();
//    private List<I> mList;
//
//    public ItemList() {
//        this.mList = new ArrayList<>();
//        this.mItemTypeArray = new SparseArray<>();
//    }
//
//    public ItemList(List<I> list) {
//        this.mList = list;
//        this.mItemTypeArray = new SparseArray<>();
//    }
//
//    public int size() {
//        return mList.size();
//    }
//
//    public void add(int index, I element) {
//        mList.add(index, element);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return super.contains(o);
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return super.indexOf(o);
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return super.lastIndexOf(o);
//    }
//
//    @Override
//    public Object clone() {
//        return super.clone();
//    }
//
//    @Override
//    public Object[] toArray() {
//        return super.toArray();
//    }
//
//    @Override
//    public Object[] toArray(Object[] a) {
//        return super.toArray(a);
//    }
//
//    public I get(int index) {
//        return mList.get(index);
//    }
//
//    @Override
//    public Object set(int index, Object element) {
//        return super.set(index, element);
//    }
//
//    @Override
//    public boolean add(Object o) {
//        return super.add(o);
//    }
//
//    @Override
//    public Object remove(int index) {
//        return super.remove(index);
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return super.remove(o);
//    }
//
//    @Override
//    public void clear() {
//        super.clear();
//    }
//
//    @Override
//    public boolean addAll(Collection c) {
//        return super.addAll(c);
//    }
//
//    @Override
//    public boolean addAll(int index, Collection c) {
//        return super.addAll(index, c);
//    }
//
//    @Override
//    protected void removeRange(int fromIndex, int toIndex) {
//        super.removeRange(fromIndex, toIndex);
//    }
//
//    @Override
//    public boolean removeAll(Collection c) {
//        return super.removeAll(c);
//    }
//
//    @Override
//    public boolean retainAll(Collection c) {
//        return super.retainAll(c);
//    }
//
//    @NonNull
//    @Override
//    public ListIterator listIterator(int index) {
//        return super.listIterator(index);
//    }
//
//    @NonNull
//    @Override
//    public ListIterator listIterator() {
//        return super.listIterator();
//    }
//
//    @NonNull
//    @Override
//    public Iterator iterator() {
//        return super.iterator();
//    }
//
//    @Override
//    public List subList(int fromIndex, int toIndex) {
//        return super.subList(fromIndex, toIndex);
//    }
//
//    @Override
//    public void forEach(Consumer action) {
//        super.forEach(action);
//    }
//
//    @Override
//    public Spliterator spliterator() {
//        return super.spliterator();
//    }
//
//    @Override
//    public boolean removeIf(Predicate filter) {
//        return super.removeIf(filter);
//    }
//
//    @Override
//    public void replaceAll(UnaryOperator operator) {
//        super.replaceAll(operator);
//    }
//
//    @Override
//    public void sort(Comparator c) {
//        super.sort(c);
//    }
//}