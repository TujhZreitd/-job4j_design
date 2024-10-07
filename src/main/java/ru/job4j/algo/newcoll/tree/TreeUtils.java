package ru.job4j.algo.newcoll.tree;

import ru.job4j.collection.SimpleQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TreeUtils<T> {
    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);
        while (true) {
            try {
                Node<T> node = queue.poll();
                List<Node<T>> children = node.getChildren();
                if (!children.isEmpty()) {
                    for (Node<T> nodeChild : children) {
                        queue.push(nodeChild);
                    }
                }
            } catch (NoSuchElementException e) {
                break;
            }
            result++;
        }
        return result;
    }

    /**
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        List<T> result = new ArrayList<>();
        queue.push(root);
        while (true) {
            try {
                Node<T> node = queue.poll();
                result.add(node.getValue());
                List<Node<T>> children = node.getChildren();
                if (!children.isEmpty()) {
                    for (Node<T> nodeChild : children) {
                        queue.push(nodeChild);
                    }
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return result;
    }
}
