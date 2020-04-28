public class GameMineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."},
                {"*", ".", "*", ".", "."}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;
        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        for (int y =0; y< MAP_HEIGHT;y++){
            for (int x =0; x< MAP_WIDTH;x++){
                String curentCell = map[y][x];
                if (curentCell.equals("*")){
                    mapReport[y][x] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {y - 1, x - 1}, {y - 1, x}, {y - 1, x + 1},
                            {y, x - 1}, {y, x + 1},
                            {y + 1, x - 1}, {y + 1, x}, {y + 1, x + 1},
                    };
                    int minesAround =0;
                    for (int i=0; i < NEIGHBOURS_ORDINATE.length;i++){
                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                        int xNeighbour = neighbourOrdinate[1];
                        int yNeighbour = neighbourOrdinate[0];
                        boolean isOutOfMapNeighbour = xNeighbour < 0
                                || xNeighbour == MAP_WIDTH
                                || yNeighbour < 0
                                || yNeighbour == MAP_HEIGHT;
                        if (isOutOfMapNeighbour) continue;
                        boolean isMineOwnerNeighbour = map[yNeighbour][xNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }
                    mapReport[y][x] = String.valueOf(minesAround);
                }
            }
        }
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                String currentCellReport = mapReport[y][x];
                System.out.print(currentCellReport + "\t");
            }
            System.out.println("\n");
        }

    }
}
