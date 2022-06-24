package com.example.bestix.infrastructure.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

public class BetResult {
    private int idMatch;
    private int hasWin;

    public BetResult(int idMatch, int hasWin) {
        this.idMatch = idMatch;
        this.hasWin = hasWin;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getHasWin() {
        return hasWin;
    }

    public void setHasWin(int hasWin) {
        this.hasWin = hasWin;
    }
}
