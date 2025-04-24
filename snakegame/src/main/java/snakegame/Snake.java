package snakegame;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos) {
        head = initPos;
        snakePartList.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }

    public void grow(Cell cella) {
        snakePartList.add(0, cella);
        head = cella;
        cella.setCellType(CellType.SNAKE_NODE);
    }

    public void move(Cell nextCell) { // controllo la posizione
        System.out.println("Snake is moving to " + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);

        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) { // controllo se si è schiantato
        System.out.println("Going to check for Crash");
        for (Cell cell : snakePartList) {
            System.out.println(cell.getRow() + ", " + cell.getCol());
            if (cell == nextCell) {
                System.out.println(cell.getRow() + ", " + cell.getCol());
                System.out.println("crash: " + nextCell.getRow() + ", " + nextCell.getCol());
                return true;
            }
        }
        return false;
    }

    public LinkedList<Cell> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() {
        return head;
    }

    public boolean isHead(Cell cell) {
        return cell == head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }

    // Adding the getTail() method
    public Cell getTail() {
        return snakePartList.getLast();
    }

}
