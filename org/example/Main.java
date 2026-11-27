package org.example;

import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Transaction transaction =
                new Transaction(101, 250.75, LocalDate.of(2026, 11, 27));

        Transaction first =
                new Transaction(1, 100.0, LocalDate.of(2026, 1, 1));
        Transaction second =
                new Transaction(1, 200.0, LocalDate.of(2026, 1, 1));
        Transaction third =
                new Transaction(1, 300.0, LocalDate.of(2026, 1, 1));

        Set<Transaction> equalitySet = new HashSet<>();
        equalitySet.add(first);
        equalitySet.add(second);

        System.out.println("Contains first before changing id: "
            + equalitySet.contains(first));

        first.setId(2);

        System.out.println("Contains first after changing id: "
            + equalitySet.contains(first));

        System.out.println("Set size with equals only: " + equalitySet.size());
        System.out.println("Contains third with equals only: " + equalitySet.contains(third));

        Container<Transaction> transactionContainer =
                new Container<>(transaction);

        System.out.println(transactionContainer.getValue().getAmount());

        ObjectContainer objectContainer = new ObjectContainer(transaction);
//        objectContainer.setValue("Це рядок");

        Transaction restored =
                (Transaction) objectContainer.getValue();

        System.out.println(restored.getAmount());

        List<Integer> integers = List.of(10, 20, 30);
        printList(integers);
        printNumbers(integers);

        List<Transaction> arrayList = new ArrayList<>();
        List<Transaction> linkedList = new LinkedList<>();
        Set<Transaction> hashSet = new HashSet<>();

        for (int i = 0; i < 100_000; i++) {
            Transaction item = new Transaction(
                    i,
                    i * 1.25,
                    LocalDate.of(2026, 1, 1)
            );

            arrayList.add(item);
            linkedList.add(item);
            hashSet.add(item);
        }

        System.out.println("ArrayList: " + arrayList.size());
        System.out.println("LinkedList: " + linkedList.size());
        System.out.println("HashSet: " + hashSet.size());

        int middleIndex = arrayList.size() / 2;

        long startArrayList = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            arrayList.add(middleIndex, new Transaction(
                    200_000 + i,
                    i * 2.0,
                    LocalDate.of(2026, 2, 1)
            ));
        }
        long arrayListTime = System.nanoTime() - startArrayList;

        long startLinkedList = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            linkedList.add(middleIndex, new Transaction(
                    200_000 + i,
                    i * 2.0,
                    LocalDate.of(2026, 2, 1)
            ));
        }
        long linkedListTime = System.nanoTime() - startLinkedList;

        System.out.println("ArrayList insertion: " + arrayListTime + " ns");
        System.out.println("LinkedList insertion: " + linkedListTime + " ns");

        Transaction searchItem = arrayList.get(99_999);

        long startArraySearch = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            arrayList.contains(searchItem);
        }
        long arraySearchTime = System.nanoTime() - startArraySearch;

        long startLinkedSearch = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            linkedList.contains(searchItem);
        }
        long linkedSearchTime = System.nanoTime() - startLinkedSearch;

        long startHashSearch = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            hashSet.contains(searchItem);
        }
        long hashSearchTime = System.nanoTime() - startHashSearch;

        System.out.println("ArrayList contains: " + arraySearchTime + " ns");
        System.out.println("LinkedList contains: " + linkedSearchTime + " ns");
        System.out.println("HashSet contains: " + hashSearchTime + " ns");

        try {
            for (Transaction item : arrayList) {
                if (item.getId() % 2 == 0) {
                    arrayList.remove(item);
                }
            }
        }catch (ConcurrentModificationException e) {
            System.out.println("for-each removal: " + e);
        }

        Iterator<Transaction> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            Transaction item = iterator.next();

            if (item.getId() % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("ArrayList size after iterator removal: " + arrayList.size());
    }

    static <T> void printList(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
}
