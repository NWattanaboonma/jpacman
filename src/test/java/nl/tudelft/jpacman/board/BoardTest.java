package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A very simple test class for the Board class.
 */
public class BoardTest {

    private final Square[][] grid = new Square[1][1];
    private final Board board = new Board(grid);
    private final Square square = new BasicSquare();

    /**
     * A very simple test for the board class.
     */
    @Test
    void testBoard() {
        grid[0][0] = square;
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isEqualTo(square);
    }
    /**
     * Tests the squareAt method.
     */
    @Test
    void testSquareAt() {
        grid[0][0] = square;
        assertThat(board.squareAt(0, 0)).isEqualTo(square);
    }

}
