package coursera.projects_part1.slider_puzzle;

import org.junit.jupiter.api.Test;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2020
 **/
class BoardTest {

    @Test
    public void equals() throws Exception {
        Board a = new Board(new int[][]{{1, 2}, {0, 3}});
        Board b = new Board(new int[][]{{1, 2}, {0, 3}});
        Board c = new Board(new int[][]{{2, 1}, {0, 3}});
        assert a.equals(b);
        assert !a.equals(c);
    }

    @Test
    public void twin() throws Exception {
        Board a = new Board(new int[][]{{1, 2}, {0, 3}});
        Board b = new Board(new int[][]{{1, 2}, {0, 3}});
        Board c = new Board(new int[][]{{2, 1}, {0, 3}});
        assert a.twin().equals(c);
        assert !a.twin().equals(b);

        Board d = new Board(new int[][]{{0, 2}, {1, 3}});
        Board e = new Board(new int[][]{{0, 2}, {3, 1}});
        assert d.twin().equals(e);
    }

    @Test
    public void isGoal() throws Exception {
        Board a = new Board(new int[][]{{1, 2}, {0, 3}});
        Board b = new Board(new int[][]{{1, 2}, {3, 0}});
        Board c = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assert !a.isGoal();
        assert b.isGoal();
        assert c.isGoal();
        assert !c.twin().isGoal();
    }

    @Test
    public void hamming() throws Exception {
        Board a = new Board(new int[][]{{1, 2}, {0, 3}});
        Board b = new Board(new int[][]{{1, 2}, {3, 0}});
        Board c = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board d = new Board(new int[][]{{0, 2, 3}, {4, 1, 6}, {7, 8, 5}});
        assert a.hamming() == 1;
        assert b.hamming() == 0;
        assert c.hamming() == 0;
        assert d.hamming() == 2;
    }

    @Test
    public void manhattan() throws Exception {
        Board a = new Board(new int[][]{{1, 2}, {0, 3}});
        Board b = new Board(new int[][]{{1, 2}, {3, 0}});
        Board c = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        Board d = new Board(new int[][]{{0, 2, 3}, {4, 1, 6}, {7, 8, 5}});
        assert a.manhattan() == 1;
        assert b.manhattan() == 0;
        assert c.manhattan() == 0;
        assert d.manhattan() == 4;
    }

}