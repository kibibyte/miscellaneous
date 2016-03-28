package com.examples.phrase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhraseIndexerDbImpl {

    private String inputFilePath = null;
    private String indexDirectoryPath = null;
    private Connection dbConnection = null;

    public PhraseIndexerDbImpl(String inputFilePath, String indexDirectoryPath) {
        this.inputFilePath = inputFilePath;
        this.indexDirectoryPath = indexDirectoryPath;
    }

    public void indexMostFrequentPhrases() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
                Statement stmt = dbConnection.createStatement()) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] phrases = line.split("\\|");
                for (String phrase : phrases) {
                    phrase = phrase.toLowerCase().trim();
                    stmt.executeUpdate("INSERT INTO most_frequent_phrases VALUES (" + phrase.hashCode() + "," + 1
                            + ",'" + phrase + "') ON DUPLICATE KEY UPDATE FREQUENCY = FREQUENCY+1");
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error updating database", e);
        } catch (IOException e) {
            throw new IllegalStateException("Error reading input file", e);
        }
    }

    public List<PhraseFrequency> getMostFrequentPhrases(int limit, int offset, int minimalFrequency) {
        List<PhraseFrequency> phraseFrequencies = new ArrayList<PhraseFrequency>();
        try (Statement stmt = dbConnection.createStatement();
                ResultSet resultSet =
                        stmt.executeQuery("SELECT * FROM most_frequent_phrases WHERE frequency>" + minimalFrequency
                                + "ORDER BY frequency DESC LIMIT " + offset + "," + limit)) {
            while (resultSet.next()) {
                phraseFrequencies
                        .add(new PhraseFrequency(resultSet.getString("phrase"), resultSet.getInt("frequency")));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error reading from database", e);
        }
        return phraseFrequencies;
    }

    public void init() {
        try {
            dbConnection = DriverManager.getConnection("jdbc:h2:" + indexDirectoryPath + ";mode=MySQL", "test", "");
        } catch (SQLException e) {
            throw new IllegalStateException("Database connection error", e);
        }
        try (Statement stmt = dbConnection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS most_frequent_phrases(id INT PRIMARY KEY,frequency INT, phrase VARCHAR(255), INDEX(frequency))");
            stmt.executeUpdate("TRUNCATE TABLE most_frequent_phrases");
        } catch (SQLException e) {
            throw new IllegalStateException("Error occured while initializing database", e);
        }
    }

    public void close() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Error closing database", e);
        }
    }


}
