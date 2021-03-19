package tictactoe;

public final class Resources {
    public static final class AnsiColor {
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }

    public static final class AnsiArt {
        public static final String SPLASH = """
                    $$$$$$$$\\ $$\\                $$$$$$$$\\                       $$$$$$$$\\                  
                    \\__$$  __|\\__|               \\__$$  __|                      \\__$$  __|                 
                       $$ |   $$\\  $$$$$$$\\         $$ | $$$$$$\\   $$$$$$$\\         $$ | $$$$$$\\   $$$$$$\\  
                       $$ |   $$ |$$  _____|$$$$$$\\ $$ | \\____$$\\ $$  _____|$$$$$$\\ $$ |$$  __$$\\ $$  __$$\\ 
                       $$ |   $$ |$$ /      \\______|$$ | $$$$$$$ |$$ /      \\______|$$ |$$ /  $$ |$$$$$$$$ |
                       $$ |   $$ |$$ |              $$ |$$  __$$ |$$ |              $$ |$$ |  $$ |$$   ____|
                       $$ |   $$ |\\$$$$$$$\\         $$ |\\$$$$$$$ |\\$$$$$$$\\         $$ |\\$$$$$$  |\\$$$$$$$\\ 
                       \\__|   \\__| \\_______|        \\__| \\_______| \\_______|        \\__| \\______/  \\_______|
                                                                                                            
                                                       [ PRESS ANY KEY ]                                   
                                                                                                            
                """;
        public static final String GAME_OVER = """
                 $$$$$$\\                                           $$$$$$\\                                 
                $$  __$$\\                                         $$  __$$\\                                
                $$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$ /  $$ |$$\\    $$\\  $$$$$$\\   $$$$$$\\  
                $$ |$$$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\       $$ |  $$ |\\$$\\  $$  |$$  __$$\\ $$  __$$\\ 
                $$ |\\_$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |      $$ |  $$ | \\$$\\$$  / $$$$$$$$ |$$ |  \\__|
                $$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|      $$ |  $$ |  \\$$$  /  $$   ____|$$ |      
                \\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\        $$$$$$  |   \\$  /   \\$$$$$$$\\ $$ |      
                 \\______/  \\_______|\\__| \\__| \\__| \\_______|       \\______/     \\_/     \\_______|\\__|      
                                                                                                           
                                                     [ PRESS ANY KEY ]                                     
                                                                                                           
                """;
        public static final String BOARD = """
                ┌─────┬─────┬─────┐
                │ {0} │ {1} │ {2} │
                ├─────┼─────┼─────┤
                │ {3} │ {4} │ {5} │
                ├─────┼─────┼─────┤
                │ {6} │ {7} │ {8} │
                └─────┴─────┴─────┘
                """;
    }

    public static final class PlayerSymbol {
        public static final char PlayerX = 'X';
        public static final char PlayerO = 'O';
    }
}