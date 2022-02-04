package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class Word<E extends Enum<E>> extends LinkedList<Block<E>> {

    public boolean isReduced() {
        Block<E> previousBlock = null;
        for (Block<E> currentBlock : this
        ) {
            if (currentBlock.exponent() == 0) return false;
            if (previousBlock != null && currentBlock.generator().equals(previousBlock.generator())) return false;
            previousBlock = currentBlock;
        }
        return true;
    }

    public void reduce() {
        ListIterator<Block<E>> iterator = listIterator();
        Block<E> previousBlock, currentBlock;
        previousBlock = null;
        while (iterator.hasNext()) {
            currentBlock = iterator.next();
            if (currentBlock.exponent() == 0) {
                iterator.remove();
                continue;
            }
            if (previousBlock != null && currentBlock.generator().equals(previousBlock.generator())) {
                Block<E> newBlock = new Block<>(currentBlock.generator(), previousBlock.exponent() + currentBlock.exponent());
                iterator.remove();
                iterator.previous();
                if (newBlock.exponent() != 0) {
                    iterator.set(newBlock);
                    iterator.next();
                    previousBlock = newBlock;
                    continue;
                }
                iterator.remove();
                if (iterator.hasPrevious()) {
                    previousBlock = iterator.previous();
                    iterator.next();
                    continue;
                }
                previousBlock = null;
                continue;
            }
            previousBlock = currentBlock;
        }
    }

    @Override
    public String toString() {
        Iterator<Block<E>> it = iterator();
        if (!it.hasNext()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            Block<E> block = it.next();
            sb.append(block.toString());
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(" ");
        }
    }

}
