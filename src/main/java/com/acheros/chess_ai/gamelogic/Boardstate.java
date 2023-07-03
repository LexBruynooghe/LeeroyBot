package com.acheros.chess_ai.gamelogic;

public class Boardstate {

    public static final String STARTFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private PlayerColor turn;
    private boolean blackCanCastleShort;
    private boolean blackCanCastleLong;
    private boolean whiteCanCastleShort;
    private boolean whiteCanCastleLong;
    private String enPassant;
    private int halfmoves;
    private int fullmoves;
    private Board board;

    public void executeMove(Move move) {
        board.executeMove(move);
    }

    public Boardstate(Board board, PlayerColor playerColor, boolean blackCanCastleShort, boolean blackCanCastleLong, boolean whiteCanCastleShort, boolean whiteCanCastleLong, String enPassant, int halfmoves, int fullmoves) {
        this.board = board;
        this.turn = playerColor;
        this.blackCanCastleShort = blackCanCastleShort;
        this.blackCanCastleLong = blackCanCastleLong;
        this.whiteCanCastleShort = whiteCanCastleShort;
        this.whiteCanCastleLong = whiteCanCastleLong;
        this.enPassant = enPassant;
        this.halfmoves = halfmoves;
        this.fullmoves = fullmoves;
    }

    public Boardstate(String FEN) {
        String[] fenArgs = FEN.split(" ",6);

        board = new Board(fenArgs[0]);

        turn = fenArgs[1].equals("w") ? PlayerColor.WHITE : PlayerColor.BLACK;

        for (int i=0; i < fenArgs[2].length() ; i++) {
            switch (fenArgs[2].charAt(i)) {
                case 'k' -> blackCanCastleShort = false;
                case 'q' -> blackCanCastleLong = false;
                case 'K' -> whiteCanCastleShort = false;
                case 'Q' -> whiteCanCastleLong = false;
            }
        }

        if (!fenArgs[3].equals("-")) {
            enPassant = fenArgs[3];
        }

        halfmoves = Integer.parseInt(fenArgs[4]);
        fullmoves = Integer.parseInt(fenArgs[5]);
    }

    public PlayerColor getTurn() {
        return turn;
    }

    public void setTurn(PlayerColor turn) {
        this.turn = turn;
    }

    public boolean isBlackCanCastleShort() {
        return blackCanCastleShort;
    }

    public void setBlackCanCastleShort(boolean blackCanCastleShort) {
        this.blackCanCastleShort = blackCanCastleShort;
    }

    public boolean isBlackCanCastleLong() {
        return blackCanCastleLong;
    }

    public void setBlackCanCastleLong(boolean blackCanCastleLong) {
        this.blackCanCastleLong = blackCanCastleLong;
    }

    public boolean isWhiteCanCastleShort() {
        return whiteCanCastleShort;
    }

    public void setWhiteCanCastleShort(boolean whiteCanCastleShort) {
        this.whiteCanCastleShort = whiteCanCastleShort;
    }

    public boolean isWhiteCanCastleLong() {
        return whiteCanCastleLong;
    }

    public void setWhiteCanCastleLong(boolean whiteCanCastleLong) {
        this.whiteCanCastleLong = whiteCanCastleLong;
    }

    public String getEnPassant() {
        return enPassant;
    }

    public void setEnPassant(String enPassant) {
        this.enPassant = enPassant;
    }

    public int getHalfmoves() {
        return halfmoves;
    }

    public void setHalfmoves(int halfmoves) {
        this.halfmoves = halfmoves;
    }

    public int getFullmoves() {
        return fullmoves;
    }

    public void setFullmoves(int fullmoves) {
        this.fullmoves = fullmoves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
