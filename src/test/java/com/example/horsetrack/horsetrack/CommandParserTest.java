package com.example.horsetrack.horsetrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    CommandParser commandParser = new CommandParser();

    @Test
    public void invalid_command(){
        CommandInfo info = commandParser.parse("no-match-value", "some-input");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("Invalid Command:no-match-value some-input", info.getMessage());
    }

    @Test
    public void bet_valid_amount(){
        CommandInfo info = commandParser.parse("3", "5");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert info.isBet();
        assertEquals(3, info.getBetHorse());
        assertEquals(5, info.getBetAmount());
        assertEquals("", info.getMessage());
    }

    @Test
    public void bet_invalid_amount(){
        CommandInfo info = commandParser.parse("3", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert info.isBet();
        assertEquals("Invalid Bet: 2.5", info.getMessage());
    }

    @Test
    public void reset_winning_upper_case_invalid_amount(){
        CommandInfo info = commandParser.parse("W", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("Invalid Bet Amount: 2.5", info.getMessage());
    }

    @Test
    public void reset_winning_lower_case_invalid_amount(){
        CommandInfo info = commandParser.parse("w", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("Invalid Bet Amount: 2.5", info.getMessage());
    }

    @Test
    public void reset_winning_lower_case(){
        CommandInfo info = commandParser.parse("w", "2");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }

    @Test
    public void reset_winning_upper_case(){
        CommandInfo info = commandParser.parse("W", "2");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }

    @Test
    public void quit_upper_case(){
        CommandInfo info = commandParser.parse("Q", "");
        assert info.isValid();
        assert info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }

    @Test
    public void quit_lower_case(){
        CommandInfo info = commandParser.parse("q", "");
        assert info.isValid();
        assert info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }

    @Test
    public void restock_lower_case(){
        CommandInfo info = commandParser.parse("r", "");
        assert info.isValid();
        assert !info.isQuit();
        assert info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }

    @Test
    public void restock_upper_case(){
        CommandInfo info = commandParser.parse("R", "");
        assert info.isValid();
        assert !info.isQuit();
        assert info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assertEquals("", info.getMessage());
    }


}